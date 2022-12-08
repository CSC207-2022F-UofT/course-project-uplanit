package use_cases.dynamic_goal_statistics_use_case;

public class DynamicGoalStatsRequestModel {
    private String goal;

    public DynamicGoalStatsRequestModel(String goal) {
        this.goal = goal;
    }

    String getGoalName() {
        return goal;
    }

    void setGoalName(String goal) {
        this.goal = goal;
    }
}
