package use_cases.add_dynamic_event_use_case;

// Application Business Rules (Use Case) Layer; Output Data Structure
public class AddDynamicEventResponseModel {

    String name;
    String message;

    /**
     * Construct AddDynamicEventResponseModel with given name and message.
     * @param name the name of the event to be created
     * @param message the message to be shown to user
     */
    public AddDynamicEventResponseModel(String name, String message) {
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
