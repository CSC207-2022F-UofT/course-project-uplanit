package use_cases.add_dynamic_event_use_case;

import entities.Event;

import java.time.LocalDateTime;

// Use Case Layer
public class AddDynamicEventRequestModel {

    private String name;
    private Event commute;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;


    public AddDynamicEventRequestModel(String name, Event commute, LocalDateTime startTime, LocalDateTime endTime,
                                       String location){
        this.name = name;
        this.commute = commute;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getName(){return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Event getCommute(){return commute; }

    public void setCommute(Event commute) {
        this.commute = commute;
    }

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
}
