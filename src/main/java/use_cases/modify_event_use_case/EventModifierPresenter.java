package use_cases.modify_event_use_case;

import screens.gui_screens.EventModifierResponseModel;

public interface EventModifierPresenter {
    EventModifierResponseModel prepareSuccessView(EventModifierResponseModel event);
    EventModifierResponseModel prepareFailView(String error);
}
