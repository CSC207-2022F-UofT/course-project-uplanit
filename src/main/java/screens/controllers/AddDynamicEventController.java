package screens.controllers;

import entities.Event;
import use_cases.add_dynamic_event_use_case.AddDynamicEventInputBoundary;
import use_cases.add_dynamic_event_use_case.AddDynamicEventRequestModel;
import use_cases.add_dynamic_event_use_case.AddDynamicEventResponseModel;

import java.time.LocalDateTime;

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
     * Return AddDynamicEventResponseModel object with given event_name, event start_time, event end_time, is_commute,
     * commute, and location.
     *
     * @param event_name the name of this event
     * @param start_time the start time for this event
     * @param end_time the end time for this event
     * @param is_commute whether this event requires commute
     * @param commute the event representing the commute
     * @param location the location of this event
     * @return the response model for the event
     */
    AddDynamicEventResponseModel create(String event_name, LocalDateTime start_time, LocalDateTime end_time,
                                        boolean is_commute, Event commute, String location) {
        AddDynamicEventRequestModel requestModel = new AddDynamicEventRequestModel(
                event_name, start_time, end_time, is_commute, commute, location);

        // Calls the create method that is defined in the AddDynamicEventInputBoundary interface and implemented
        // in the AddDynamicEventInteractor to return AddDynamicEventResponseModel object.
        return userInput.create(requestModel);
    }
}
