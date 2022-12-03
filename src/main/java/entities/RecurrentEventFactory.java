package entities;
import java.time.LocalDateTime;

// Entity layer

public class RecurrentEventFactory implements EventFactory {

    @Override
    public Event create(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute,
                        Event commute, String location) {

        return new RecurrentEvent(name, startTime, endTime, isCommute, commute, location);
    }
}
