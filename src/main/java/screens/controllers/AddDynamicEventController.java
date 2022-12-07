package screens.controllers;

import entities.Event;
import use_cases.add_dynamic_event_use_case.AddDynamicEventInputBoundary;
import use_cases.add_dynamic_event_use_case.AddDynamicEventRequestModel;
import use_cases.add_dynamic_event_use_case.AddDynamicEventResponseModel;

import java.time.LocalDateTime;

public class AddDynamicEventController {

    final AddDynamicEventInputBoundary userInput;

    public AddDynamicEventController(AddDynamicEventInputBoundary eventGateway) {
        this.userInput = eventGateway;
    }

    AddDynamicEventResponseModel create(String event_name, LocalDateTime start_time, LocalDateTime end_time,
                                        boolean is_commute, Event commute, String location) {
        AddDynamicEventRequestModel requestModel = new AddDynamicEventRequestModel(
                event_name, start_time, end_time, is_commute, commute, location);

        return userInput.create(requestModel);
    }
}
