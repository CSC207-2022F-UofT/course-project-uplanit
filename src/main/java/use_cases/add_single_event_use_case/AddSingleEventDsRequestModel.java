package use_cases.add_single_event_use_case;

import java.time.LocalDateTime;

public class AddSingleEventDsRequestModel {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isCommute;
    private String location;
    private int commuteTime;

    private String eventType;


    public AddSingleEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute, int commute, String location, String type){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commute;
        this.location = location;
        this.isCommute = isCommute;
        this.eventType = type;
    }
    public String getName() {
        return this.name;
    }

    public int getCommuteTime() {
        return this.commuteTime;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public String getLocation() {
        return location;
    }
    public boolean isCommute(){
        return this.isCommute;
    }
    public String getEventType(){
        return this.eventType;
    }

}
