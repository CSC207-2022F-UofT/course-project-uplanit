import entities.*;

import java.sql.Time;
import java.util.Date;
public class ModifyEvent extends Event{
    Event event;

    public ModifyEvent(String name, Date startTime, Date endTime, Event commute, String location){
        super(name, startTime, endTime, commute, location);
    }

    public void ChangeEventStartTime(Date newStartTime){

    }

    public void ChangeEventEndTime(Date newEndTime){

    }

    public void ChangeLocation(String newLocation){
        // if this event object contains location:
        //if(event.getLocation() != null) {}
    }

    public void ChangeName(String newName){
            event.setName(newName);
    }

    public void ChangeCommuteTime(Time newCommuteTime){

        // 1) calculate what would be the "start time" and "end time" of commute
        // 2) get into the date that holds this event object
        // 3) check if there is another event object that has startTime-endTime "trapping" the new commuteTime

        // if this event object contains commute time:
        // if(event.getCommuteTime() != null) { // review this !!! -> if commuteTime is not null}
    }
}
