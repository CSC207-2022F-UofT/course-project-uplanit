package use_cases.add_dynamic_event_use_case;

// Application Business Rules (Use Case) Layer; Data Access Interface
public interface AddDynamicEventDsGateway {

    // Method signatures for the methods that are implemented in FileDynamicUser in screens package.
    void save(AddDynamicEventDsRequestModel requestModel);
    boolean checkConflict(AddDynamicEventRequestModel newEvent);

}
