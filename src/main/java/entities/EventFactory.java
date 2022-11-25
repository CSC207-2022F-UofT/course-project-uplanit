package entities;

import java.sql.Time;
import java.util.Date;

class EventFactory {

    public Event getEvent(String eventType,
                          String name, Date startTime,
                          Date endTime, Event commute,
                          String location) throws Exception {

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

        throw new Exception("This event type is invalid.");
    }
}