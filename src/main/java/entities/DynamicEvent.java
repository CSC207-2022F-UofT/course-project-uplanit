/*
This is the DynamicEvent Entity;

 */

package entities;

import java.sql.Time;
import java.time.LocalDateTime;


public class DynamicEvent implements Event{

    /** Constructs a DynamicEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param commute the time it takes to get to this event
     * @param location the location of the event to be created
     */
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isCommute;
    private String location;
    private Event commute;


    public DynamicEvent(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute, Event commute, String location){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commute = commute;
        this.location = location;
        this.isCommute = isCommute;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Event getCommute() {
        return this.commute;
    }
    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }
    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }
    @Override
    public String getLocation() {
        return location;
    }
    @Override
    public boolean isCommute(){
        return this.isCommute;
    }

    @Override
    public boolean isValid() {
        if (endTime.isBefore(startTime)) {
            return false;
        }
        return true;
    }
}
