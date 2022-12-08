package use_cases.modify_event_use_case;

import java.time.LocalDateTime;

public class EventModifierRequestModel {
    private final String name;
    private final LocalDateTime startTime;
    private  final LocalDateTime endTime;
    private final int commuteTime;

    private final boolean isCommute;

    private final String location;

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

    public int getCommute(){return commuteTime;}

    public boolean getIsCommute(){return isCommute;}

    public String getLocation(){return location;}

    public String getEventType(){return eventType;}
}
