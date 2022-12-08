package use_cases.modify_event_use_case;

import java.time.LocalDateTime;

public class EventModifierRequestModel {
    private String name;
    private LocalDateTime startTime;
    private  LocalDateTime endTime;
    private int commuteTime;

    private boolean isCommute;

    private String location;

    private final String eventType;

    public EventModifierRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, int commuteTime,
                                     boolean isCommute, String location, String eventType){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;
        this.eventType = eventType;
        this.isCommute = isCommute;
    }

    public String getName(){return name;}

    public LocalDateTime getStartTime(){return startTime;}

    public LocalDateTime getEndTime(){return endTime;}

    public int getCommuteTime(){return commuteTime;}

    public boolean getIsCommute(){return isCommute;}

    public String getLocation(){return location;}

    public String getEventType(){return eventType;}

    public void setName(String name){this.name = name;}

    public void setStartTime(LocalDateTime startTime){this.startTime = startTime;}

    public void setEndTime(LocalDateTime endTime){this.endTime = endTime;}

    public void setCommuteTime(int commuteTime){this.commuteTime = commuteTime;}

    public void setIsCommute(boolean isCommute){this.isCommute = isCommute;}

    public void setLocation(String location){this.location = location;}

}
