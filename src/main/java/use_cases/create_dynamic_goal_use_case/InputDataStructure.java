package use_cases.create_dynamic_goal_use_case;

public class InputDataStructure {
    private int goalInMinutes;
    private String goalTitle;
    public InputDataStructure(int goalDuration, String goalName){
        this.goalInMinutes = goalDuration;
        this.goalTitle = goalName;
    }

    int getGoalInMinutes(){return goalInMinutes;}

    String getGoalTitle(){return goalTitle;}

    void setGoalInMinutes(int newGoal){this.goalInMinutes = newGoal; }
    void setGoalTitle(String newTitle) {this.goalTitle = newTitle; }
}
