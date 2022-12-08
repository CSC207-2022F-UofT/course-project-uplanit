package screens;

import use_cases.modify_event_use_case.EventModifierInputBoundary;
import use_cases.modify_event_use_case.EventModifierRequestModel;
import screens.gui_screens.EventModifierResponseModel;

import java.time.LocalDateTime;

// Interface adapters layer

public class EventModifierController {
    final EventModifierInputBoundary userInput;

    public EventModifierController(EventModifierInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    EventModifierResponseModel create(String username, LocalDateTime startTime, LocalDateTime endTime, int commuteTime,
                                      boolean isCommute, String location) {

        EventModifierRequestModel requestModel = new EventModifierRequestModel(username, startTime, endTime,
                commuteTime, isCommute, location, "S");

        return userInput.create(requestModel);
    }
}


