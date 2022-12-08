package use_cases.dynamic_goal_statistics_use_case;

import entities.Week;

import java.time.Duration;
import java.util.HashMap;

// Use-Case Layer

public class DynamicGoalStatsDsRequestModel {

    private final String goalName;
    private HashMap<String, Duration> timeSpent;
    private final Week week;

    public DynamicGoalStatsDsRequestModel(String name, Week week) {
        this.goalName = name;
        this.week = week;
        this.timeSpent = new HashMap<>();
        getStatistics(timeSpent);

    }

    public void getStatistics(HashMap<String, Duration> timeSpent) {
        for(String goal: timeSpent.keySet()){
            if(goal.equals(this.getGoalName())){

            }
        }
    }

    public String getGoalName() {
        return this.goalName;
    }

    public Week getWeek() {
        return this.week;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
