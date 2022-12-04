package use_cases.recurrent_event_use_case;

// Use case layer

public interface RecurrentEventInputBoundary {

    RecurrentEventResponseModel create (RecurrentEventRequestModel requestModel);
}
