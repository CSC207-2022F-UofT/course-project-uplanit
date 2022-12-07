package use_cases.modify_event_use_case;
import java.time.LocalDateTime;


public interface ModifyEventDsGateway {
    boolean hasConflict(LocalDateTime startTime, LocalDateTime endTime);

    void save(ModifyEventDsRequestModel requestModel);
}
