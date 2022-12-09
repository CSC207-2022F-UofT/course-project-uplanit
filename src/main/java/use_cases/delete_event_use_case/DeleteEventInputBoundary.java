package use_cases.delete_event_use_case;

// Use case layer

public interface DeleteEventInputBoundary {

    DeleteEventResponseModel create(DeleteEventRequestModel requestModel);
}
