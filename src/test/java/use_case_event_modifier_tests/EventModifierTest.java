package use_case_event_modifier_tests;

import entities.RecurrentEvent;
import entities.SingleEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.controllers.EventModifierController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventModifierTest {

    SingleEvent non_commute_test;
    EventModifierController modifier_controller;

    @Test
    public void SingleEventConstructor() {

        SingleEvent non_commute_test = new SingleEvent("Meeting",
                LocalDateTime.of(LocalDate.of(2022, 12, 20), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 12, 20), LocalTime.of(13, 0)),
                false, null, null);
        Assertions.assertEquals("Meeting", non_commute_test.getName());
    }

    @Test
    public void EventModifierConstructor(){
        EventModifierController modifier_controller = new EventModifierController(non_commute_test);
    }
}
