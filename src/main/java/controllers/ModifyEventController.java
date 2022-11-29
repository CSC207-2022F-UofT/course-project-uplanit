package controllers;
import use_case_interactors.*;
import entities.*;
import java.sql.Time;
import java.util.Date;


public class ModifyEventController {

    // How I'm planning to implement modify event
    // 1) get user input from the presenter (which info the user is trying to modify)
    // 2) presenter would send that info to the controller, which is this class
    // 3) controller would send that info in a form that modifyEvent class can interact
    // 4) UC would send that info to Event entity

    Event event;
    ModifyEventInteractor uc;
    Date startDate;

    public ModifyEventController(Event e, Date s){
        event = e;
        startDate = s;
        uc = new ModifyEventInteractor(e, s);
    }

    public void SetNewStartTime(Date t){
        uc.ChangeEventStartTime(t);
    }

    public void SetNewEndTime(Date t){
        uc.ChangeEventEndTime(t);
    }

    public void SetNewLocation(String location){
        uc.ChangeEventLocation(location);
    }

    public void SetNewName(String name){
        uc.ChangeEventName(name);
    }

    public void SetNewCommute(Time commute){
        uc.ChangeEventCommuteTime(commute);
    }

}


