package entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Calendar {
    public HashMap<Date, Week> weekMaps; // Hashmap containing Week objects and the first day of their week
                                        // a Date object.

    public Week idealWeek1;
    public Week idealWeek2;

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
        addNextSixMonths(today);

        this.idealWeek1 = new Week(null, null, null);
        this.idealWeek2 = new Week(null, null, null);
    }

    public void addNextSixMonths(Date today) {
        // for practicality, six months are being considered 27 weeks.
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(today);

        for (int i = 0; i <= 27; i++) {
            cal.add(java.util.Calendar.DATE, 7);
            Week week = new Week(cal.getTime(), new HashMap<>(), new ArrayList<>());
            this.weekMaps.put(cal.getTime(), week);
        }
    }
    public Week getWeek(Date startDate){
        return this.weekMaps.get(startDate);
        }

    public ArrayList<Week> getAllWeeks(){
        return new ArrayList<>(this.weekMaps.values());
    }

    public Week getIdealWeek1(){
        return this.idealWeek1;
    }

    public void setIdealWeek1(Week newIdealWeek1){
        this.idealWeek1 = newIdealWeek1;
    }

    public Week getIdealWeek2(){
        return this.idealWeek2;
    }

    public void setIdealWeek2(Week newIdealWeek2){
        this.idealWeek2 = newIdealWeek2;
    }


}