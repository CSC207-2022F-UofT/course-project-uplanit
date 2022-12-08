package use_cases.modify_event_use_case;

public class EventModifierResponseModel {

    // what we want to give to the presenter
    String name;
    String message;

    public EventModifierResponseModel(String name, String message)
    {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }
}
