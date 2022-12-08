package use_cases.display_week_use_case;

import java.time.LocalDateTime;

public class DisplayWeekRequestModel {
    private String day;
    public DisplayWeekRequestModel(String day){
        this.day = day;
    }
    public String getDay (){
        return this.day;
    }
}
