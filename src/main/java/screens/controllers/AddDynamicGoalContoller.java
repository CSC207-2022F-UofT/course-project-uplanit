package screens.controllers;


import use_cases.create_dynamic_goal_use_case.CreateGoalInputBoundary;
import use_cases.create_dynamic_goal_use_case.InputDataStructure;
import use_cases.create_dynamic_goal_use_case.OuputDataStructure;

public class AddDynamicGoalContoller {

    final CreateGoalInputBoundary GoalInput;

    public AddDynamicGoalContoller(CreateGoalInputBoundary gateway) {

        this.GoalInput = gateway;

    }

    OuputDataStructure create(String durationInMin, String name, String startDate, String endDate) {
        InputDataStructure requestModel = new InputDataStructure(durationInMin, name, startDate, endDate);

        return GoalInput.create(requestModel);
    }
}

