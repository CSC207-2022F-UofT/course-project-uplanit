import java.sql.Time;
import java.util.Date;

public class RecurrentEvent extends Event{

    public boolean happensBiweekly;

    // Constructs an event with a name, startTime, endTime, and whether it happensBiweekly.
    public RecurrentEvent(String name, Date startTime, Date endTime, boolean happensBiweekly) {
        super(name, startTime, endTime);
        this.happensBiweekly = happensBiweekly;
    }

    // Constructs an event with a name, startTime, endTime, commuteTime, and whether it happensBiweekly.
    public RecurrentEvent(String name, Date startTime, Date endTime, Time commuteTime, boolean happensBiweekly) {
        super(name, startTime, endTime, commuteTime);
        this.happensBiweekly = happensBiweekly;
    }

    // Constructs an event with a name, startTime, endTime, location, and whether it happensBiweekly.
    public RecurrentEvent(String name, Date startTime, Date endTime, String location, boolean happensBiweekly) {
        super(name, startTime, endTime, location);
        this.happensBiweekly = happensBiweekly;
    }

    // Constructs an event with a name, startTime, endTime, commuteTime, location, and whether it happensBiweekly.
    public RecurrentEvent(String name, Date startTime, Date endTime, Time commuteTime, String location,
                          boolean happensBiweekly) {
        super(name, startTime, endTime, commuteTime, location);
        this.happensBiweekly = happensBiweekly;
    }

}
