package entities;
import java.time.LocalDateTime;

// Entity layer

public class RecurrentEvent implements Event {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isCommute;
    private String location;
    private Event commute;


    public RecurrentEvent(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute, Event commute, String location){

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commute = commute;
        this.location = location;
        this.isCommute = isCommute;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Event getCommute() {
        return this.commute;
    }
    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }
    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }
    @Override
    public String getLocation() {
        return location;
    }
    @Override
    public boolean isCommute(){
        return this.isCommute;
    }


    @Override
    public boolean isValid() {
        return startTime.isBefore(endTime) & startTime.getDayOfWeek() == endTime.getDayOfWeek();
    }
}

