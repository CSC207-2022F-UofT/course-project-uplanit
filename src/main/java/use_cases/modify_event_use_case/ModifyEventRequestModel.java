package use_cases.modify_event_use_case;

import java.time.LocalDateTime;

public class ModifyEventRequestModel {
    private String name;
    private LocalDateTime startTime;
    private  LocalDateTime endTime;
    private int commuteTime;
    private  final boolean isCommute;
    private String location;

    public ModifyEventRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, int commuteTime,
                                   boolean isCommute, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commuteTime = commuteTime;
        this.isCommute = isCommute;
        this.location = location;

    }

    public String getName(){return name;}

    public LocalDateTime getStartTime(){return startTime;}

    public LocalDateTime getEndTime(){return endTime;}

    public int getCommute(){return commuteTime;}

    public boolean getIsCommute(){return isCommute;}

    public String getLocation(){return location;}


    public void setName(String name){this.name = name;}

    public void setStartTime(LocalDateTime startTime){this.startTime = startTime;}

    public void setEndTime(LocalDateTime endTime){this.endTime = endTime;}

    public void setCommuteTime(int commuteTime){this.commuteTime = commuteTime;}

    public void setLocation(String location){this.location = location;}

}
