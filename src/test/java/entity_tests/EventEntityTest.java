package entity_tests;

import entities.RecurrentEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventEntityTest {


    @Test
    public void EventEntityConstructor() {

        RecurrentEvent tester = new RecurrentEvent("Hangout",
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(13, 0)),
                null, null);
        Assertions.assertEquals("Hangout", tester.getName());
    }
}
