import entities.*;

import java.sql.Time;
import java.util.Date;
public class ModifyEvent extends Event{
    // this part changes a lot depending on how the entities.Event Class is implemented
    Event event;

    public ModifyEvent(String name, Date startTime, Date endTime, Time commuteTime, String location){
        super(name, startTime, endTime, commuteTime, location);
    }

    public void ChangeEventStartTime(Date newStartTime){
        event.setStartTime(newStartTime);
    }

    public void ChangeEventEndTime(Date newEndTime){
        event.setEndTime(newEndTime);
    }

    public void ChangeLocation(String newLocation){

        // is location default null or empty string?

        // if this event object contains location:
        if(event.getLocation() == null) {
            event.setLocation(newLocation);
        }
    }

    public void ChangeName(String newName){
            event.setName(newName);
    }

    public void ChangeCommuteTime(Time newCommuteTime){
        Time defaultTime = new Time(0);

        // if this event object contains commute time:
        if(!newCommuteTime.equals(defaultTime)) { // review this !!!
            event.setCommuteTime(newCommuteTime);
        }
    }
}
