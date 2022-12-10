package screens.controllers;

import use_cases.add_single_event_use_case.AddSingleEventInputBoundary;
import use_cases.add_single_event_use_case.AddSingleEventRequestModel;
import use_cases.add_single_event_use_case.AddSingleEventResponseModel;

public class AddSingleEventController {
    final AddSingleEventInputBoundary eventInput;

    public AddSingleEventController(AddSingleEventInputBoundary gateway) {
        this.eventInput = gateway;
    }

    public AddSingleEventResponseModel create(String name, String startTime, String endTime, String commute, String location) {
        AddSingleEventRequestModel requestModel = new AddSingleEventRequestModel(name,startTime, endTime, commute, location);

        return eventInput.create(requestModel);
    }
}
