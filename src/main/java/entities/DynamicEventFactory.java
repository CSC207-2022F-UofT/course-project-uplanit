package entities;
import java.time.LocalDateTime;

// Entity Layer

public class DynamicEventFactory implements EventFactory {

    @Override
    public Event create(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                        Event commute, String location) {

        return new DynamicEvent(name, startTime, endTime, isCommute, commute, location);
    }
}
