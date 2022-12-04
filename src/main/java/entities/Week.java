package entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;


public class Week {
    private final LocalDate weekStart;
    private ArrayList<Event> events;
    private HashMap<String, Duration> goalMap; //map tying goal names to time objects (goal counters)
    private ArrayList<Deadline> deadlines; //deadline names to deadline objects

    private boolean isOdd;


    /**
     * Construct a new week with the given specifications.
     *
     * @param startDate the date of the first sunday of this week
     * @param idealGoalMap
     * @param idealRecurrentEvents
     * @param odd
     */
    public Week(LocalDate startDate, HashMap<String, Duration> idealGoalMap, ArrayList<Event> idealRecurrentEvents, boolean odd){
        this.weekStart = startDate;
        this.goalMap = idealGoalMap;
        this.events = idealRecurrentEvents;
        this.deadlines = new ArrayList<>();
        this.isOdd = odd;
    }


    public HashMap<String, Duration> getGoalMap(){
        return this.goalMap;
    }

    public HashMap<String, Duration> getGoalMapCopy(){
        HashMap<String, Duration> copy = new HashMap<String, Duration>(this.goalMap);
        return copy;
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public ArrayList<Deadline> getDeadlines(){
        return this.deadlines;
    }

    public LocalDate getStartTime(){
        return this.weekStart;
    }

    public void addGoal(String name, long minutesPerWeek){
        this.goalMap.put(name, Duration.ofMinutes(minutesPerWeek));
    }

    public void addEvent(Event newEvent){
            this.events.add(newEvent);
    }

    public void addMultipleEvents(ArrayList<Event> eventList){
        this.events.addAll(eventList);
    }

    public void addDeadline(Deadline d){
        this.deadlines.add(d);
    }

    public void deleteGoal(String s){
        this.goalMap.remove(s);
    }

    public void deleteEvent(Event e){
        this.events.remove(e);
    }

    public void deleteDeadline(Deadline d){
        this.deadlines.remove(d);
    }

    public boolean checkConflict(Event newEvent){
        for (Event e: this.events){
            if (newEvent.getStartTime().isBefore(e.getEndTime()) &&
                    newEvent.getEndTime().isAfter(e.getStartTime())){
                return true;
            }
        }
        return false;
    }

    public void addGoalTime (String goal, long minuteDiff){
        //Duration in minutes gets added to the goal. To subtract, simply use a negative integer. Cannot go below 0.
        Duration x = this.goalMap.get(goal).plusMinutes(minuteDiff);
        if (x.isNegative()) {
            this.goalMap.put(goal, Duration.ofMinutes(0));
        }
        else {
            this.goalMap.put(goal, x);
        }
    }

    public boolean getIsOdd(){
        return this.isOdd;
    }

    public Week getCopyWithNewDate(LocalDate targetMonday, boolean isOdd){
        /*
        Returns a copy of this week with all events/parameters changed to match a new start time.
        Requires the new start time and whether the new week is odd/even with respect to target calendar.
         */
        long d = this.weekStart.until(targetMonday, ChronoUnit.WEEKS);
        ArrayList<Event> newEvents = new ArrayList<Event>();
        for (Event e : this.events){
            if (!e.isCommute()){
                ArrayList<Event> l = e.getCopyWithAddedWeeks(d);
                newEvents.addAll(l);
            }
        }
        Week result = new Week(targetMonday, this.getGoalMapCopy(), newEvents, isOdd);
        return result;
    }
}
