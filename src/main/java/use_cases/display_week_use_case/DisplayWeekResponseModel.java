package use_cases.display_week_use_case;

// Response model:
// {{Monday event 1, Monday event 2, ...},
// {tuesday event 1, tuesday event 2, ...},
// ...
// {Sunday event 1, sunday event 2, ...}}
// event format: right now, it can just be a list of string with {event.name, event.type, event.date}

import java.util.ArrayList;

public class DisplayWeekResponseModel {
    private ArrayList<ArrayList<ArrayList<String>>> week;

    public DisplayWeekResponseModel(ArrayList<ArrayList<ArrayList<String>>> week){
        this.week = week;
    }

    public ArrayList<ArrayList<ArrayList<String>>> getWeek() {
        return week;
    }
}
