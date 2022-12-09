package screens.controllers;


import use_cases.display_week_use_case.DisplayWeekPresenter;
import use_cases.display_week_use_case.DisplayWeekResponseModel;

public class DisplayWeekResponseFormatter implements DisplayWeekPresenter {
    @Override
    public DisplayWeekResponseModel prepareSuccessView(DisplayWeekResponseModel response) {
        return response;
    }

    @Override
    public DisplayWeekResponseModel prepareFailView(String error) {
        throw new DisplayWeekFailed(error);
    }
}
