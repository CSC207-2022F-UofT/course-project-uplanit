package screens.gui_screens;

import screens.controllers.RecurrentEventController;

import javax.swing.*;
import java.awt.*;

public class EventsAddScreen extends JPanel {
    public EventsAddScreen() {
        this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));



        JLabel title = new JLabel("Add an Event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//

        EventAddButton recurringEventButton = new EventAddButton("Add a Recurring Event");
        EventAddButton singleEventButton = new EventAddButton("Add an Event");
        EventAddButton deadlineEventButton = new EventAddButton("Add a deadline");
//
        this.add(title);
        this.add(recurringEventButton);
        this.add(singleEventButton);
        this.add(deadlineEventButton);
    }

}
