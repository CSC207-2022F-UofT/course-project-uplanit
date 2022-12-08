package use_cases.modify_event_use_case;
import java.time.LocalDateTime;


public interface ModifyEventDsGateway {
    boolean hasConflict(ModifyEventRequestModel newEvent);

    void save(ModifyEventDsRequestModel requestModel);
}
