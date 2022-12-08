package use_cases.modify_event_use_case;

public class EventModifierResponseModel {

    // what we want to give to the presenter
    String message;

    public EventModifierResponseModel(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
