package screens;
import entities.*;

import java.time.LocalDateTime;

public interface ModifyEventInputBoundary {
    void SetNewName(String name);
    void SetNewStartTime(LocalDateTime startTime);
    void SetNewEndTime(LocalDateTime endTime);
    void SetNewLocation(String location);
    void SetNewCommute(Event commute);
}
