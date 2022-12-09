package use_cases.delete_event_use_case;

// Use case layer

public interface DeleteEventPresenter {

    DeleteEventResponseModel prepareSuccessView(DeleteEventResponseModel responseModel);

    DeleteEventResponseModel prepareFailView(String error);
}
