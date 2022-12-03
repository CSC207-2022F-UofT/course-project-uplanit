package presenters;
import controllers.ModifyEventController;
import entities.*;
import java.time.LocalDateTime;
import java.time.LocalDate;


public class ModifyEventPresenter {
    // how this (is supposed to) work
    // 1) In main, make 5 methods (name/startTime/endTime/commute/location) which gets triggered when user clicks on to
    // corresponding button
    // 2) main would accept the new (and valid) information from user
    // 3) send that to the presenter, presenter will send that info in a format that controller can handle


    ModifyEventController controller;


    /**
     * Constructs a presenter
     */
    public ModifyEventPresenter(Event e, Calendar c, LocalDate s){
        controller = new ModifyEventController(e, c, s);
    }

    public void PresentNewName(String name){
        controller.SetNewName(name);
    }

    public void PresentNewStartTime(LocalDateTime startTime){
        controller.SetNewStartTime(startTime);
    }


}
