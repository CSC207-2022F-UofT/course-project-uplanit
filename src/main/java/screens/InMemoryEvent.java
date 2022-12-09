package screens;

import use_cases.add_dynamic_event_use_case.AddDynamicEventDsRequestModel;
import use_cases.add_dynamic_event_use_case.AddDynamicEventDsGateway;
import use_cases.add_dynamic_event_use_case.AddDynamicEventRequestModel;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class InMemoryEvent implements AddDynamicEventDsGateway {

    final private Map<LocalDateTime, AddDynamicEventDsRequestModel> events = new HashMap<>();

    @Override
    public void save(AddDynamicEventDsRequestModel requestModel) {
        System.out.println("Save " + requestModel.getName());
        events.put(requestModel.getStartTime(), requestModel);
    }


    @Override
    public boolean checkConflict(AddDynamicEventRequestModel newEvent) {

        // for loop is used to iterate through all events (requestModel) in the events HashMap to check for any
        // conflict.
        for (AddDynamicEventDsRequestModel requestModel : events.values()) {

            // There is a conflict if the start time of the newEvent is before the end time of an already
            // existent event AND the end time of the newEvent is after the start time of an already existent
            // event.
            if (newEvent.getStartTime().isBefore(requestModel.getEndTime()) &&
                    newEvent.getEndTime().isAfter(requestModel.getStartTime())) {
                return true;
            }
        }
        return false;
    }
}
