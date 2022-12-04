package entities;
import java.time.LocalDateTime;

// Entity layer

public interface EventFactory {

    /**
     * Returns a newly constructed Event object based on the given input. If eventType is null then it returns null.
     * If an invalid eventType input is given then an exception is thrown.
     * Utilizes the factory design pattern in order to create event objects without directly working with each
     * separate class.
     *
     * @param name the name of the event to construct
     * @param startTime the time that the desired event starts at
     * @param endTime the time that the desired event ends at
     * @param commute the commute time that corresponds to this event
     * @param location the location that the constructed event takes place at
     * @return the desired event, if valid. null if eventType is null.
     */
    Event create(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                 Event commute, String location);

}