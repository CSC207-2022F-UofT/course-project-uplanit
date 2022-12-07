package use_cases.add_dynamic_event_use_case;

import entities.Event;
import entities.DynamicEvent;
import entities.DynamicEventFactory;

// Use Case Layer

public class AddDynamicEventInteractor implements AddDynamicEventInputBoundary {

    final AddDynamicEventDsGateway dynamicEventDsGateway;
    final AddDynamicEventPresenter dynamicEventPresenter;
    final DynamicEventFactory dynamicEventFactory;


    public AddDynamicEventInteractor(AddDynamicEventDsGateway addDynamicEventDfGateway,
                                     AddDynamicEventPresenter addDynamicEventPresenter,
                                     DynamicEventFactory dynamicEventFactory) {
        this.dynamicEventDsGateway = addDynamicEventDfGateway;
        this.dynamicEventPresenter = addDynamicEventPresenter;
        this.dynamicEventFactory = dynamicEventFactory;

    }
    @Override
    public AddDynamicEventResponseModel create(AddDynamicEventRequestModel requestModel) {


        // If the event to be added conflicts with the already existent events,
        // return dynamicEventPresenter.prepareFailView
        if (dynamicEventDsGateway.checkConflict(requestModel)) {
            return dynamicEventPresenter.prepareFailView("Event has a conflict.");
        } else {

            Event dynamicEvent = dynamicEventFactory.create(requestModel.getName(),
                    requestModel.getStartTime(), requestModel.getEndTime(), false,
                    null, requestModel.getLocation());

            if (!dynamicEvent.isValid()) {
                return dynamicEventPresenter.prepareFailView("Event start must be before event end.");

            } else {

                AddDynamicEventDsRequestModel eventDsModel = new AddDynamicEventDsRequestModel(dynamicEvent.getName(),
                    dynamicEvent.getStartTime(), dynamicEvent.getEndTime(),
                    dynamicEvent.isCommute(), dynamicEvent.getCommute(), dynamicEvent.getLocation());
                dynamicEventDsGateway.save(eventDsModel);

                AddDynamicEventResponseModel eventResponseModel = new AddDynamicEventResponseModel(dynamicEvent.getName(),
                        "created");
                return dynamicEventPresenter.prepareSuccessView(eventResponseModel);}
        }

    }
}
