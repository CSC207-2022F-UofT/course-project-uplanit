package use_cases.add_dynamic_event_use_case;

import entities.Calendar;
import entities.DynamicEvent;
import entities.DynamicEventFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

        // if the corresponding week of requestModel.getStartTime() exists and there is a conflict;
        // return dynamicEventPresenter.prepareFailView
        if () {
            return dynamicEventPresenter.prepareFailView("Event cannot be added due to a conflict.");
        }

        // else, if the corresponding week of requestModel.getStartTime() does not exist, create a week
        // (we know that there will not be a conflict because the week did not exist previously)
        else if () {

        }

        // (we know that the week exists, now, we have to check for conflicts)
        // if there is no conflict, add the dynamic event and return dynamicEventPresenter.prepareSuccessView
        // event is created, save this event to database
        if () {

            DynamicEvent dynamicEvent = new DynamicEventFactory.create(requestModel.getName(),
                    requestModel.getStartTime(), requestModel.getEndTime(), requestModel.getIsCommute(),
                    requestModel.getIsCommute(), requestModel.getLocation());
            AddDynamicEventDsRequestModel eventDsModel = new AddDynamicEventDsRequestModel(dynamicEvent.getName(),
                    dynamicEvent.getStartTime(), dynamicEvent.getEndTime(), dynamicEvent.isCommute(),
                    dynamicEvent.getCommute(), dynamicEvent.getLocation(), dynamicEvent.getEventType());
            AddDynamicEventDsGateway.save(eventDsModel);

            AddDynamicEventResponseModel eventResponseModel = new AddDynamicEventResponseModel(user.getName(),
                    now.toString());
            return AddDynamicEventPresenter.prepareSuccessView(eventResponseModel);


        }
    }
}
