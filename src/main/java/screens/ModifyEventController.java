package screens;

import use_cases.modify_event_use_case.ModifyEventInputBoundary;
import use_cases.modify_event_use_case.ModifyEventRequestModel;
import use_cases.modify_event_use_case.ModifyEventResponseModel;

import java.time.LocalDateTime;

// Interface adapters layer

public class ModifyEventController{
    final ModifyEventInputBoundary userInput;

    public ModifyEventController(ModifyEventInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    ModifyEventResponseModel create(String username, LocalDateTime startTime, LocalDateTime endTime, int commuteTime,
                                    boolean isCommute, String location) {

        ModifyEventRequestModel requestModel = new ModifyEventRequestModel(username, startTime, endTime,
                commuteTime, isCommute, location, "S");

        return userInput.create(requestModel);
    }
}


