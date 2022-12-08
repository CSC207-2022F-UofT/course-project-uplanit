package use_cases.create_dynamic_goal_use_case;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GatewayDataStructure {
    private int goalInMinutes;
    private String goalTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    public GatewayDataStructure(int goalDuration, String goalName, LocalDate startDate, LocalDate endDate){
        this.goalInMinutes = goalDuration;
        this.goalTitle = goalName;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public int getGoalInMinutes(){return goalInMinutes;}

    public String getGoalTitle(){return goalTitle;}

    public String getStartDate(){

        // Create DateTimeFormatter instance with specified format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Get Start date as LocalDate object and format LocalDateTime to String
        String formattedDateTime = this.startDate.format(dateTimeFormatter);
        return formattedDateTime;
    }

    public String getEndDate(){
        // Create DateTimeFormatter instance with specified format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Get Start date as LocalDate object and format LocalDateTime to String
        String formattedDateTime = this.endDate.format(dateTimeFormatter);
        return formattedDateTime;
    }

    public void setGoalInMinutes(int newGoal){this.goalInMinutes = newGoal; }
    public void setGoalTitle(String newTitle) {this.goalTitle = newTitle; }
}

