/*
This is the RecurrentEvent Entity;

 */

package entities;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class RecurrentEvent extends Event {

    private boolean isBiweekly;

    /**
     * Constructs a RecurringEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param commuteTime the time it takes to get to this event
     * @param location the location of the event to be created
     */
    public RecurrentEvent(String name, LocalDateTime startTime, LocalDateTime endTime, Event commuteTime, String location) {
        super(name, startTime, endTime, commuteTime, location);
        this.isBiweekly = false;
    }


    /**
     *
     *
     * @return
     */
    public Boolean getHappensBiweekly(){
        return this.isBiweekly;
    }

    public void setHappensBiweekly(Boolean happensBiweekly) {
        this.isBiweekly = happensBiweekly;
    }

}
