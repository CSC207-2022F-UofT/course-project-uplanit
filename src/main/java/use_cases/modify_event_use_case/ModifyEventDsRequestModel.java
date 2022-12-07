package use_cases.modify_event_use_case;
import java.time.LocalDateTime;

public class ModifyEventDsRequestModel {

    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int commuteTime;
    String location;

    public ModifyEventDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime,
                                   int commuteTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.location = location;
    }


}
