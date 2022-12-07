/*
This is the Event Entity; It is a parent class to children SingleEvent, RecurrentEvent, and DynamicEvent.

 */
package entities;
import java.time.LocalDateTime;


public interface Event {

    public String getName();

    public Event getCommute();

    public LocalDateTime getStartTime();

    public LocalDateTime getEndTime();

    public String getLocation();

    public boolean isCommute();

    public boolean isValid();

}
