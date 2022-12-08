package use_cases.recurrent_event_use_case;
import java.time.LocalDateTime;

// Use class layer

public class RecurrentEventDsRequestModel {

    private final String name;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final int commuteTime;

    private final boolean isCommute;
    private final String location;

    private final String eventType;


    public RecurrentEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                                        int commuteTime, String location, String eventType) {

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isCommute = isCommute;
        this.commuteTime = commuteTime;
        this.location = location;
        this.eventType = eventType;

    }


    String getName() {
        return this.name;
    }

    LocalDateTime getStartTime() {
        return this.startTime;
    }

    LocalDateTime getEndTime() {
        return this.endTime;
    }

    int getCommuteTime() {
        return this.commuteTime;
    }

    boolean getIsCommute() {
        return this.isCommute;
    }

    String getLocation() {
        return this.location;
    }

    String getEventType() {
        return this.eventType;
    }




}
