package use_cases.delete_event_use_case;
import java.time.LocalDateTime;

// Use case layer

public class DeleteEventRequestModel {


    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isCommute = false;
    private int commute;
    private String location;
    private String eventType;


    public DeleteEventRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                                      int commute, String location, String eventType) {

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commute = commute;
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

    int getCommute() {
        return this.commute;
    }

    String getLocation() {
        return this.location;
    }
}

