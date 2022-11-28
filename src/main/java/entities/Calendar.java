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

        Week firstWeek = new Week(cal.getTime(), new HashMap<>(), new ArrayList<>(), true);

        this.weekMaps.put(cal.getTime(), firstWeek);

        this.idealRecurrentEventsOdd = new ArrayList<>();
        this.idealRecurrentEventsEven = new ArrayList<>();

        this.idealGoalMap = new HashMap<>();
    }
    public Date getSunday(Date day){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(day);

        while (cal.get(java.util.Calendar.DAY_OF_WEEK) > cal.getFirstDayOfWeek()) {
            cal.add(java.util.Calendar.DATE, -1);
        }
        return cal.getTime();
    }

    public Date getNextSunday(Date Sunday){

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(Sunday);
        cal.add(java.util.Calendar.DATE, 7);
        return cal.getTime();

    }
    public void addNextWeek(Week week){

        if (week.getIsOdd()) {
            this.weekMaps.put(getNextSunday(week.getWeekStart()),
                    new Week(getNextSunday(week.getWeekStart()), idealGoalMap, idealRecurrentEventsEven, false));
        }


        else{
            this.weekMaps.put(getNextSunday(week.getWeekStart()),
                    new Week(getNextSunday(week.getWeekStart()), idealGoalMap, idealRecurrentEventsOdd, true));
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
    public void removeIdealRecurrentEvent(Event recurrentEvent) throws Exception {
        if (this.idealRecurrentEventsOdd.contains(recurrentEvent)){
            this.idealRecurrentEventsOdd.remove(recurrentEvent);
        }
        else this.idealRecurrentEventsEven.remove(recurrentEvent);
        throw new Exception("This event type is invalid.");
        }

    public void addIdealGoal(String goal, long goalTimeInMinutes){
        this.idealGoalMap.put(goal, Duration.ofMinutes(goalTimeInMinutes));
    }

    public void addIdealGoalTime(String goal, long minuteDiff){
        Duration x = this.idealGoalMap.get(goal).plusMinutes(minuteDiff);
        this.idealGoalMap.put(goal, x);
    }

    public void removeIdealGoal(String goal){
        this.idealGoalMap.remove(goal);
    }

    public Week getWeek(Date startDate){
        return this.weekMaps.get(startDate);
        }

    public ArrayList<Week> getAllWeeks(){
        return new ArrayList<>(this.weekMaps.values());
    }



}