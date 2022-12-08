package use_cases.add_single_event_use_case;

public interface AddSingleEventInputBoundary {
    AddSingleEventResponseModel create(AddSingleEventRequestModel requestModel);
}
