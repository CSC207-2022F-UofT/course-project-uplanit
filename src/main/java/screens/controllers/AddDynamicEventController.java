package screens.controllers;

import use_cases.add_dynamic_event_use_case.AddDynamicEventInputBoundary;
import use_cases.add_dynamic_event_use_case.AddDynamicEventRequestModel;
import use_cases.add_dynamic_event_use_case.AddDynamicEventResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface Adapters layer; Controller for AddDynamicEvent use case
public class AddDynamicEventController {

    final AddDynamicEventInputBoundary userInput;

    /**
     * Construct the AddDynamicEventController with the given eventGateway.
     *
     * @param eventGateway the input boundary
     */
    public AddDynamicEventController(AddDynamicEventInputBoundary eventGateway) {
        this.userInput = eventGateway;
    }

    /**
     * Return AddDynamicEventResponseModel object with given event_name, event start_time_str, event end_time_str,
     * is_commute_str, commute_str, and location.
     *
     * @param event_name the name of this event
     * @param start_time_str the start time for this event
     * @param end_time_str the end time for this event
     * @param location the location of this event
     * @return the response model for the event
     */
    AddDynamicEventResponseModel create(String event_name, String start_time_str, String end_time_str,
                                        String location) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);
        LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);

        AddDynamicEventRequestModel requestModel = new AddDynamicEventRequestModel(event_name, start_time,
                end_time, location);

        // Calls the create method that is defined in the AddDynamicEventInputBoundary interface and implemented
        // in the AddDynamicEventInteractor to return AddDynamicEventResponseModel object.
        return userInput.create(requestModel);
    }
}
