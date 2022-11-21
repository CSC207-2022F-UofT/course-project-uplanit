import java.sql.Time;
import java.util.Date;
import entities.Event;

public class RecurrentEvent extends Event{

    public boolean happensBiweekly;

    /** Constructs an event with a name, startTime, endTime, and whether it happensBiweekly.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param happensBiweekly true if the event occurs on a biweekly basis
     */
    public RecurrentEvent(String name, Date startTime, Date endTime, boolean happensBiweekly) {
        super(name, startTime, endTime);
        this.happensBiweekly = happensBiweekly;
    }

    /** Constructs an event with a name, startTime, endTime, commuteTime, and whether it happensBiweekly.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param commuteTime the time it takes to get to this event
     * @param happensBiweekly true if the event occurs on a biweekly basis
     */
    public RecurrentEvent(String name, Date startTime, Date endTime, Time commuteTime, boolean happensBiweekly) {
        super(name, startTime, endTime, commuteTime);
        this.happensBiweekly = happensBiweekly;
    }

    /** Constructs an event with a name, startTime, endTime, location, and whether it happensBiweekly.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param location the location of the event to be created
     * @param happensBiweekly true if the event occurs on a biweekly basis
     */
    public RecurrentEvent(String name, Date startTime, Date endTime, String location, boolean happensBiweekly) {
        super(name, startTime, endTime, location);
        this.happensBiweekly = happensBiweekly;
    }

    /** Constructs an event with a name, startTime, endTime, commuteTime, location, and whether it happensBiweekly.
     *
     * @param name the name of the event to be created
     * @param startTime the start time of the event to be created
     * @param endTime the end time of the event to be created
     * @param commuteTime the time it takes to get to this event
     * @param location the location of the event to be created
     * @param happensBiweekly true if the event occurs on a biweekly basis
     */
    public RecurrentEvent(String name, Date startTime, Date endTime, Time commuteTime, String location,
                          boolean happensBiweekly) {
        super(name, startTime, endTime, commuteTime, location);
        this.happensBiweekly = happensBiweekly;
    }

}
