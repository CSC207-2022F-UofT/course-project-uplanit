package screens;
import entities.*;

import java.time.LocalDateTime;

public interface ModifyEventInputBoundary {
    public void SetNewName(String name);
    public void SetNewStartTime(LocalDateTime startTime);
    public void SetNewEndTime(LocalDateTime endTime);
    public void SetNewLocation(String location);
    public void SetNewCommute(Event commute);
}
