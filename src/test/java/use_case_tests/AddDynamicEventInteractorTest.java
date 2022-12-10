package use_case_tests;

import entities.DynamicEventFactory;
import org.junit.Test;
import screens.InMemoryEvent;
import use_cases.add_dynamic_event_use_case.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class AddDynamicEventInteractorTest {

    @Test
    public void testUseCaseInteractor() {

        // Created an anonymous implementing class.
        AddDynamicEventDsGateway eventRepository = new InMemoryEvent();

        AddDynamicEventPresenter presenter = new AddDynamicEventPresenter() {
            @Override
            public AddDynamicEventResponseModel prepareSuccessView(AddDynamicEventResponseModel dynamicEvent) {
                assertEquals("study math", dynamicEvent.getName());
                return null;
            }

            @Override
            public AddDynamicEventResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }

        };

        DynamicEventFactory dynamicEventFactory = new DynamicEventFactory();
        AddDynamicEventInputBoundary interactor = new AddDynamicEventInteractor(eventRepository,
                presenter, dynamicEventFactory);

        // Input data is normally created by Controller.
        // However, for the purposes of testing, we can make up an event.
        String start_time_str = "29/07/2023 11:45";
        String end_time_str = "29/07/2023 13:45";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);
        LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);
        AddDynamicEventRequestModel inputData = new AddDynamicEventRequestModel(
                "study math", start_time, end_time, "home");

        // Running the use case.
        interactor.create(inputData);

    }
}
