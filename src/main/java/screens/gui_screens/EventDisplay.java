package screens.gui_screens;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class EventDisplay extends JPanel {
    public EventDisplay() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new EtchedBorder()));
        //random data, this will be getting information from the week display to showcase it
        JLabel name = new JLabel("Event Name");
        JLabel type = new JLabel("Event type");
        JLabel date = new JLabel("Event Date");
        this.add(name);
        this.add(date);
        this.add(type);
    }

}
