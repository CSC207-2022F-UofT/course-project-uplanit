package use_cases.dynamic_goal_statistics_use_case;

public class DynGoalDsRequestModel {
    private final String goalName;
    private final int duration;

    public DynGoalDsRequestModel(String name, int duration) {
        this.goalName = name;
        this.duration = duration;
    }

    public String getGoalName() {
        return this.goalName;
    }
}
