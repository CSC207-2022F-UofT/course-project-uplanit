package screens.gui_screens;

import screens.controllers.RecurrentEventController;
import use_cases.recurrent_event_use_case.RecurrentEventRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;


public class RecurrentEventAddScreen extends JFrame implements ActionListener {
    public RecurrentEventAddScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setSize sets the size of the screen and setDefaultCloseOperation defines
        this.setSize(950,675);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Add a one time event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(12, 7, 125));

        JLabel eventNameLabel = new JLabel("Event Name:");
        JTextField eventName = new JTextField(15);

        panel.add(eventNameLabel);
        panel.add(eventName);

        JTextField eventType = new JTextField("R", 15);

        SimpleDateFormat eventDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");

        JLabel eventDateStartLabel = new JLabel("Enter the start time: (day/Month/year hour:minute)");
        JFormattedTextField eventDateStart = new JFormattedTextField(eventDateFormat);

        JLabel eventDateEndLabel = new JLabel("Enter the End time: (day/Month/year hour:minute)");
        JFormattedTextField eventDateEnd = new JFormattedTextField(eventDateFormat);

        panel.add(eventDateStartLabel);
        panel.add(eventDateStart);
        panel.add(eventDateEndLabel);
        panel.add(eventDateEnd);

        JButton submit = new JButton("Submit");
        submit.addActionListener(this);

        panel.add(submit);

        this.add(panel);
    }



    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
