package use_cases.delete_event_use_case;

// Use case layer

public class DeleteEventResponseModel {

    String name;
    String message;


    public DeleteEventResponseModel(String name, String message) {

        this.name = name;
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return this.message;
    }

}
