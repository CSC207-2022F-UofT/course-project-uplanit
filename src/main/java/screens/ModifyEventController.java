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

    public ModifyEventController(Event e, Calendar c, LocalDate weekStart){
        event = e;
        startDate = weekStart;
        uc = new ModifyEventInteractor(e, c, weekStart);
    }

    public void SetNewName(String name){
        uc.ChangeEventName(name);
    }

    public void SetNewStartTime(LocalDateTime startTime){
        uc.ChangeEventStartTime(startTime);
    }

    public void SetNewEndTime(LocalDateTime endTime){
        uc.ChangeEventEndTime(endTime);
    }

    public void SetNewLocation(String location){
        uc.ChangeEventLocation(location);
    }

    public void SetNewCommute(Event commute){
        uc.ChangeEventCommuteTime(commute);
    }

}


