package entities;

import java.sql.Time;
import java.util.Date;


public class Deadline {
    public String name;
    public Date date;


    /**
     * Constructs a new deadline with the given name and occurring at the given date.
     *
     * @param name the name of this deadline
     * @param date the date and time that this deadline occurs at
     */
    public Deadline(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
