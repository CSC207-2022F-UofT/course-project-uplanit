package use_cases.display_week_use_case;

import use_cases.add_single_event_use_case.AddSingleEventResponseModel;

public interface DisplayWeekPresenter {
    public DisplayWeekResponseModel prepareSuccessView(DisplayWeekResponseModel week);

    public DisplayWeekResponseModel prepareFailView(String error);
}
