package screens.controllers;

import use_cases.modify_event_use_case.EventModifierPresenter;
import use_cases.modify_event_use_case.EventModifierResponseModel;

public class EventModifierResponseFormatter implements EventModifierPresenter {
    @Override
    public EventModifierResponseModel prepareSuccessView(EventModifierResponseModel response){
        return response;
    }

    @Override
    public EventModifierResponseModel prepareFailView(String error){
        throw new EventModificationFailed(error);
    }
}
