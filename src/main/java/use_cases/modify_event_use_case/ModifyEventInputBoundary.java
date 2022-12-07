package use_cases.modify_event_use_case;
import entities.*;

import java.time.LocalDateTime;

public interface ModifyEventInputBoundary {
    ModifyEventResponseModel create(ModifyEventRequestModel requestModel);
}
