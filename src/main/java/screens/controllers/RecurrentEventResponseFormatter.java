package screens.controllers;

import screens.controllers.EventCreationFailed;
import use_cases.recurrent_event_use_case.RecurrentEventPresenter;
import use_cases.recurrent_event_use_case.RecurrentEventResponseModel;

// Interface adapters layer

public class RecurrentEventResponseFormatter implements RecurrentEventPresenter {

    @Override
    public RecurrentEventResponseModel prepareSuccessView(RecurrentEventResponseModel response) {
        return response;
    }

    @Override
    public RecurrentEventResponseModel prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }


}
