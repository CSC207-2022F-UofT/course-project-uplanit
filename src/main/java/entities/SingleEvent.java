package entities;

import java.sql.Time;
import java.time.LocalDateTime;

// Entity layer

public class SingleEvent implements Event {


    /**
     * Constructs a SingleEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event (required)
     * @param startTime the time the event starts (required)
     * @param endTime the time the event ends (required)
     * @param commute commute time to get to the event (optional, may be null)
     * @param location the location of the event (optional, may be null)
     */
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isCommute;
    private String location;
    private Event commute;


    public SingleEvent(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute, Event commute, String location){

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
        return startTime.isBefore(endTime) & startTime.getDayOfWeek() == endTime.getDayOfWeek();

    }
}

