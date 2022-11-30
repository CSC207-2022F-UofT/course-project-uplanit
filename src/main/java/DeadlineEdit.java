import entities.Deadline;
import java.util.Date;

public class DeadlineEdit {
    public static void deadlineEdit(Deadline d,String name, Date date){
        DeadlineDelete.Delete_deadline(d);
        DeadlineInteractor.addDeadline(name, date);
    }
}
