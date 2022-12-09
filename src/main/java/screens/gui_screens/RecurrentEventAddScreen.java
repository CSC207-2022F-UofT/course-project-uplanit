package screens.gui_screens;

import screens.controllers.RecurrentEventController;
import use_cases.recurrent_event_use_case.RecurrentEventRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecurrentEventAddScreen extends JPanel implements ActionListener {
    JTextField eventName = new JTextField(15);
    JTextField eventType = new JTextField("R", 15);

    JTextField eventDateStart = new JTextField(15);
    JTextField eventDateEnd = new JTextField(15);

    RecurrentEventController recurrentEventController;

    public RecurrentEventAddScreen(RecurrentEventController controller) {
        this.recurrentEventController = controller;

        this.setLayout(new FlowLayout());
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel title = new JLabel("Add a recurring event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(12, 7, 125));
        this.add(title);

        LabelTextPanel eventNameInfo = new LabelTextPanel(new JLabel("Event Name:"), eventName);
        this.add(eventNameInfo);
        JLabel formatinfo = new JLabel("(Format: dd/MM/YY HH:MM)");
        this.add(formatinfo);

        LabelTextPanel eventDateStartInfo = new LabelTextPanel(
                new JLabel("Start Time:"), eventDateStart);

        LabelTextPanel eventDateEndInfo = new LabelTextPanel(
                new JLabel("End Time"), eventDateEnd);

        this.add(eventDateStartInfo);
        this.add(eventDateEndInfo);

        JButton submit = new JButton("Submit");
        submit.addActionListener(this);

        this.add(submit);
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
