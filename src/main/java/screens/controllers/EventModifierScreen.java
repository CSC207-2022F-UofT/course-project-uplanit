package screens.controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


// Frameworks/Drivers layer

public class EventModifierScreen extends JFrame implements ActionListener {

    EventModifierController controller;
    JTextField name = new JTextField(15);
    JTextField startTime = new JTextField(15);
    JTextField endTime = new JTextField(15);
    JTextField commuteTime = new JTextField(15);
    JCheckBox isCommute = new JCheckBox();
    JTextField location = new JTextField(15);

    public EventModifierScreen(EventModifierController controller) {

        this.controller = controller;

        JLabel title = new JLabel("Modify Event (leave the space blank for the info you don't want to edit)");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Enter new name"), name);
        LabelTextPanel startTimeInfo = new LabelTextPanel(
                new JLabel("Enter new start time"), startTime);
        LabelTextPanel endTimeInfo = new LabelTextPanel(
                new JLabel("Enter new end time"), endTime);
        LabelTextPanel commuteTimeInfo = new LabelTextPanel(
                new JLabel("Enter new commute time"), commuteTime);
        LabelTextPanel isCommuteInfo = new LabelTextPanel(
                new JLabel("This event has commute time"), isCommute);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Enter new location"), location);

        JButton modify = new JButton("modify");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(modify);
        buttons.add(cancel);

        modify.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);

        this.add(nameInfo);
        this.add(startTimeInfo);
        this.add(endTimeInfo);
        this.add(commuteTimeInfo);
        this.add(isCommuteInfo);
        this.add(locationInfo);

        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        String formattedName = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDateTime formattedStartTime = null;
        LocalDateTime formattedEndTime = null;

        int formattedCommuteTime = -1;

        String formattedLocation = "";

        try {
            if (name.getText() != null){
                name.getText();
            }
            if (startTime.getText() != null){
                formattedStartTime = LocalDateTime.parse(startTime.getText(), formatter);
            }
            else if (endTime.getText() != null){
                formattedEndTime = LocalDateTime.parse(startTime.getText(), formatter);
            }
            else if (commuteTime.getText() != null){
                formattedCommuteTime = Integer.parseInt(commuteTime.getText());
            }

            else if (!isCommute.isSelected()){
                // which means that the user wants to make it commute event
                formattedCommuteTime = Integer.parseInt(commuteTime.getText());
            }
            else if(!isCommute.isSelected()){
                // which means that the user wants to make it non-commute event
                formattedCommuteTime = 0;
            }
            else if (location.getText() != null){
               formattedLocation = location.getText();
            }

            controller.create(formattedName,formattedStartTime, formattedEndTime,
                    formattedCommuteTime, isCommute.isSelected(), formattedLocation);
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
