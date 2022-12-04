package use_cases.dynamic_goal_statistics_use_case;

public interface DynamicGoalStatsDsGateway {
    boolean existsByName(String identifier);

    void save(DynamicGoalStatsDsRequestModel requestModel);


}
