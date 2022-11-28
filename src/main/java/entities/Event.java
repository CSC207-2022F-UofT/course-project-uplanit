/*
This is the Event Entity; It is a parent class to children SingleEvent, RecurrentEvent, and DynamicEvent.

 */

package entities;

import java.sql.Time;
import java.time.LocalDateTime;


public class Event {

    private String name;
    private Event commute;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;


    /**
     * Constructs an event with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event (required)
     * @param startTime the time the event starts (required)
     * @param endTime the time the event ends (required)
     * @param commute the commute time to get to the event (optional, may be null)
     * @param location the location of the event (optional, may be null)
     */
    public Event(String name, LocalDateTime startTime, LocalDateTime endTime, Event commute, String location){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commute = commute;
        this.location = location;
    }


    /**
     * Return the name of this event.
     *
     * @return
     */
    public String getName() {
        return this.name;
    }


    /**
     * Return the commute time event object that correlates to this event.
     *
     * @return
     */
    public Event getCommuteTime() {
        return this.commute;
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


    public void addEvent(Week week){
        week.addEvent(this);
    }
}
