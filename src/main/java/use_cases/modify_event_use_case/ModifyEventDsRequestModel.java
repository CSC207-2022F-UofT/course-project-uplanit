package use_cases.modify_event_use_case;
import java.time.LocalDateTime;

public class ModifyEventDsRequestModel {

    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int commuteTime;

    boolean isCommute;
    String location;

    public ModifyEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime,
                                   int commuteTime, boolean isCommute, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;
        this.isCommute = isCommute;
    }

    public String getName(){return name;}

    public LocalDateTime getStartTime(){return startTime;}

    public LocalDateTime getEndTime(){return endTime;}

    public int getCommute(){return commuteTime;}

    public boolean getIsCommute(){return isCommute;}

    public String getLocation(){return location;}


}
