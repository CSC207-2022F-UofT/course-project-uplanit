package use_cases.delete_event_use_case;
import java.time.LocalDateTime;

// Use case layer

public class DeleteEventDsRequestModel {


    private final String name;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final int commuteTime;
    private final boolean isCommute;
    private final String location;
    private final String eventType;


    public DeleteEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                                        int commuteTime, String location, String eventType) {

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isCommute = isCommute;
        this.commuteTime = commuteTime;
        this.location = location;
        this.eventType = eventType;

    }


    public String getName() {
        return this.name;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public int getCommuteTime() {
        return this.commuteTime;
    }

    public boolean getIsCommute() {
        return this.isCommute;
    }

    public String getLocation() {
        return this.location;
    }

    public String getEventType() {
        return this.eventType;
    }

}
