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

    private static Calendar current;

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

    public boolean calculateIsOdd(LocalDate newMonday){
        long diff = this.originalMonday.until(newMonday, ChronoUnit.WEEKS);
        return (diff%2 == 0);
    }
    public void addWeek(LocalDate newMonday){
        //Creates a new week starting on newMonday, drawing from its correspondent idealWeek.
        if (calculateIsOdd(newMonday)){
            Week w = idealWeekOdd.getCopyWithNewDate(newMonday, true);
            this.weekMap.put(newMonday, w);
        }
        else {
            Week w = idealWeekEven.getCopyWithNewDate(newMonday, false);
            this.weekMap.put(newMonday, w);

        }
    }

    public Week getOddIdealWeek(){
        return this.idealWeekOdd;
    }

    public Week getEvenIdealWeek(){
        return this.idealWeekEven;
    }

    public Week getWeek(LocalDate startDate){
        /*
        Gets the real week that corresponds to startDate. If there is none, returns null.
        If a real week is needed (such as for adding an event), call addWeek.
        If it is looking for a displayable week, call getCorrespondingIdealWeek
         */
        if (this.weekMap.containsKey(startDate)){
            this.weekMap.get(startDate);
        }
        return null;
    }

    public Week getCorrespondingIdealWeek(LocalDate target){
        //Gets the ideal week that corresponds to target date. For display purposes.
        if (this.calculateIsOdd(target)){
            return this.idealWeekOdd;
        }
        return this.idealWeekEven;
    }

    public ArrayList<Week> getAllWeeks(){
        return new ArrayList<>(this.weekMap.values());
    }


    // Returns the current calendar which holds the most up to date scheduling information
    public static Calendar getCurrent() {
        return current;
    }

    // Sets a calendar object as the new current calendar (mainly for recreating the calendar from saved data)
    public static void setCurrent(Calendar newCurrent) {
        current = newCurrent;
    }

}