package use_case_interactors;

import entities.*;

import java.sql.Time;
import java.util.Date;
public class ModifyEventInteractor {
    Event event;
    Date weekStart;
    Week week;

    public ModifyEventInteractor(Event e, Date w){
        event = e;
        weekStart = w;
        // week = new Week();
    }

    // HOW WE ARE MODIFYING EVENTS NOW:
    // 0) temporary store the old event's info
    // 0.5) if user is trying to change commute time, do the * part first
    // 1) delete the old event (access the week of this event, call delete event)
    // 2) update the temporal variable depending on what info the user wants to change
    // 3) recreate the event with those variables
    // 4) add it to the calendar (access the week of this event, call add event)

    // * HOW WE CHECK THE CONFLICT (FOR COMMUTE TIME)
    // 0) since commute time is an event as well, it has a startTime and endTime attribute
    // 1) for events on that date (call it otherEvent for now):
    //      2) if (newCommute.startTime < otherEvent.startTime || newCommute.startTime < otherEvent.endTime):
    //              3) don't allow to change commute Time (return something)
    // 4) if the loop doesn't return anything, go back to "HOW WE ARE MODIFYING EVENTS NOW" step
    // note: to do the for loop, this class needs access to all the events stored in that date (probably as a list)

    public void ChangeEventStartTime(Date newStartTime){

    }

    public void ChangeEventEndTime(Date newEndTime){

    }

    public void ChangeEventLocation(String newLocation){
        // if this event object contains location:
        //if(event.getLocation() != null) {}
    }

    public void ChangeEventName(String newName){
            // event.setName(newName);
    }

    public void ChangeEventCommuteTime(Time newCommuteTime){

        // 1) calculate what would be the "start time" and "end time" of commute
        // 2) get into the date that holds this event object
        // 3) check if there is another event object that has startTime-endTime "trapping" the new commuteTime

        // if this event object contains commute time:
        // if(event.getCommuteTime() != null) { // review this !!! -> if commuteTime is not null}
    }
}
