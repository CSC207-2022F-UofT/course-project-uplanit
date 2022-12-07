package use_cases.add_dynamic_event_use_case;

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
        }

        else if () {

        }

        // (we know that the week exists, now, we have to check for conflicts)
        // if there is no conflict, add the dynamic event and return dynamicEventPresenter.prepareSuccessView
        // event is created, save this event to database

        DynamicEvent dynamicEvent = new DynamicEventFactory.create(requestModel.getName(),
                    requestModel.getStartTime(), requestModel.getEndTime(), requestModel.getIsCommute(),
                    requestModel.getIsCommute(), requestModel.getLocation());
        AddDynamicEventDsRequestModel eventDsModel = new AddDynamicEventDsRequestModel(dynamicEvent.getName(),
                    dynamicEvent.getStartTime(), dynamicEvent.getEndTime(),
                    dynamicEvent.isCommute(), dynamicEvent.getCommute(), dynamicEvent.getLocation());
        AddDynamicEventDsGateway.save(eventDsModel);

        AddDynamicEventResponseModel eventResponseModel = new AddDynamicEventResponseModel(dynamicEvent.getName(),
                    "created");
        return AddDynamicEventPresenter.prepareSuccessView(eventResponseModel);


        }
    }
}
