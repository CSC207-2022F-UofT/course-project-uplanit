package use_cases.modify_event_use_case;

import entities.*;
import java.time.LocalDateTime;
import java.time.LocalDate;


public class ModifyEventInteractor {
    Event oldEvent;

    Week week;
    Calendar calendar;

    ModifyEventPresenter presenter;

    String oldName;

    LocalDateTime oldStartTime;

    LocalDateTime oldEndTime;

    Event oldCommute;

    String oldLocation;


    /**
     * Constructs a modify event interactor
     *
     * @param e The event that the user is trying to modify
     * @param c The calendar object that the user is using
     * @param weekStart The start date of the week (to retrieve the week that holds the targeted event)
     */
    public ModifyEventInteractor(Event e, Calendar c, LocalDate weekStart){
        oldEvent = e;
        calendar = c;
        week = c.getWeek(weekStart);
        presenter = new ModifyEventPresenter(e, c, weekStart);

        oldName = e.getName();
        oldStartTime = e.getStartTime();
        oldEndTime = e.getEndTime();
        oldCommute = e.getCommute();
        oldLocation = e.getLocation();
    }

    /***
     * Create an event object with new name
     *
     * @param newName new name that user wants to use
     */
    public void ChangeEventName(String newName){
        Event updatedEvent = new Event(newName, oldStartTime, oldEndTime, oldEvent.isCommute(), oldCommute, oldLocation);
        updateEvents(updatedEvent);
    }

    /***
     * Create an event object with new startTime
     *
     * @param newStartTime new startTime that user wants to use
     */
    public void ChangeEventStartTime(LocalDateTime newStartTime){
        Event updatedEvent = new Event(oldName, newStartTime, oldEndTime, oldEvent.isCommute(), oldCommute, oldLocation);
        updateEvents(updatedEvent);
    }

    /***
     * Create an event object with new endTime
     *
     * @param newEndTime new endTime that user wants to use
     */
    public void ChangeEventEndTime(LocalDateTime newEndTime){
        Event updatedEvent = new Event(oldName, oldStartTime, newEndTime, oldEvent.isCommute(), oldCommute, oldLocation);
        updateEvents(updatedEvent);
    }

    /***
     * Create an event object with new name
     *
     * @param newLocation new location that user wants to use
     */
    public void ChangeEventLocation(String newLocation){
        Event updatedEvent = new Event(oldName, oldStartTime, oldEndTime, oldEvent.isCommute(), oldCommute, newLocation);
        updateEvents(updatedEvent);
    }


    /***
     * Create na event object with new name
     *
     * @param newCommute new commute that user wants to use
     */
    public void ChangeEventCommuteTime(Event newCommute){
        Event updatedEvent = new Event(oldName, oldStartTime, oldEndTime, oldEvent.isCommute(), newCommute, oldLocation);

        // if there is no conflict
        if (!week.checkConflict(updatedEvent)){
            updateEvents(updatedEvent);
        }
    }

    /***
     * Delete the outdated event object and store the new event to the corresponding week
     *
     * @param e event that contains updated information
     */
    public void updateEvents(Event e){
        week.deleteEvent(oldEvent);
        week.addEvent(e);
        SendNewEventInformation(e);
    }

    /***
     * Create na event object with new name
     *
     * @param e send updated event information to the presenter
     */
    public void SendNewEventInformation(Event e){
        presenter.PresentNewInfo(e);
    }
}


// Keeping this notes just in case

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
// THESE WORK ARE DONE IN WEEK ENTITY!
