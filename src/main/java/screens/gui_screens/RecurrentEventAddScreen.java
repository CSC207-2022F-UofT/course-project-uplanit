package screens.gui_screens;

import screens.controllers.RecurrentEventController;
import use_cases.recurrent_event_use_case.RecurrentEventRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;


public class RecurrentEventAddScreen extends JFrame implements ActionListener {
    JTextField eventName = new JTextField(15);
    JTextField eventType = new JTextField("R", 15);
    SimpleDateFormat eventDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
    JFormattedTextField eventDateStart = new JFormattedTextField(eventDateFormat);
    JFormattedTextField eventDateEnd = new JFormattedTextField(eventDateFormat);

    RecurrentEventController recurrentEventController;

    public RecurrentEventAddScreen(RecurrentEventController controller) {
        this.recurrentEventController = controller;
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

        LabelTextPanel eventNameInfo = new LabelTextPanel(new JLabel("Event Name:"), eventName);

        panel.add(eventNameInfo);

        LabelDatePanel eventDateStartInfo = new LabelDatePanel(
                new JLabel("Enter the start time: (day/Month/year hour:minute)"), eventDateStart);

        LabelDatePanel eventDateEndInfo = new LabelDatePanel(
                new JLabel("Enter the end time: (day/Month/year hour:minute)"), eventDateEnd);

        panel.add(eventDateStartInfo);
        panel.add(eventDateEndInfo);

        JButton submit = new JButton("Submit");
        submit.addActionListener(this);

        panel.add(submit);

        this.add(panel);
    }



    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        try {
            recurrentEventController.create(eventName.getText(),
                    eventDateStart.getText(), eventDateEnd.getText(), "false","0",
                    "Library", eventType.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }

}
