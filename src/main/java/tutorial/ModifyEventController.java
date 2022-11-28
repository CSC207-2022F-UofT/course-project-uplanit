package tutorial;
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

    public ModifyEventController(Event e){
        event = e;
    }

    public void setInfoForModifyingEvent(){

    }

}


