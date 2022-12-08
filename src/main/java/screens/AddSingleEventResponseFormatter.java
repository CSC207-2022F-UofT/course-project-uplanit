package screens;

import use_cases.add_single_event_use_case.AddSingleEventPresenter;
import use_cases.add_single_event_use_case.AddSingleEventRequestModel;
import use_cases.add_single_event_use_case.AddSingleEventResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddSingleEventResponseFormatter implements AddSingleEventPresenter {
    @Override
    public AddSingleEventResponseModel prepareSuccessView(AddSingleEventResponseModel response) {
        return response;
    }

    @Override
    public AddSingleEventResponseModel prepareFailView(String error) {
        throw new AddSingleEventFailed(error);
    }
}
