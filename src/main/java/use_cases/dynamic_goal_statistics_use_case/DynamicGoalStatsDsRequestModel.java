package use_cases.dynamic_goal_statistics_use_case;

import java.time.Duration;
import java.util.HashMap;

// Use-Case Layer

public class DynamicGoalStatsDsRequestModel {

    private final String goalName;
    //private final String timeSpent;

    public DynamicGoalStatsDsRequestModel(String name) {
        this.goalName = name;

    }

    public String getGoalName() {
        return this.goalName;
    }

    //public String getTimeSpent() {
    //    return this.timeSpent;
    //}
}
