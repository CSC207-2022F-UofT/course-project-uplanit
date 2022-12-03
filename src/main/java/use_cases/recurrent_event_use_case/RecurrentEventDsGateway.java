package use_cases.recurrent_event_use_case;

// Use case layer

import java.time.LocalDateTime;

public interface RecurrentEventDsGateway {

    boolean hasConflict(LocalDateTime startTime, LocalDateTime endTime);


}
