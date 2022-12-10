//Screen that lets you add a Single Event, uses BoxLayout as Layout Manager
package screens.gui_screens;


import screens.controllers.AddDynamicEventController;
import screens.controllers.AddSingleEventController;
import use_cases.add_single_event_use_case.AddSingleEventDsRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SingleEventAddScreen extends JPanel implements ActionListener {
    JTextField eventName = new JTextField(15);
    JTextField eventType = new JTextField("S", 15);

    JTextField eventDateStart = new JTextField(15);
    JTextField eventDateEnd = new JTextField(15);

    JTextField commute = new JTextField(15);

    AddSingleEventController singleEventController;
    public SingleEventAddScreen(AddSingleEventController singleEventController) {
        this.singleEventController = singleEventController;

        this.setLayout(new FlowLayout());
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel title = new JLabel("Add an event!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(12, 7, 125));
        this.add(title);

        LabelTextPanel eventNameInfo = new LabelTextPanel(new JLabel("Event Name:"), eventName);
        this.add(eventNameInfo);

        LabelTextPanel commuteInfo = new LabelTextPanel(
                new JLabel("Commute time"), commute);
        this.add(commuteInfo);

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
            singleEventController.create(eventName.getText(),
                    eventDateStart.getText(), eventDateEnd.getText(), commute.getText(), "library");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }

}
