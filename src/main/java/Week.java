import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Week {
    private Date weekStart;
    private List<Event> events;
    private HashMap<String, Time> goalMap; //map tying goal names to time objects (counters)

    public Week(Date start, HashMap<String, Time> importedGoalMap, List<Event> importedRecurrentEvents){
        this.weekStart = start;
        this.goalMap = importedGoalMap;
        this.events = importedRecurrentEvents;
    }

    public void setGoalMap(HashMap<String, Time> newGoalMap){
        this.goalMap = newGoalMap;
    }

    public Date getWeekStart(){
        return this.weekStart;
    }

    public List<Event> getEvents(){
        return this.events;
    }

    public boolean checkConflict(Event newEvent){
        for (Event e: this.events){
            if (newEvent.eventStart.before(e.eventEnd) && newEvent.eventEnd.after(e.eventStart)){
                return true;
            }
        }
        return false;
    }

    public void addEvent(Event newEvent){
        this.events.add(newEvent);
    }

}
