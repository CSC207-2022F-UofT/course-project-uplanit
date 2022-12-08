package use_cases.add_single_event_use_case;

import java.time.LocalDateTime;

public class AddSingleEventResponseModel {
    private String name;

    public AddSingleEventResponseModel(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}
