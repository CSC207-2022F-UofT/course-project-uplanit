package entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Calendar {
    public HashMap<Date, Week> weekMaps; // a list of week-map


    public Calendar() {
        Date today = java.util.Calendar.getInstance().getTime();
        weekMaps = new ArrayList<Map<Date,Date>>();
    }


    public void StoreWeekMaps(Map<Event, Date> week) {
        weekMaps.add(week);
    }


    public String AlertConflict() {
        for(int i = 0; i < weekMaps.size(); i++){
            // again, this part depends on how the Week Class is implemented
            // once you have the Week Class, replace if condition with relevant code
            if(i == weekMaps.size() - 1) {
                return "bruh there's conflict fix it";
            }
        }
        // if there is no conflict
        return null;
    }

}