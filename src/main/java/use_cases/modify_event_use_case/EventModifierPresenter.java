package use_cases.modify_event_use_case;

public interface EventModifierPresenter {
    EventModifierResponseModel prepareSuccessView(EventModifierResponseModel event);
    EventModifierResponseModel prepareFailView(String error);
}
