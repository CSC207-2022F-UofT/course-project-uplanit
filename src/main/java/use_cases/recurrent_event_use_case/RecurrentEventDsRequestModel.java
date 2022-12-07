package use_cases.recurrent_event_use_case;
import java.time.LocalDateTime;

// Use class layer

public class RecurrentEventDsRequestModel {

    private final String name;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final int commuteTime;

    private final boolean isCommute = false;
    private final String location;

    public RecurrentEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime,
                                        int commuteTime, String location) {

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;

    }




}
