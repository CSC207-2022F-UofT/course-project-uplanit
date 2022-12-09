package use_cases.dynamic_goal_statistics_use_case;

import java.time.LocalDateTime;

public class DynEventDsRequestModel {
    private final String eventName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public DynEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.eventName = name;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public String getEventName() {
        return this.eventName;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }
}
