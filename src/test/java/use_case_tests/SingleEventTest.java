package use_case_tests;

import entities.RecurrentEvent;
import entities.SingleEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SingleEventTest {
    @Test
    public void EventEntityConstructor() {
        /*

        RecurrentEvent RENameTester = new RecurrentEvent("Hangout",
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(13, 0)), false,
                null, null);
        Assertions.assertEquals("Hangout", RENameTester.getName());

        SingleEvent SENameTester = new SingleEvent("Hangout",
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(13, 0)), false,
                null, null);
        Assertions.assertEquals("Hangout", SENameTester.getName());

        SingleEvent ValidTesterTrue = new SingleEvent("Hangout",
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(13, 0)), false,
                null, null);
        Assertions.assertEquals(true, ValidTesterTrue.isValid());

        SingleEvent ValidTesterOverDay = new SingleEvent("Hangout",
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(11, 0)),
                LocalDateTime.of(LocalDate.of(2022, 10, 24), LocalTime.of(13, 0)), false,
                null, null);
        Assertions.assertEquals(false, ValidTesterOverDay.isValid());

        SingleEvent ValidTesterInverse = new SingleEvent("Hangout",
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(13, 0)),
                LocalDateTime.of(LocalDate.of(2022, 10, 23), LocalTime.of(11, 0)), false,
                null, null);
        Assertions.assertEquals(false, ValidTesterOverDay.isValid());
         */
    }
}
