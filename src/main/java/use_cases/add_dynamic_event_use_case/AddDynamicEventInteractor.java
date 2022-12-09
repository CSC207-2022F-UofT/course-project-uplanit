package use_cases.add_dynamic_event_use_case;

import entities.Event;
import entities.DynamicEventFactory;

// Application Business Rules (Use Case) Layer; Use Case Interactor

public class AddDynamicEventInteractor implements AddDynamicEventInputBoundary {

    final AddDynamicEventDsGateway dynamicEventDsGateway;
    final AddDynamicEventPresenter dynamicEventPresenter;
    final DynamicEventFactory dynamicEventFactory;

    /**
     * Construct AddDynamicEventInteractor object given the addDynamicEventDfGateway, addDynamicEventPresenter,
     * and dynamicEventFactory.
     *
     * @param addDynamicEventDfGateway gateway (data access interface object)
     * @param addDynamicEventPresenter presenter
     * @param dynamicEventFactory factory (design pattern) for generating a dynamic event
     */
    public AddDynamicEventInteractor(AddDynamicEventDsGateway addDynamicEventDfGateway,
                                     AddDynamicEventPresenter addDynamicEventPresenter,
                                     DynamicEventFactory dynamicEventFactory) {
        this.dynamicEventDsGateway = addDynamicEventDfGateway;
        this.dynamicEventPresenter = addDynamicEventPresenter;
        this.dynamicEventFactory = dynamicEventFactory;

    }

    /**
     * Return AddDynamicEventResponseModel object with given requestModel.
     *
     * @param requestModel AddDynamicEventRequestModel object
     * @return AddDynamicEventResponseModel object
     */
    @Override
    public AddDynamicEventResponseModel create(AddDynamicEventRequestModel requestModel) {


        // If the event to be added conflicts with any of the already existent events,
        // return dynamicEventPresenter.prepareFailView with the corresponding error message.
        if (dynamicEventDsGateway.checkConflict(requestModel)) {
            return dynamicEventPresenter.prepareFailView("Event has a conflict.");

        } else {

            // There is no conflict. Create the dynamic event.
            Event dynamicEvent = dynamicEventFactory.create(requestModel.getName(),
                    requestModel.getStartTime(), requestModel.getEndTime(), false,
                    null, requestModel.getLocation());

            // Check whether the dynamic event is a valid one using the Event.isValid() method. If it is not a
            // valid event, return dynamicEventPresenter.prepareFailView with the corresponding error message.
            if (!dynamicEvent.isValid()) {
                return dynamicEventPresenter.prepareFailView("Event start must be before event end.");

            // Event is valid and there is no conflict.
            } else {

                // Create eventDsModel (Data Structure Request Model) for this event.
                AddDynamicEventDsRequestModel eventDsModel = new AddDynamicEventDsRequestModel(dynamicEvent.getName(),
                    dynamicEvent.getStartTime(), dynamicEvent.getEndTime(), dynamicEvent.getLocation());

                // Use the save method implemented in FileDynamicEvent to save this event into the events HashMap and
                // to the csv file.
                dynamicEventDsGateway.save(eventDsModel);

                AddDynamicEventResponseModel eventResponseModel = new AddDynamicEventResponseModel(dynamicEvent.getName(),
                        "created");

                // Return dynamicEventPresenter.prepareSuccessView with the corresponding message.
                return dynamicEventPresenter.prepareSuccessView(eventResponseModel);}
        }

    }
}
