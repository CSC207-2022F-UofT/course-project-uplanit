/*
This entity determines the format and controls the creation of dynamic goals
 */
package entities;
import java.time.LocalDate;

public class DynamicGoal {


    /** Constructs a DynamicEvent with a name, startTime, endTime, commuteTime, and location.
     *
     * @param name the name of the dynamic goal to be created
     * @param duration the duration in minutes of the dynamic goal to be created
     * @param startDate the start date of the dynamic goal to be created
     * @param endDate the end date of the dynamic goal to be created
     */
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    private int durationInMinutes;



    public DynamicGoal(String name, int duration, LocalDate startTime, LocalDate endTime){

        this.name = name;
        this.startDate = startTime;
        this.endDate = endTime;
        this.durationInMinutes = duration;
    }
    public String getName() {
        return name;
    }


    public int getDuration() {
        return durationInMinutes;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isValid() {
        if (endDate.isBefore(this.startDate)) {
            return false;
        }

        if(this.durationInMinutes >= 10080) {return false;}
        return true;
    }
}

