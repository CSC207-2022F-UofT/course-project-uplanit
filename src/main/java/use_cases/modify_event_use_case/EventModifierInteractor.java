package use_cases.modify_event_use_case;


public class EventModifierInteractor implements EventModifierInputBoundary {

    final EventModifierDsGateway eventModifierDsGateway;
    EventModifierPresenter presenter;


    public EventModifierInteractor(EventModifierDsGateway eventModifierDsGateway,
                                   EventModifierPresenter eventModifierPresenter)
    {
        this.eventModifierDsGateway = eventModifierDsGateway;
        this.presenter = eventModifierPresenter;
    }

    @Override
    public EventModifierResponseModel create(EventModifierRequestModel requestModel) {

        // event has conflict
        if (eventModifierDsGateway.hasConflict(requestModel)) {
            return presenter.prepareFailView("This event has a conflict.");
        }

        if (!isSingleEvent(requestModel.getEventType())){
            return presenter.prepareFailView("This event is not modifiable");
        }

        EventModifierDsRequestModel userDsModel = new EventModifierDsRequestModel(requestModel.getName(),
                requestModel.getStartTime(), requestModel.getEndTime(),
                requestModel.getCommute(), requestModel.getIsCommute(), requestModel.getLocation());

        eventModifierDsGateway.save(userDsModel);

        EventModifierResponseModel eventResponseModel = new EventModifierResponseModel("event successfully modified");

        return presenter.prepareSuccessView(eventResponseModel);
    }

    public boolean isSingleEvent(String identifier) {
        // checks if this a single event
        return identifier.equals("S");
    }
}

