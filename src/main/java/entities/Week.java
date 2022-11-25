package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Week {
    private Date weekStart;
    private List<Event> events;
    private HashMap<String, Duration> goalMap; //map tying goal names to time objects (goal counters)
    private List<Deadline> deadlines; //deadline names to deadline objects


    public Week(Date startDate, HashMap<String, Duration> idealGoalMap, List<Event> idealRecurrentEvents){
        this.weekStart = startDate;
        this.goalMap = idealGoalMap;
        this.events = idealRecurrentEvents;
        this.deadlines = new ArrayList<Deadline>();
    }


    public HashMap<String, Duration> getGoalMap(){
        return this.goalMap;
    }

    public List<Event> getEvents(){
        return this.events;
    }

    public List<Deadline> getDeadlines(){
        return this.deadlines;
    }

    public Date getStartTime(){
        return this.weekStart;
    }


    public void addGoal(String name, long minutesPerWeek){
        this.goalMap.put(name, Duration.ofMinutes(minutesPerWeek));
    }


    public void addEvent(Event newEvent){
        /*
        Expects a "clean" event, i.e. does not check to see if there is conflict.
        If checking for conflict is necessary, checkConflict must be called by whomever is calling this function.
         */
        this.events.add(newEvent);
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
            if (newEvent.startTime.before(e.endTime) && newEvent.endTime.after(e.startTime)){
                return true;
            }
        }
        return false;
    }


    public void modifyGoalTime(String goal, long minuteDiff){
        // Duration in minutes gets added to the goal. To subtract, use a negative integer. Cannot go below 0.
        Duration x = this.goalMap.get(goal).plusMinutes(minuteDiff);
        if (x.isNegative()) {
            this.goalMap.put(goal, Duration.ofMinutes(0));
        }
        else {
            this.goalMap.put(goal, x);
        }
    }
}
