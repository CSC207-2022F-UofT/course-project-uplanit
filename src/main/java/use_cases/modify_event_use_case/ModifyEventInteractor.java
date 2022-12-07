package use_cases.modify_event_use_case;

import entities.*;
import java.time.LocalDateTime;
import java.time.LocalDate;


public class ModifyEventInteractor {
    Event oldEvent;

    ModifyEventPresenter presenter;

    private final String name;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final int commuteTime;
    private final boolean isCommute;
    private final String location;


    /**
     * Constructs a modify event interactor
     *
     */
    public ModifyEventInteractor(String name, LocalDateTime startTime, LocalDateTime endTime,
                                 int commuteTime, boolean isCommute, String location){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.isCommute = isCommute;
        this.location = location;
    }

    /***
     * Create an event object with new name
     *
     * @param newName new name that user wants to use
     */
    public void ChangeEventName(String newName){

    }

    /***
     * Create an event object with new startTime
     *
     * @param newStartTime new startTime that user wants to use
     */
    public void ChangeEventStartTime(LocalDateTime newStartTime){

    }

    /***
     * Create an event object with new endTime
     *
     * @param newEndTime new endTime that user wants to use
     */
    public void ChangeEventEndTime(LocalDateTime newEndTime){

    }

    /***
     * Create an event object with new name
     *
     * @param newLocation new location that user wants to use
     */
    public void ChangeEventLocation(String newLocation){

    }


    /***
     * Create na event object with new name
     *
     * @param newCommute new commute that user wants to use
     */
    public void ChangeEventCommuteTime(Event newCommute){

    }

    /***
     * Delete the outdated event object and store the new event to the corresponding week
     *
     * @param e event that contains updated information
     */
    public void updateEvents(Event e){
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
