package use_cases.modify_event_use_case;


import screens.gui_screens.EventModifierResponseModel;

public class EventModifierInteractor implements EventModifierInputBoundary {

    final EventModifierDsGateway eventModifierDsGateway;
    final EventModifierDsRequestModel dsRequestModel;
    EventModifierPresenter presenter;


    public EventModifierInteractor(EventModifierDsGateway eventModifierDsGateway,
                                   EventModifierPresenter eventModifierPresenter,
                                   EventModifierDsRequestModel eventModifierDsRequestModel)
    {
        this.eventModifierDsGateway = eventModifierDsGateway;
        this.presenter = eventModifierPresenter;
        this.dsRequestModel = eventModifierDsRequestModel;
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

        checkChangedInfo(requestModel);

        // now this model should contain info that remains the same & updated info (for applied category only)
        EventModifierDsRequestModel userDsModel = new EventModifierDsRequestModel(requestModel.getName(),
                requestModel.getStartTime(), requestModel.getEndTime(),
                requestModel.getCommuteTime(), requestModel.getIsCommute(), requestModel.getLocation());

        eventModifierDsGateway.save(userDsModel);

        EventModifierResponseModel eventResponseModel = new EventModifierResponseModel(requestModel.getName(),
                "event successfully modified");

        return presenter.prepareSuccessView(eventResponseModel);
    }

    public boolean isSingleEvent(String identifier) {
        // checks if this a single event
        return identifier.equals("S");
    }

    public void checkChangedInfo (EventModifierRequestModel reqModel){
        boolean n = false;
        boolean s = false;
        boolean e = false;
        boolean cTime = false;
        boolean isC = false;
        boolean l = false;

        if (!reqModel.getName().equals("")){
            n = true;
        }

        if (reqModel.getStartTime() != null){
            s = true;
        }
        if (reqModel.getEndTime() != null){
            e = true;
        }
        if (reqModel.getCommuteTime() != -1){
            cTime = true;
        }

        if (reqModel.getIsCommute() != dsRequestModel.getIsCommute()){
            isC = true;
        }

        if (!reqModel.getLocation().equals("")){
            l = true;
        }


        // for information that is not changed

        if (!n){
            reqModel.setName(dsRequestModel.name);
        }

        if (!s){
            reqModel.setStartTime(dsRequestModel.startTime);
        }

        if (!e){
            reqModel.setEndTime(dsRequestModel.endTime);
        }

        if (!cTime){
            reqModel.setCommuteTime(dsRequestModel.commuteTime);
        }

        if (!isC){
            reqModel.setIsCommute(dsRequestModel.getIsCommute());
        }

        if (!l){
            reqModel.setLocation(dsRequestModel.location);
        }
    }
}

