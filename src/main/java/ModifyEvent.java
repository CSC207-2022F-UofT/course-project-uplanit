import java.util.Date;
public class ModifyEvent {
    // this part changes a lot depending on how the Event Class is implemented
    Event event = new Event();

    public ModifyEvent(Event e){
        event = e;
    }

    public void ChangeEventStart(Date new_start){
        event.eventStart = new_start;
    }

    public void ChangeEventEnd(Date new_end){
        event.eventEnd = new_end;
    }

    public void ChangeLocation(String new_location){
        event.location = new_location;
    }

    public void ChangeName(String new_name){
        event.name = new_name;
    }
}
