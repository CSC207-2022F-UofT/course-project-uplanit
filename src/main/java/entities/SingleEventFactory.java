package entities;
import java.time.LocalDateTime;

// Entity layer

public class SingleEventFactory implements EventFactory {

    @Override
    public Event create(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                        Event commute, String location) {

        return new SingleEvent(name, startTime, endTime, isCommute, commute, location);
    }
}
