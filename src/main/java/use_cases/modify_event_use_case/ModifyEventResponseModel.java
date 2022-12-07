package use_cases.modify_event_use_case;

public class ModifyEventResponseModel {

    // what we want to give to the presenter
    String name;
    String message;

    public ModifyEventResponseModel(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
