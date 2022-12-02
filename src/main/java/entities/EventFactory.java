package entities;

import java.sql.Time;
import java.time.LocalDateTime;

class EventFactory {


    /**
     * Returns a newly constructed Event object based on the given input. If eventType is null then it returns null.
     * If an invalid eventType input is given then an exception is thrown.
     * Utilizes the factory design pattern in order to create event objects without directly working with each
     * separate class.
     *
     * @param eventType The type of the event to construct (single, recurrent, or dynamic)
     * @param name the name of the event to construct
     * @param startTime the time that the desired event starts at
     * @param endTime the time that the desired event ends at
     * @param commute the commute time that corresponds to this event
     * @param location the location that the constructed event takes place at
     * @return the desired event, if valid. null if eventType is null.
     */
    public static Event getEvent(String eventType,
                          String name, LocalDateTime startTime,
                          LocalDateTime endTime, Boolean isCommute, Event commute,
                          String location) {

        if  (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Not a Valid Event Time");
        }

        if (eventType == null) {
            return null;
        }
        if (eventType.equalsIgnoreCase("SINGLE")) {
            return new SingleEvent(name, startTime, endTime, isCommute, commute, location);

        } else if (eventType.equalsIgnoreCase("RECURRENT")) {
            return new RecurrentEvent(name, startTime, endTime, isCommute, commute, location);

        } else if (eventType.equalsIgnoreCase("DYNAMIC")) {
            return new DynamicEvent(name, startTime, endTime, isCommute, commute, location);
        }

        else {
            throw new IllegalArgumentException("Not a Valid Event Type");
        }

    }
}