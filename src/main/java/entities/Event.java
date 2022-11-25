/*
This is the Event Entity; It is a parent class to children SingleEvent, RecurrentEvent, and DynamicEvent.

 */

package entities;

import java.sql.Time;
import java.util.Date;

public class Event {
    private String name;
    private Time commuteTime;
    private Date startTime;
    private Date endTime;
    private String location;


    /**
     * Constructs an event with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event (required)
     * @param startTime the time the event starts (required)
     * @param endTime the time the event ends (required)
     * @param commuteTime the commute time to get to the event (optional, may be null)
     * @param location the location of the event (optional, may be null)
     */
    public Event(String name, Date startTime, Date endTime, Time commuteTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getCommuteTime() {
        return commuteTime;
    }

    public void setCommuteTime(Time commuteTime) {
        this.commuteTime = commuteTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addEvent(Week week){
        week.addEvent(this);
    }
}
