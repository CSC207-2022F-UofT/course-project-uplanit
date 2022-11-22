package entities;

import java.sql.Time;
import java.util.Date;
import entities.Event;

public class SingleEvent extends Event {

    // Constructs a entities.SingleEvent object with a name, startTime, and endTime.
    public SingleEvent(String name, Date startTime, Date endTime){
        super(name, startTime, endTime);
    }

    // Constructs a entities.SingleEvent object with a name, startTime, endTime, and commuteTime.
    public SingleEvent(String name, Date startTime, Date endTime, Time commuteTime){
        super(name, startTime, endTime, commuteTime);
    }

    // Constructs a entities.SingleEvent object with a name, startTime, endTime, and location.
    public SingleEvent(String name, Date startTime, Date endTime, String location){
        super(name, startTime, endTime, location);
    }

    // Constructs a entities.SingleEvent object with a name, startTime, endTime, commuteTime, and location.
    public SingleEvent(String name, Date startTime, Date endTime, Time commuteTime, String location){
        super(name, startTime, endTime, commuteTime, location);
    }
}
