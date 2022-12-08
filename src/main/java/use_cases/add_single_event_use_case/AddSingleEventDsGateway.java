package use_cases.add_single_event_use_case;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface AddSingleEventDsGateway {

    public boolean checkConflict(LocalDateTime start, LocalDateTime end);

    public void save(AddSingleEventDsRequestModel newEvent);
}
