package use_cases.recurrent_event_use_case;

import entities.Event;
import entities.EventFactory;
import java.time.LocalDateTime;

// Use case layer

public class RecurrentEventInteractor implements RecurrentEventInputBoundary {

    final RecurrentEventDsGateway recurrentDsGateway;
    final RecurrentEventPresenter recurrentPresenter;
    final EventFactory eventFactory;


    public RecurrentEventInteractor(RecurrentEventDsGateway recurrentEventDfGateway,
                                    RecurrentEventPresenter recurrentEventPresenter,
                                    EventFactory eventFactory) {

        this.recurrentDsGateway = recurrentEventDfGateway;
        this.recurrentPresenter = recurrentEventPresenter;
        this.eventFactory = eventFactory;

    }

    @Override
    public RecurrentEventResponseModel create(RecurrentEventRequestModel requestModel) {

        if (recurrentDsGateway.hasConflict(requestModel.getStartTime(), requestModel.getEndTime())) {
            return recurrentPresenter.prepareFailView("This event has a conflict");
        }
        else if ()
    }
}
