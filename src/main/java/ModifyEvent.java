import java.sql.Time;
import java.util.Date;
public class ModifyEvent {
    // this part changes a lot depending on how the Event Class is implemented
    Event event;

    public ModifyEvent(Event e){
        event = e;
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
        if(new_commuteTime != default_time) {
            event.commuteTime = new_commuteTime;
        }
    }
}
