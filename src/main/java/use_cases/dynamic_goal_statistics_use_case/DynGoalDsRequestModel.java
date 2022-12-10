package use_cases.dynamic_goal_statistics_use_case;

public class DynGoalDsRequestModel {
    private String goalName;
    private int duration;

    public DynGoalDsRequestModel(String name, int duration) {
        this.goalName = name;
        this.duration = duration;
    }

    public String getGoalName() {
        return this.goalName;
    }
    public void setGoalName(String newName) { this.goalName = newName; }

    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int newDuration) { this.duration = newDuration; }
}
