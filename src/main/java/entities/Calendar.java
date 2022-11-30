package entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.temporal.ChronoUnit;
public class Calendar {
    public HashMap<LocalDate, Week> weekMap; // Hashmap containing Week objects and the first day of their week
    // a Date object.

    private Week idealWeekOdd;
    private Week idealWeekEven;

    private LocalDate originalMonday;

    private HashMap<String, ArrayList<Event>> recurrentEventLists;

    // we are still missing the ideal week stuff. addNextSixMonths method may be removed later.

    public Calendar() {
        this.weekMap = new HashMap<>();

        LocalDate today = LocalDate.now();
        this.originalMonday = getMonday(today);

        Week firstWeek = new Week(this.originalMonday, new HashMap<>(), new ArrayList<>(), true);
        this.weekMap.put(this.originalMonday, firstWeek);
        this.idealWeekOdd = new Week(this.originalMonday.minusWeeks(2), new HashMap<>(), new ArrayList<>(), true);
        this.idealWeekEven = new Week(this.originalMonday.minusWeeks(1), new HashMap<>(), new ArrayList<>(), false);
        this.recurrentEventLists = new HashMap<String, ArrayList<Event>>();

    }
    public LocalDate getMonday(LocalDate day){
        return day.minusDays((day.getDayOfWeek().getValue()-1));
    }

    private boolean calculateIsOdd(LocalDate newMonday){
        long diff = this.originalMonday.until(newMonday, ChronoUnit.WEEKS);
        return (diff%2 == 0);
    }
    private void addWeek(LocalDate newMonday){
        if (calculateIsOdd(newMonday)){
            Week w = idealWeekOdd.getCopyWithNewDate(newMonday, true);
            this.weekMap.put(newMonday, w);
        }
        else {
            Week w = idealWeekEven.getCopyWithNewDate(newMonday, false);
            this.weekMap.put(newMonday, w);

        }
    }

    public void addIdealEvent(RecurrentEvent e){
        if (e.getHappensBiweekly()){
            if (this.calculateIsOdd(e.getStartTime().toLocalDate())){
                idealWeekOdd.addEvent(e);
            }
            else{
                idealWeekEven.addEvent(e);
            }
        }
        else {
            idealWeekOdd.addEvent(e);
            idealWeekEven.addEvent(e);
        }
    }
    //TOP FUNCTION MIGHT BREAK: WE NEED TO MAKE SURE THE DATE IN THE OBJECT IS CORRECT.

    public void addOddIdealGoal(String goal, long goalTimeInMinutes){
        idealWeekOdd.addGoal(goal, goalTimeInMinutes);
    }

    public void addEvenIdealGoal(String goal, long goalTimeInMinutes){
        idealWeekEven.addGoal(goal, goalTimeInMinutes);
    }

    public void addOddIdealGoalTime(String goal, long minuteDiff){
        idealWeekOdd.addGoalTime(goal, minuteDiff);
    }
    public void addEvenIdealGoalTime(String goal, long minuteDiff){
        idealWeekEven.addGoalTime(goal, minuteDiff);
    }


    public void removeIdealGoal(String goal){
        this.idealGoalMap.remove(goal);
    }
    public void removeIdealEvent(Event e) throws Exception {
        if (idealWeekEven.getEvents().contains(e)){
            idealWeekEven.getEvents().remove(e);
        }
        else idealWeekOdd.getEvents().remove(e);
        throw new Exception("This event type is invalid.");
    }

    //RILEY PLS FIX EXCEPTION

    public Week getWeek(LocalDate startDate){
        return this.weekMap.get(startDate);
    }

    public ArrayList<Week> getAllWeeks(){
        return new ArrayList<>(this.weekMap.values());
    }



}