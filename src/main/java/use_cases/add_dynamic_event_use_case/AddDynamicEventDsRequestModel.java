package use_cases.add_dynamic_event_use_case;

// Use Case Layer

import entities.Event;

import java.time.LocalDateTime;

public class AddDynamicEventDsRequestModel {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final boolean isCommute;
    private Event commute;
    private String location;
    // private String eventType;


    public AddDynamicEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                                         Event commute, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isCommute = false;
        this.commute = null;
        this.location = location;
    }

    public String getName(){return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Event getCommute(){return commute; }

    public LocalDateTime getStartTime(){return startTime; }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime(){return endTime; }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation(){return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getIsCommute(){return isCommute; }

    // public String getEventType() {return eventType; }

    // public void setEventType(String eventType) {this.eventType = eventType; }
}
