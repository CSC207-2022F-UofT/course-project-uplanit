package use_cases.dynamic_goal_statistics_use_case;

import java.time.LocalDateTime;

public class DynEventDsRequestModel {
    private String eventName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public DynEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.eventName = name;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String newName){
        this.eventName = newName;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime newTime){
        this.startTime = newTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime newTime){
        this.endTime = newTime;
    }
}
