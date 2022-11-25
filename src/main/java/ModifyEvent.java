import entities.*;

import java.sql.Time;
import java.util.Date;
public class ModifyEvent extends Event{
    // this part changes a lot depending on how the entities.Event Class is implemented
    Event event;

    // constructors

    /* public ModifyEvent(String name, Date startTime, Date endTime, Time commuteTime){
        super(name, startTime, endTime, commuteTime);
    }
    public ModifyEvent(String name, Date startTime, Date endTime){
        super(name, startTime, endTime);
    }

    public ModifyEvent(String name, Date startTime, Date endTime, String location){
        super(name, startTime, endTime, location);
    }

     */

    public ModifyEvent(String name, Date startTime, Date endTime, Time commuteTime, String location){
        super(name, startTime, endTime, commuteTime, location);
    }

    public void ChangeEventStart(Date new_start){
        event.startTime = new_start;
    }

    public void ChangeEventEnd(Date new_end){
        event.endTime = new_end;
    }

    public void ChangeLocation(String new_location){

        // is location default null or empty string?

        // if this event object contains location:
        if(event.location == null) {
            event.location = new_location;
        }
    }

    public void ChangeName(String new_name){
            event.name = new_name;
    }

    public void ChangeCommuteTime(Time new_commuteTime){
        Time default_time = new Time(0);

        // if this event object contains commute time:
        if(!new_commuteTime.equals(default_time)) {
            event.commuteTime = new_commuteTime;
        }
    }
}
