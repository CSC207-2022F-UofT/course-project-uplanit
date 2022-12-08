package use_cases.recurrent_event_use_case;

// Use case layer

public interface RecurrentEventPresenter {

    RecurrentEventResponseModel prepareSuccessView(RecurrentEventResponseModel event);

    RecurrentEventResponseModel prepareFailView(String error);
}
