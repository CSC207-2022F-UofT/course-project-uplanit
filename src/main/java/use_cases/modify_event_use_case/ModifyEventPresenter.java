package use_cases.modify_event_use_case;

public interface ModifyEventPresenter {
    ModifyEventResponseModel prepareSuccessView(ModifyEventResponseModel event);
    ModifyEventResponseModel prepareFailView(String error);
}
