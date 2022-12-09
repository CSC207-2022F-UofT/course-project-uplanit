//

package screens.gui_screens;

import screens.controllers.RecurrentEventController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventsAddScreen extends JPanel implements ActionListener {
    public EventsAddScreen(RecurrentEventController recurrentEventController) {
        this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));



        JLabel title = new JLabel("Add an Event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//

        RecurrentEventAddScreen addRecurrentEvent = new RecurrentEventAddScreen(recurrentEventController);
        EventAddButton singleEventButton = new EventAddButton("Add an Event");
        EventAddButton deadlineEventButton = new EventAddButton("Add a deadline");
//
        this.add(title);
        this.add(addRecurrentEvent);
        this.add(singleEventButton);
        this.add(deadlineEventButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
