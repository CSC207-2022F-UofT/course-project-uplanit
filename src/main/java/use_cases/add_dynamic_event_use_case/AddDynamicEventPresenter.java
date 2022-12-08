package use_cases.add_dynamic_event_use_case;

// Application Business Rules (Use Case) Layer
public interface AddDynamicEventPresenter {

    AddDynamicEventResponseModel prepareSuccessView(AddDynamicEventResponseModel event);

    AddDynamicEventResponseModel prepareFailView(String error);
}
