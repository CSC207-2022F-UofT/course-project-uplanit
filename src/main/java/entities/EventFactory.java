package entities;

import java.sql.Time;
import java.util.Date;

class EventFactory {


    /**
     * Returns a newly constructed Event object based on the given input. If eventType is null then it returns null.
     * If an invalid eventType input is given then an exception is thrown.
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
                          String name, Date startTime,
                          Date endTime, Event commute,
                          String location) {

        if (eventType == null) {
            return null;
        }
        if (eventType.equalsIgnoreCase("SINGLE")) {
            return new SingleEvent(name, startTime, endTime, commute, location);

        } else if (eventType.equalsIgnoreCase("RECURRENT")) {
            return new RecurrentEvent(name, startTime, endTime, commute, location);

        } else if (eventType.equalsIgnoreCase("DYNAMIC")) {
            return new DynamicEvent(name, startTime, endTime, commute, location);
        }

        else {
            throw new IllegalArgumentException("Not a Valid Event Type");
        }

    }
}