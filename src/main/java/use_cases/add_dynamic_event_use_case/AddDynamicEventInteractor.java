package use_cases.add_dynamic_event_use_case;

// Use Case Layer

public class AddDynamicEventInteractor implements AddDynamicEventInputBoundary {

    final AddDynamicEventDsGateway dynamicEventDsGateway;
    final AddDynamicEventPresenter dynamicEventPresenter;
    final EventFactory eventFactory;


    public AddDynamicEventInteractor(AddDynamicEventDsGateway addDynamicEventDfGateway,
                                     AddDynamicEventPresenter addDynamicEventPresenter,
                                     EventFactory eventFactory) {
        this.dynamicEventDsGateway= addDynamicEventDfGateway;
        this.dynamicEventPresenter = addDynamicEventPresenter;
        this.eventFactory = eventFactory;
}
