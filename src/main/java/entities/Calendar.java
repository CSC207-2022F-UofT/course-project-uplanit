package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

public class Calendar {
    public HashMap<Date, Week> weekMaps; // Hashmap containing Week objects and the first day of their week
                                        // a Date object.

    private List<Event> idealRecurrentEventsOdd;
    private List<Event> idealRecurrentEventsEven;

    private HashMap<String, Duration> idealGoalMap;

    // we are still missing the ideal week stuff. addNextSixMonths method may be removed later.

    public Calendar() {
        this.weekMaps = new HashMap<>();

        // Find the first day (Sunday) of the starting week as a Date object
        Date today = java.util.Calendar.getInstance().getTime();

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(today);

        while (cal.get(java.util.Calendar.DAY_OF_WEEK) > cal.getFirstDayOfWeek()) {
            cal.add(java.util.Calendar.DATE, -1);
        }

        Week firstWeek = new Week(cal.getTime(), new HashMap<>(), new ArrayList<>());

        this.weekMaps.put(cal.getTime(), firstWeek);

        this.idealRecurrentEventsOdd = new ArrayList<>();
        this.idealRecurrentEventsEven = new ArrayList<>();

        this.idealGoalMap = new HashMap<>();
    }
    public Date getNextSunday(Date Sunday){

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(Sunday);
        cal.add(java.util.Calendar.DATE, 7);
        return cal.getTime();

    }
    public void addNextWeek(Date firstDayOfCurrentWeek, boolean isOddWeek){

        if (isOddWeek) {
            this.weekMaps.put(getNextSunday(firstDayOfCurrentWeek),
                    new Week(getNextSunday(firstDayOfCurrentWeek), idealGoalMap, idealRecurrentEventsEven));
        }


        else{
            this.weekMaps.put(getNextSunday(firstDayOfCurrentWeek),
                    new Week(getNextSunday(firstDayOfCurrentWeek), idealGoalMap, idealRecurrentEventsOdd));
        }

    }

    public void addIdealRecurrentEvent(Event recurrentEvent, boolean isOddWeek){
        if (isOddWeek) {
            this.idealRecurrentEventsOdd.add(recurrentEvent);
        }

        else{
            this.idealRecurrentEventsEven.add(recurrentEvent);
        }
    }

    public Week getWeek(Date startDate){
        return this.weekMaps.get(startDate);
        }

    public ArrayList<Week> getAllWeeks(){
        return new ArrayList<>(this.weekMaps.values());
    }

    public List<Event> getIdealRecurrentEventsEven(){
        return this.idealRecurrentEventsEven;
    }

    public void setIdealRecurrentEventsEven(List<Event> eventList){
        this.idealRecurrentEventsEven = eventList;
    }

    public List<Event> getIdealRecurrentEventsOdd() {
        return this.idealRecurrentEventsOdd;
    }
    public void setIdealRecurrentEventsOdd(List<Event> eventList){
        this.idealRecurrentEventsOdd = eventList;
    }


}