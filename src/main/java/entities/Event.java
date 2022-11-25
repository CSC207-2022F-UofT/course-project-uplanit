/*
This is the Event Entity; It is a parent class to children SingleEvent, RecurrentEvent, and DynamicEvent.

 */

package entities;

import java.sql.Time;
import java.util.Date;

public class Event {
    public String name;
    public Time commuteTime;
    public Date startTime;
    public Date endTime;
    public String location;


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
}
