package use_cases.add_dynamic_event_use_case;

// Application Business Rules (Use Case) Layer; Input Boundary

public interface AddDynamicEventInputBoundary {

    // Method signature for the create method that is implemented in AddDynamicEventInteractor.
    AddDynamicEventResponseModel create(AddDynamicEventRequestModel requestModel);
}



