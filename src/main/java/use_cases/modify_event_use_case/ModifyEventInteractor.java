package use_cases.modify_event_use_case;

import entities.*;
import java.time.LocalDateTime;


public class ModifyEventInteractor implements ModifyEventInputBoundary {

    final ModifyEventDsGateway modifyEventDsGateway;
    ModifyEventPresenter presenter;


    public ModifyEventInteractor(ModifyEventDsGateway modifyEventDsGateway,
                                 ModifyEventPresenter modifyEventPresenter)
    {
        this.modifyEventDsGateway = modifyEventDsGateway;
        this.presenter = modifyEventPresenter;
    }

    @Override
    public ModifyEventResponseModel create(ModifyEventRequestModel requestModel) {

        // event has conflict
        if (modifyEventDsGateway.hasConflict(requestModel)) {
            return presenter.prepareFailView("This event has a conflict.");
        }

        if (!isSingleEvent(requestModel.getEventType())){
            return presenter.prepareFailView("This event is not modifiable");
        }

        ModifyEventDsRequestModel userDsModel = new ModifyEventDsRequestModel(requestModel.getName(),
                requestModel.getStartTime(), requestModel.getEndTime(),
                requestModel.getCommute(), requestModel.getIsCommute(), requestModel.getLocation());

        modifyEventDsGateway.save(userDsModel);

        ModifyEventResponseModel eventResponseModel = new ModifyEventResponseModel("event successfully modified");

        return presenter.prepareSuccessView(eventResponseModel);
    }

    public boolean isSingleEvent(String identifier) {
        // checks if this a single event
        return identifier.equals("S");
    }
}

