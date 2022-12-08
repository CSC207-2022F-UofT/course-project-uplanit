package use_cases.modify_event_use_case;

import entities.*;
import java.time.LocalDateTime;


public class ModifyEventInteractor implements ModifyEventInputBoundary {

    final ModifyEventDsGateway modifyEventDsGateway;
    ModifyEventPresenter presenter;
    final SingleEventFactory eventFactory;

    public ModifyEventInteractor(ModifyEventDsGateway modifyEventDsGateway,
                                 ModifyEventPresenter modifyEventPresenter,
                                 SingleEventFactory eventFactory){

        this.modifyEventDsGateway = modifyEventDsGateway;
        this.presenter = modifyEventPresenter;
        this.eventFactory = eventFactory;
    }

    @Override
    public ModifyEventResponseModel create(ModifyEventRequestModel requestModel) {

        // event has conflict
        if (modifyEventDsGateway.hasConflict(requestModel.getStartTime(), requestModel.getEndTime())) {
            return presenter.prepareFailView("This event has a conflict.");
        }

        Event commute = null;

        // if this event has commute
        if (requestModel.getIsCommute()){
            // create commute event
            commute = eventFactory.create(requestModel.getName() + " commute",
                    requestModel.getStartTime().minusMinutes(requestModel.getCommute()),
                    requestModel.getStartTime(), true, null, requestModel.getLocation());
        }

        // new event
        Event event = eventFactory.create(requestModel.getName(), requestModel.getStartTime(),
                requestModel.getEndTime(), false, commute, requestModel.getLocation());

        // invalid event
        if (!event.isValid()) {
            return presenter.prepareFailView("Event start must be before event end.");
        }

        // if event has no issues

        // if it has a commute
        if (requestModel.getIsCommute()) {
            assert commute != null;
            ModifyEventDsRequestModel commuteDsModel = new ModifyEventDsRequestModel(commute.getName(),
                    commute.getStartTime(), commute.getEndTime(), 0, true, commute.getLocation());
        }

        ModifyEventDsRequestModel eventDsModel = new ModifyEventDsRequestModel(event.getName(), event.getStartTime(),
                event.getEndTime(), requestModel.getCommute(), requestModel.getIsCommute(), event.getLocation());

        ModifyEventResponseModel eventResponseModel = new ModifyEventResponseModel(event.getName(),
                " successfully modified");

        return presenter.prepareSuccessView(eventResponseModel);
    }
}

