package use_cases.create_dynamic_goal_use_case;

public interface CreateGoalPresenter {

    OuputDataStructure prepareSuccessView(OuputDataStructure);
    OuputDataStructure prepareFailView(String error);

}
