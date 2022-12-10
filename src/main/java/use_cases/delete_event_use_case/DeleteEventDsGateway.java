package use_cases.delete_event_use_case;

// Use case layer

import java.time.LocalDateTime;

public interface DeleteEventDsGateway {

    boolean isEvent(LocalDateTime startTime);

    void delete(DeleteEventDsRequestModel requestModel);

}
