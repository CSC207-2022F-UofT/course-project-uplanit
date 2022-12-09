package use_case_event_modifier_tests;

import entities.RecurrentEvent;
import entities.SingleEvent;
import entities.EventFactory;
import entities.SingleEventFactory;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.add_single_event_use_case.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import screens.controllers.EventModifierController;
import screens.controllers.FileAddEvent;
import screens.controllers.FileEventModifier;
import use_cases.add_single_event_use_case.*;
import use_cases.modify_event_use_case.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.rules.ExpectedException;
import static org.junit.jupiter.api.Assertions.*;

public class EventModifierTest {

    SingleEvent non_commute_test;
    LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2022, 12, 20), LocalTime.of(11, 0));

    LocalDateTime endTime = LocalDateTime.of(LocalDate.of(2022, 12, 20), LocalTime.of(13, 0));

    @Test
    public void TestSingleEventConstructor() {

        SingleEvent non_commute_test = new SingleEvent("Meeting",
                LocalDateTime.of(LocalDate.of(2022, 12, 20), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 12, 20), LocalTime.of(13, 0)),
                false, null, null);
        Assertions.assertEquals("Meeting", non_commute_test.getName());

    }


    EventModifierDsGateway gateway;
    AddSingleEventDsGateway SingleEventGateway;

    @Test
    public void AddAndModifyNonCommuteEvent(){
        try{
            SingleEventGateway = new FileAddEvent("./events.csv");
            gateway = new FileEventModifier("./events.csv");
        }
        catch (IOException e) {
            throw new RuntimeException("Could Not Create File");
        }

        AddSingleEventDsRequestModel singleEventDsRequestModel = new AddSingleEventDsRequestModel("Meeting", startTime, endTime, false, 0, "house", "S");
        EventModifierDsRequestModel dsRequestModel = new EventModifierDsRequestModel("Meeting", startTime, endTime, 0, false, "house");

        AddSingleEventPresenter presenterSingleEvent = new AddSingleEventPresenter() {
            @Override
            public AddSingleEventResponseModel prepareSuccessView(AddSingleEventResponseModel event) {
                assertEquals("Meeting", event.getName());
                return null;
            }

            @Override
            public AddSingleEventResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        SingleEventFactory eventFactory = new SingleEventFactory();
        AddSingleEventInputBoundary interactorSingleEvent = new AddSingleEventInteractor(
                SingleEventGateway, presenterSingleEvent, eventFactory);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        String formattedStartTime= startTime.format(dateTimeFormatter);
        String formattedEndTime = endTime.format(dateTimeFormatter);

        AddSingleEventRequestModel inputDataEvent = new AddSingleEventRequestModel(
                "Meeting", formattedStartTime, formattedEndTime, "null", "house");

        interactorSingleEvent.create(inputDataEvent);

        // event modifier

        EventModifierPresenter presenter = new EventModifierPresenter() {

            @Override
            public EventModifierResponseModel prepareSuccessView(EventModifierResponseModel event) {

                assertEquals("Meeting", event.getName());
                return null;
            }

            @Override
            public EventModifierResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        EventModifierInputBoundary interactor = new EventModifierInteractor(
                gateway, presenter, dsRequestModel);

        EventModifierRequestModel inputData = new EventModifierRequestModel (
                "Meeting", startTime, endTime, 0, false, "house", "S");

        interactor.create(inputData);
    }
}
