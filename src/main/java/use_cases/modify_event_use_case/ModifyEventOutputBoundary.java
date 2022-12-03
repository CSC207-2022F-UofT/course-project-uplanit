package use_cases.modify_event_use_case;

import entities.Event;

import java.time.LocalDateTime;

public interface ModifyEventOutputBoundary {
    public void PresentNewInfo(Event e);
}
