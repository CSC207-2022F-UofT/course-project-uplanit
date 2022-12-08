package use_cases.add_dynamic_event_use_case;

// Application Business Rules (Use Case) Layer
public class AddDynamicEventResponseModel {

    String name;
    String message;

    public AddDynamicEventResponseModel(String name, String message) {
        this.name = name;
        this.message = message;
    }


}
