package entities;

import java.sql.Time;
import java.util.Date;

public class Event {
    public String name;
    public Time commuteTime = new Time(0);
    public Date startTime;
    public Date endTime;
    // default for location is null so check that in code to check if the event has a location or not
    public String location;


    /**
     * Constructs an event with only a name, startTime, and endTime.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     */
    public Event(String name, Date startTime, Date endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    /**
     * Constructs an event with only a name, startTime, and endTime.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     * @param commuteTime the commute time to get to the event
     */
    public Event(String name, Date startTime, Date endTime, Time commuteTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
    }


    /**
     * Constructs an event with a name, startTime, endTime, and location.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     * @param location the location of the event
     */
    public Event(String name, Date startTime, Date endTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }


    /**
     * Constructs an event with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     * @param commuteTime the commute time to get to the event
     * @param location the location of the event
     */
    public Event(String name, Date startTime, Date endTime, Time commuteTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;
    }

}
