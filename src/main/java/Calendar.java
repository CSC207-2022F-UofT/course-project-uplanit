import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

public class Calendar {
    // This depends on how the Week Class is implemented. Change the ArrayList's content Type if necessary.
    public ArrayList<Map<Event, Date>> weekMaps; // a list of week-map


    public Calendar() {
         weekMaps= new ArrayList<Map<Event,Date>>();
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




