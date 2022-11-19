import java.sql.Time;
import java.util.Date;

public class Event {
    public String name;
    public Time commuteTime = new Time(0);
    public Date eventStart;
    public Date eventEnd;
    // default for location is null
    public String location;

}
