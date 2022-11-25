/*
This is the RecurrentEvent Entity;

 */

package entities;

import java.sql.Time;
import java.util.Date;

public class RecurrentEvent extends Event {

    private boolean happensBiweekly;

    /** Constructs a RecurringEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param commuteTime the time it takes to get to this event
     * @param location the location of the event to be created
     */
    public RecurrentEvent(String name, Date startTime, Date endTime, Event commuteTime, String location) {
        super(name, startTime, endTime, commuteTime, location);
        this.happensBiweekly = false;
    }

    public Boolean getHappensBiweekly(){
        return this.happensBiweekly;
    }

    public void setHappensBiweekly(Boolean happensBiweekly) {
        this.happensBiweekly = happensBiweekly;
    }

}
