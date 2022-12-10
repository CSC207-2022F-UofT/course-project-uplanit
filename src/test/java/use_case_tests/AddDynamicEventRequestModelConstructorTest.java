package use_case_tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_cases.add_dynamic_event_use_case.AddDynamicEventRequestModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddDynamicEventRequestModelConstructorTest {

    @Test
    public void testRequestModelConstructor() {

        String start_time_str = "29/07/2023 11:45";
        String end_time_str = "29/07/2023 13:45";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);
        LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);
        AddDynamicEventRequestModel requestModel = new AddDynamicEventRequestModel("study biology",
                start_time, end_time, "biology lab" );


        Assertions.assertEquals("study biology", requestModel.getName());
        Assertions.assertEquals("29/07/2023 11:45", requestModel.getStartTime().format(formatter));
        Assertions.assertEquals("29/07/2023 13:45", requestModel.getEndTime().format(formatter));
        Assertions.assertEquals("biology lab", requestModel.getLocation());

    }

}
