package use_cases.display_week_use_case;

import java.time.LocalDateTime;

public class DisplayWeekRequestModel {
    private LocalDateTime day;
    public DisplayWeekRequestModel(LocalDateTime day){
        this.day = day;
    }
    public LocalDateTime getDay (){
        return this.day;
    }
}
