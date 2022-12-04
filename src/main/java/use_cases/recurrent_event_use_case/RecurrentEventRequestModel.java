package use_cases.recurrent_event_use_case;
import java.time.LocalDateTime;

// Use case layer

public class RecurrentEventRequestModel {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isCommute = false;
    private int commute;
    private String location;

    public RecurrentEventRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, int commute,
                                      String location) {

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commute = commute;
        this.location = location;

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
