package screens.controllers;

import use_cases.add_dynamic_event_use_case.AddDynamicEventPresenter;
import use_cases.add_dynamic_event_use_case.AddDynamicEventResponseModel;

public class AddDynamicEventResponseFormatter implements AddDynamicEventPresenter {
    @Override
    public AddDynamicEventResponseModel prepareSuccessView(AddDynamicEventResponseModel event) {
        return event;
    }

    @Override
    public AddDynamicEventResponseModel prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}
