package use_cases.dynamic_goal_statistics_use_case;

public interface DynamicGoalStatsPresenter {
    DynamicGoalStatsResponseModel prepareSuccessView(DynamicGoalStatsResponseModel user);

    DynamicGoalStatsResponseModel prepareFailView(String error);
}
