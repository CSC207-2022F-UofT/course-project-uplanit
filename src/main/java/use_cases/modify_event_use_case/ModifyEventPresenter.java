package use_cases.modify_event_use_case;
import entities.*;
import java.time.LocalDate;


public class ModifyEventPresenter implements ModifyEventOutputBoundary{

    // Presenter is SENDING OUT (in other words, showing the info) to the user
    // how this (is supposed to) work
    // 1) get updated info from uc, send it to Main?
    // Note: these methods are called from uc


    /**
     * Constructs a presenter
     *
     * @param e Event that is going to be modified
     * @param c Calendar object that the user is interacting with
     * @param s start date of the week
     */
    public ModifyEventPresenter(Event e, Calendar c, LocalDate s){

    }

    /**
    * @param e send updated event info to main to be presented
    */
    public void PresentNewInfo(Event e){
        // should call method in Main
        String a = "a";
    }
}
