package screens;

import use_cases.recurrent_event_use_case.RecurrentEventInputBoundary;
import use_cases.recurrent_event_use_case.RecurrentEventRequestModel;
import use_cases.recurrent_event_use_case.RecurrentEventResponseModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface adapters layer

public class RecurrentEventController {

    final RecurrentEventInputBoundary eventInput;

    public RecurrentEventController(RecurrentEventInputBoundary eventGateway) {
        this.eventInput = eventGateway;
    }

    public RecurrentEventResponseModel create(String name, String startTime, String endTime, String isCommute, String commute,
                                       String location, String eventType) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);
        boolean isCom = Boolean.parseBoolean(isCommute);
        int com = Integer.parseInt(commute);

        RecurrentEventRequestModel requestModel = new RecurrentEventRequestModel(name, start, end, isCom, com, location,
                eventType);

        return eventInput.create(requestModel);

    }
}
