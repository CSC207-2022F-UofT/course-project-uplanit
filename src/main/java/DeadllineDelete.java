import entities.Deadline;
import entities.Calendar;
import entities.Week;
import java.util.Date;

public class DeadlineDelete{
    public static void Delete_deadline(Deadline d) {
        Date date1 = entities.Calendar.getSunday(d.getDate());
        Week week2 = entities.Calendar.getWeek(date1);
        entities.Week.week2.deleteDeadline(d);
    }
}
