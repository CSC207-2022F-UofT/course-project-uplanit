import entities.Event;

import java.sql.Time;
import java.util.Date;
public class ModifyEvent extends Event{
    // this part changes a lot depending on how the entities.Event Class is implemented
    Event event;

    // constructors
    public ModifyEvent(String name, Date startTime, Date endTime, Time commuteTime){
        super(name, startTime, endTime, commuteTime);
    }
    public ModifyEvent(String name, Date startTime, Date endTime){
        super(name, startTime, endTime);
    }

    public ModifyEvent(String name, Date startTime, Date endTime, String location){
        super(name, startTime, endTime, location);
    }

    public ModifyEvent(String name, Date startTime, Date endTime, Time commuteTime, String location){
        super(name, startTime, endTime, commuteTime, location);
    }

    //Changing Information
    public void ChangeEventStart(Date new_start) { event.startTime = new_start; }

    public void ChangeEventEnd(Date new_end){
        event.endTime = new_end;
    }

    public void ChangeLocation(String new_location) { event.location = new_location; }

    public void ChangeName(String new_name){
            event.name = new_name;
    }

    public void ChangeCommuteTime(Time new_commuteTime) { event.commuteTime = new_commuteTime; }

}
