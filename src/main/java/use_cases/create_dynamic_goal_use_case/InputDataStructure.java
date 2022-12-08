package use_cases.create_dynamic_goal_use_case;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputDataStructure {
    private int goalInMinutes;
    private String goalTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    public InputDataStructure(int goalDuration, String goalName, LocalDate startDate, LocalDate endDate ){
        this.goalInMinutes = goalDuration;
        this.goalTitle = goalName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    int getGoalInMinutes(){return goalInMinutes;}

    String getGoalTitle(){return goalTitle;}

    LocalDate getStartDate(){return startDate; }

    LocalDate getEndDate(){return endDate; }

    void setGoalInMinutes(int newGoal){this.goalInMinutes = newGoal; }
    void setGoalTitle(String newTitle) {this.goalTitle = newTitle; }

    void setStartDate(String startDateStr){
        //takes in a string but saves it as a LocalDate object
        LocalDate stringToDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        this.startDate = stringToDate;
    }
    void setEndDate(String endDateStr){
        //takes in a string but saves it as a LocalDate object
        LocalDate stringToDate2 = LocalDate.parse(endDateStr, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        this.endDate = stringToDate2;
    }
}
