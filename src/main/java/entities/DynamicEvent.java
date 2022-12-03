/*
This is the DynamicEvent Entity;

 */

package entities;

import java.sql.Time;
import java.time.LocalDateTime;


public class DynamicEvent extends Event{

    private String dynamicGoal;

    /** Constructs a DynamicEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param commute the time it takes to get to this event
     * @param location the location of the event to be created
     */
    public DynamicEvent(String name, LocalDateTime startTime, LocalDateTime endTime, Boolean isCommute, Event commute, String location){
        super(name, startTime, endTime, isCommute, commute, location);
    }

    public String getDynamicGoal(){
        return this.dynamicGoal;
    }

    public void setDynamicGoal(String dynamicGoal){
        this.dynamicGoal = dynamicGoal;
    }

}
