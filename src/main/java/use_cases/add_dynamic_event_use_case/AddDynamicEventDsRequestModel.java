package use_cases.add_dynamic_event_use_case;

import entities.Event;

import java.time.LocalDateTime;

// Application Business Rules (Use Case) Layer; Data Structure
public class AddDynamicEventDsRequestModel {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final boolean isCommute;
    private final Event commute;
    private String location;

    /**
     * Construct AddDynamicEventDsRequestModel object given the name, startTime, endTime, isCommute, commute,
     * and location.
     * @param name the name for this event
     * @param startTime the start time for this event
     * @param endTime the end time for this event
     * @param location the location of this event
     */
    public AddDynamicEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, String location){
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

}
