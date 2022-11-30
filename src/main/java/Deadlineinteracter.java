import java.util.Date;
import entities.Deadline;
import entities.Week;


public class DeadlineInteractor {
   public static void addDeadline(String name, Date date){
      Deadline deadline = entities.Deadline(name, date);
      Date startdate = entities.Calendar.getSunday(date);
      Week week1 = entities.Calendar.getWeek(startdate);
      entities.Week.week1.addDeadline(deadline);
   }

}
