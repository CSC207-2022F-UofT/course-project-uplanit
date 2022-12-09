package use_cases.modify_event_use_case;


public interface EventModifierDsGateway {
    boolean hasConflict(EventModifierRequestModel newEvent);

    void save(EventModifierDsRequestModel requestModel);
}
