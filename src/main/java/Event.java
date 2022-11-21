import java.sql.Time;
import java.util.Date;

public class Event {
    public String name;
    public Time commuteTime = new Time(0);
    public Date startTime;
    public Date endTime;
    // default for location is null so check that in code to check if the event has a location or not
    public String location;

    // Constructs an event with only a name, startTime, and endTime.
    public Event(String name, Date startTime, Date endTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;

    }


    // Constructs an event with a name, startTime, endTime, and commuteTime.
    public Event(String name, Date startTime, Date endTime, Time commuteTime){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
    }


    // Constructs an event with a name, startTime, endTime, and location.
    public Event(String name, Date startTime, Date endTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }


    // Constructs an event with a name, startTime, endTime, commuteTime, and location.
    public Event(String name, Date startTime, Date endTime, Time commuteTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;
    }

}
