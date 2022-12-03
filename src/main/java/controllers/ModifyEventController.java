package controllers;
import use_case_interactors.*;
import entities.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class ModifyEventController {

    // How I'm planning to implement modify event
    // 1) get user input from the presenter (which info the user is trying to modify)
    // 2) presenter would send that info to the controller, which is this class
    // 3) controller would send that info in a form that modifyEvent class can interact
    // 4) UC would send that info to Event entity

    Event event;
    ModifyEventInteractor uc;
    LocalDate startDate;

    public ModifyEventController(Event e, Calendar c, LocalDate weekStart){
        event = e;
        startDate = weekStart;
        uc = new ModifyEventInteractor(e, c, weekStart);
    }

    public void SetNewName(String name){
        uc.ChangeEventName(name);
    }

    public void SetNewStartTime(LocalDateTime t){
        uc.ChangeEventStartTime(t);
    }

    public void SetNewEndTime(LocalDateTime t){
        uc.ChangeEventEndTime(t);
    }

    public void SetNewLocation(String location){
        uc.ChangeEventLocation(location);
    }

    public void SetNewCommute(Event commute){
        uc.ChangeEventCommuteTime(commute);
    }

}


