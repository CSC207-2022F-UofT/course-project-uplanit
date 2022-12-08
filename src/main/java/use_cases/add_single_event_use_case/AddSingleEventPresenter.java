package use_cases.add_single_event_use_case;

public interface AddSingleEventPresenter {
    public AddSingleEventResponseModel prepareSuccessView(AddSingleEventResponseModel user);

    public AddSingleEventResponseModel prepareFailView(String error);
}
