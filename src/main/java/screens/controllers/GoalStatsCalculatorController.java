package screens.controllers;

import use_cases.dynamic_goal_statistics_use_case.DynamicGoalStatsInputBoundary;
import use_cases.dynamic_goal_statistics_use_case.DynamicGoalStatsRequestModel;
import use_cases.dynamic_goal_statistics_use_case.DynamicGoalStatsResponseModel;

// Interface adapters layer

public class GoalStatsCalculatorController {

    final DynamicGoalStatsInputBoundary userInput;

    public GoalStatsCalculatorController(DynamicGoalStatsInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    DynamicGoalStatsResponseModel create(String goal) {
        DynamicGoalStatsRequestModel requestModel = new DynamicGoalStatsRequestModel(goal);

        return userInput.create(requestModel);
    }
}