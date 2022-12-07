package screens;
import entities.*;
import use_cases.modify_event_use_case.ModifyEventInteractor;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ModifyEventController implements ModifyEventInputBoundary {

    // Controller is GETTING info from the user. Methods in this class should be called by Main? I think?
    // 1) get user input from Main
    // 3) controller would send that info in a form that modifyEvent class can interact

    Event event;
    ModifyEventInteractor uc;
    LocalDate startDate;

    /***
     *

     */
    public ModifyEventController(){

        // uc = new ModifyEventInteractor(e);
    }

    /***
     * Sends new name to the use case
     *
     * @param name new name the user input
     */
    public void SetNewName(String name){
        uc.ChangeEventName(name);
    }

    /***
     * Sends new start Time to the use case
     *
     * @param startTime new start Time user input
     */
    public void SetNewStartTime(LocalDateTime startTime){
        uc.ChangeEventStartTime(startTime);
    }

    /***
     * Sends new end Time to the use case
     *
     * @param endTime new end Time user input
     */
    public void SetNewEndTime(LocalDateTime endTime){
        uc.ChangeEventEndTime(endTime);
    }

    /***
     * Sends new location to the use case
     *
     * @param location new location user input
     */
    public void SetNewLocation(String location){
        uc.ChangeEventLocation(location);
    }

    /***
     * Sends new commute to the use case
     *
     * @param commute new commute object user input
     */
    public void SetNewCommute(Event commute){
        uc.ChangeEventCommuteTime(commute);
    }

}


