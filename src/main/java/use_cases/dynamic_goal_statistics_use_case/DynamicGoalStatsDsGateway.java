package use_cases.dynamic_goal_statistics_use_case;

// Use-Case Layer

public interface DynamicGoalStatsDsGateway {
    boolean existsByName(String identifier);

    void save(DynamicGoalStatsDsRequestModel requestModel);


}
