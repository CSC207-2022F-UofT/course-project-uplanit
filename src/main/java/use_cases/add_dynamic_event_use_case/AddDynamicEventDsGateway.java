package use_cases.add_dynamic_event_use_case;

// Use Case Layer

import entities.Event;

public interface AddDynamicEventDsGateway {

    // implement these methods in screens
    void save(AddDynamicEventDsRequestModel requestModel);
    boolean checkConflict(AddDynamicEventRequestModel newEvent);




}
