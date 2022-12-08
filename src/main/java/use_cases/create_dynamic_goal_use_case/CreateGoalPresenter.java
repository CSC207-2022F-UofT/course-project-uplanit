package use_cases.create_dynamic_goal_use_case;

public interface CreateGoalPresenter {

    OuputDataStructure prepareSuccessView(OuputDataStructure dataToPresent);
    OuputDataStructure prepareFailView(String error);

}
