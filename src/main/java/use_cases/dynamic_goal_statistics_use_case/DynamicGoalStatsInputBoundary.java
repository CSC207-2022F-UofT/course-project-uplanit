package use_cases.dynamic_goal_statistics_use_case;

public interface DynamicGoalStatsInputBoundary {
    DynamicGoalStatisticsResponseModel create(DynamicGoalStatisticsRequestModel requestModel);
}
