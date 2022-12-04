package use_cases.recurrent_event_use_case;

// Use case layer

public class RecurrentEventResponseModel {

    String name;
    String message;


    // Construct the response we would like to give to the presenter
    public RecurrentEventResponseModel(String name, String message) {

        this.name = name;
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return this.message;
    }

    // not sure if this needs setters

}
