package use_cases.recurrent_event_use_case;

import entities.Event;
import entities.RecurrentEventFactory;

// Use case layer

public class RecurrentEventInteractor implements RecurrentEventInputBoundary {

    final RecurrentEventDsGateway recurrentDsGateway;
    final RecurrentEventPresenter recurrentPresenter;
    final RecurrentEventFactory eventFactory;


    public RecurrentEventInteractor(RecurrentEventDsGateway recurrentEventDfGateway,
                                    RecurrentEventPresenter recurrentEventPresenter,
                                    RecurrentEventFactory eventFactory) {

        this.recurrentDsGateway = recurrentEventDfGateway;
        this.recurrentPresenter = recurrentEventPresenter;
        this.eventFactory = eventFactory;

    }


    // Create a new request model for the commute and event recurring 12 times from the users input and save it
    @Override
    public RecurrentEventResponseModel create(RecurrentEventRequestModel requestModel) {

        Event event = null;

        // using variable i to iterate through the 12 weeks that this recurrent event will be scheduled on.
        for (int i = 0; i <= 11; i++) {


            if (recurrentDsGateway.hasConflict(requestModel.getStartTime().plusDays(7*i), requestModel.getEndTime().plusDays(7*i))) {
                return recurrentPresenter.prepareFailView("This event has a conflict.");
            }

            if (recurrentDsGateway.hasConflict(requestModel.getStartTime().plusDays(7*i).minusMinutes(requestModel.getCommute()),
                    requestModel.getEndTime().plusDays(7*i).minusMinutes(requestModel.getCommute()))) {
                return recurrentPresenter.prepareFailView("This commute has a conflict.");

            }

            Event commute = eventFactory.create(requestModel.getName() + " commute", requestModel.getStartTime().plusDays(7*i).minusMinutes(requestModel.getCommute()),
                    requestModel.getStartTime().plusDays(7*i), true, null, requestModel.getLocation());
            event = eventFactory.create(requestModel.getName(), requestModel.getStartTime().plusDays(7*i),
                    requestModel.getEndTime().plusDays(7*i), false, commute, requestModel.getLocation());

            if (!event.isValid()) {
                return recurrentPresenter.prepareFailView("Event start must be before event end.");
            }

            RecurrentEventDsRequestModel commuteDsModel = new RecurrentEventDsRequestModel(commute.getName(), commute.getStartTime(),
                    commute.getEndTime(), true, 0, commute.getLocation(), "R");
            RecurrentEventDsRequestModel eventDsModel = new RecurrentEventDsRequestModel(event.getName(), event.getStartTime(),
                    event.getEndTime(), false, requestModel.getCommute(), event.getLocation(), "R");

            recurrentDsGateway.save(commuteDsModel);
            recurrentDsGateway.save(eventDsModel);

        }

        RecurrentEventResponseModel eventResponseModel = new RecurrentEventResponseModel(event.getName(), " created");

        return recurrentPresenter.prepareSuccessView(eventResponseModel);

    }
}
