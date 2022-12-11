package use_cases.create_dynamic_goal_use_case;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputDataStructure {
    private int goalInMinutes;
    private String goalTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    //The user will input text; this is passed to the use case interactor layer as strings, but these need to be
    //turned into ints and DateTime objects.
    // we are assuming that the dates are formatted as "dd/mm/yy"
    public InputDataStructure(String goalDuration, String goalName, String startDate, String endDate ){
        this.goalInMinutes = Integer.parseInt(goalDuration);
        this.goalTitle = goalName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd//MM/yy");
        this.startDate = LocalDate.parse(startDate, formatter); //saving the instance attribute as the actual DateTime obj
        this.endDate = LocalDate.parse(endDate, formatter);
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
