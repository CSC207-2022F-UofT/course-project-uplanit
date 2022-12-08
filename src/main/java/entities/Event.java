package entities;
import java.time.LocalDateTime;

// Entity layer

public interface Event {

    public String getName();

    public Event getCommute();

    public LocalDateTime getStartTime();

    public LocalDateTime getEndTime();

    public String getLocation();

    public boolean isCommute();


    /**
     * Events must have a start time before their end time and occur within one calendar day to be valid.
     *
     * @return true if valid, false if either of these conditions are violated.
     */
    public boolean isValid();


}
