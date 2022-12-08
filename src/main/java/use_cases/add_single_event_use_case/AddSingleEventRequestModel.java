package use_cases.add_single_event_use_case;

import java.time.LocalDateTime;

public class AddSingleEventRequestModel {
    private String name;
    private String startTime;
    private String endTime;
    private String isCommute;
    private String location;
    private String commuteTime;
    private String eventType;


    public AddSingleEventRequestModel(String name, String startTime, String endTime, String commute, String location){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commute;
        this.location = location;
    }
    public String getName() {
        return this.name;
    }

    public String getCommuteTime() {
        return this.commuteTime;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getLocation() {
        return location;
    }

}
