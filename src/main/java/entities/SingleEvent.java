/*
This is the SingleEvent Entity;

 */

package entities;

import java.sql.Time;
import java.time.LocalDateTime;


public class SingleEvent extends Event {


    /**
     * Constructs a SingleEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event (required)
     * @param startTime the time the event starts (required)
     * @param endTime the time the event ends (required)
     * @param commute commute time to get to the event (optional, may be null)
     * @param location the location of the event (optional, may be null)
     */
    public SingleEvent(String name, LocalDateTime startTime, LocalDateTime endTime, Event commute, String location){
        super(name, startTime, endTime, commute, location);
    }
}
