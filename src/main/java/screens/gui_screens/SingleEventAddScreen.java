//Screen that lets you add a Single Event, uses BoxLayout as Layout Manager


package screens.gui_screens;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.*;

public class SingleEventAddScreen extends JFrame implements ActionListener{
    public SingleEventAddScreen() {
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

        JTextField eventType = new JTextField("S", 15);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }
}
