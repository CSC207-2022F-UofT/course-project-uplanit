/*
This is the Deadline Entity; It stores information for all the deadlines
aaaaaaaaaaaaaaaaaaa
it works!

 */

package entities;
import java.sql.Time;
import java.util.Date;

public class Deadline {
    public String name;
    public Date date;

    public Deadline(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
