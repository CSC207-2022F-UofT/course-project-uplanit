package use_cases.modify_event_use_case;

public interface EventModifierInputBoundary {
    EventModifierResponseModel create(EventModifierRequestModel requestModel);
}
