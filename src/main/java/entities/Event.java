/*
This is the Event Entity; It is a parent class to children SingleEvent, RecurrentEvent, and DynamicEvent.

 */

package entities;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList



public class Event {

    private String name;
    private Event commute;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;

    private final Boolean isCommute;


    /**
     * Constructs an event with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the event (required)
     * @param startTime the time the event starts (required)
     * @param endTime the time the event ends (required)
     * @param commute the commute time to get to the event (optional, may be null)
     * @param location the location of the event (optional, may be null)
     */
    public Event(String name, LocalDateTime startTime, LocalDateTime endTime, Boolean isCommute, Event commute, String location){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commute = commute;
        this.location = location;
        this.isCommute = isCommute;
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
    public Event getCommute() {
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

    public Boolean isCommute(){
        return this.isCommute;
    }

    public ArrayList<Event> getCopyWithAddedWeeks(long d){
        ArrayList<Event> newEvents = new ArrayList<>();
        LocalDateTime newStartTime = this.getStartTime().plusWeeks(d);
        LocalDateTime newEndTime = this.getEndTime().plusWeeks(d);
        if (this.getCommute()!=null){
            Event c = this.getCommute();
            LocalDateTime newStartTimeCommute = c.getStartTime().plusWeeks(d);
            LocalDateTime newEndTimeCommute = c.getEndTime().plusWeeks(d);
            Event newCommute = new Event(c.getName(), newStartTimeCommute, newEndTimeCommute, true, null, c.getLocation());
            Event newEvent = new Event(this.getName(), newStartTime, newEndTime, false, newCommute, this.getLocation());
            newEvents.add(newEvent);
            newEvents.add(newCommute);
        }
        else {
            Event newEvent = new Event(this.getName(), newStartTime, newEndTime, false, null, this.getLocation());
            newEvents.add(newEvent);
        }
        return newEvents;
    }


    public void addEvent(Week week){
        week.addEvent(this);
    }

}
