package entities;

import java.sql.Time;
import java.util.Date;


public class SingleEvent extends Event {


    /**
     * Constructs a SingleEvent object with a name, startTime, and endTime.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     */
    public SingleEvent(String name, Date startTime, Date endTime){
        super(name, startTime, endTime);
    }


    /**
     * Constructs a SingleEvent object with a name, startTime, endTime, and commuteTime.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     * @param commuteTime the commute time to get to the event
     */
    public SingleEvent(String name, Date startTime, Date endTime, Time commuteTime){
        super(name, startTime, endTime, commuteTime);
    }


    /**
     * Constructs a SingleEvent object with a name, startTime, endTime, and location.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     * @param location the location of the event
     */
    public SingleEvent(String name, Date startTime, Date endTime, String location){
        super(name, startTime, endTime, location);
    }


    /**
     * Constructs a SingleEvent object with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event
     * @param startTime the time the event starts at
     * @param endTime the time the event ends at
     * @param commuteTime the commute time to get to the event
     * @param location the location of the event
     */
    public SingleEvent(String name, Date startTime, Date endTime, Time commuteTime, String location){
        super(name, startTime, endTime, commuteTime, location);
    }
}
