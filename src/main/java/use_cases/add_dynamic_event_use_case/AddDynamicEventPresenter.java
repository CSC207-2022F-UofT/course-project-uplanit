package use_cases.add_dynamic_event_use_case;

// Interface Adapters Layer; Presenter
public interface AddDynamicEventPresenter {

    // Method signatures for the methods prepareSuccessView and prepareFailView that are implemented in screens package.
    AddDynamicEventResponseModel prepareSuccessView(AddDynamicEventResponseModel event);

    AddDynamicEventResponseModel prepareFailView(String error);
}
