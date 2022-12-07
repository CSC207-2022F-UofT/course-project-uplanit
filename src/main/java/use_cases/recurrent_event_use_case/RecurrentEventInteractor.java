package use_cases.recurrent_event_use_case;

import entities.Event;
import entities.RecurrentEvent;
import entities.RecurrentEventFactory;
import java.time.LocalDateTime;

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

    @Override
    public RecurrentEventResponseModel create(RecurrentEventRequestModel requestModel) {

        if (recurrentDsGateway.hasConflict(requestModel.getStartTime(), requestModel.getEndTime())) {
            return recurrentPresenter.prepareFailView("This event has a conflict.");
        }

        Event commute = eventFactory.create(requestModel.getName() + " commute", requestModel.getStartTime().minusMinutes(requestModel.getCommute()),
                requestModel.getStartTime(), true, null, requestModel.getLocation());
        Event event = eventFactory.create(requestModel.getName(), requestModel.getStartTime(),
                requestModel.getEndTime(), false, commute, requestModel.getLocation());


        RecurrentEventDsRequestModel commuteDsModel = new RecurrentEventDsRequestModel(commute.getName(), commute.getStartTime(),
                commute.getEndTime(), 0, commute.getLocation());
        RecurrentEventDsRequestModel eventDsModel = new RecurrentEventDsRequestModel(event.getName(), event.getStartTime(),
                event.getEndTime(), requestModel.getCommute(), event.getLocation());

        RecurrentEventResponseModel eventResponseModel = new RecurrentEventResponseModel(event.getName()," created");

        return recurrentPresenter.prepareSuccessView(eventResponseModel);

    }
}
