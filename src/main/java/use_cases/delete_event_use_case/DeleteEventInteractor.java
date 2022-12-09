package use_cases.delete_event_use_case;

// Use case layer

public class DeleteEventInteractor implements DeleteEventInputBoundary {

    final DeleteEventDsGateway deleteEventDsGateway;
    final DeleteEventPresenter deleteEventPresenter;


    public DeleteEventInteractor(DeleteEventDsGateway deleteEventDsGateway, DeleteEventPresenter deleteEventPresenter) {

        this.deleteEventDsGateway = deleteEventDsGateway;
        this.deleteEventPresenter = deleteEventPresenter;
    }

// Check whether the user inputted event exists and if it does then delete it.
    @Override
    public DeleteEventResponseModel create(DeleteEventRequestModel requestModel) {

        if (!deleteEventDsGateway.isEvent(requestModel.getStartTime())) {

            return deleteEventPresenter.prepareFailView("This event does not exist.");
        }

        DeleteEventDsRequestModel eventDsRequestModel = new DeleteEventDsRequestModel(requestModel.getName(),
                requestModel.getStartTime(), requestModel.getEndTime(), false, requestModel.getCommute(),
                requestModel.getLocation(), requestModel.getEventType());

        deleteEventDsGateway.delete(eventDsRequestModel);

        DeleteEventResponseModel eventResponseModel = new DeleteEventResponseModel(requestModel.getName(), " deleted.");

        return deleteEventPresenter.prepareSuccessView(eventResponseModel);

    }
}
