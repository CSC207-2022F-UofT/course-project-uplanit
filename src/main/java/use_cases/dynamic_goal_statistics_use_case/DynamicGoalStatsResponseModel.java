package use_cases.dynamic_goal_statistics_use_case;

import java.time.Duration;
import java.util.HashMap;

// Use-Case Layer

public class DynamicGoalStatsResponseModel{

    String goal;
    //HashMap<String, Duration> statsPerDay;

    public DynamicGoalStatsResponseModel(String goal) {
        this.goal = goal;
        //this.statsPerDay = calculateStats(goal);
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
