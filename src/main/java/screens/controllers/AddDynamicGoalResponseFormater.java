package screens.controllers;

import use_cases.create_dynamic_goal_use_case.CreateGoalPresenter;
import use_cases.create_dynamic_goal_use_case.OuputDataStructure;

//Goblin that passes information between dependency layers without modifying it whatsoever.
// Not particularly useful now,
//but shows Open Closed principle

public class AddDynamicGoalResponseFormater implements CreateGoalPresenter{

    @Override
    public OuputDataStructure prepareSuccessView(OuputDataStructure dataToPresent) {
        return dataToPresent;
    }

    @Override
    public OuputDataStructure prepareFailView(String error) {
        throw new AddDynamicGoalFailed(error);
    }
}


