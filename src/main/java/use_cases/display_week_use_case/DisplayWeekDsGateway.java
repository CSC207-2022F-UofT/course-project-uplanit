package use_cases.display_week_use_case;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public interface DisplayWeekDsGateway {
    public HashMap<LocalDateTime, DisplayWeekDsRequestModel> eventMap();

}
