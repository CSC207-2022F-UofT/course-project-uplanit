package screens;

import use_cases.display_week_use_case.DisplayWeekInputBoundary;
import use_cases.display_week_use_case.DisplayWeekRequestModel;
import use_cases.display_week_use_case.DisplayWeekResponseModel;

public class DisplayWeekController {
    final DisplayWeekInputBoundary input;

    public DisplayWeekController(DisplayWeekInputBoundary accountGateway) {
        this.input = accountGateway;
    }

    DisplayWeekResponseModel create(String date) {
        DisplayWeekRequestModel requestModel = new DisplayWeekRequestModel(date);

        return input.create(requestModel);
    }
}
