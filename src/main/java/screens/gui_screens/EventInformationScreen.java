//Screen that displays the Information about selected event, gives options to modify and delete event.
//Uses a CardLayout as Layout manager.

package screens.gui_screens;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class EventInformationScreen extends JPanel{
    public EventInformationScreen() {
        this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);

        JLabel title = new JLabel("Event Information");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBackground(Color.white);
        title.setForeground(new Color(12, 7, 125));

        JLabel sampleName = new JLabel("Sample name");
        sampleName.setBorder(new EmptyBorder(10, 20, 10, 20));
        JLabel sampleDate = new JLabel("Event date");
        sampleDate.setBorder(new EmptyBorder(10, 20, 10, 20));
        JLabel sampleType = new JLabel("Event Type");
        sampleType.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton modifyButton = new JButton("Modify Event");
        modifyButton.setBackground(new Color(68, 60, 244));
        modifyButton.setBorder(new EmptyBorder(10, 20, 10, 20));
        modifyButton.setForeground(Color.white);

        JLabel emptySpace = new JLabel("");
        emptySpace.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton deleteButton = new JButton("Delete this event");
        deleteButton.setBackground(new Color(68, 60, 244));
        deleteButton.setForeground(Color.white);
        deleteButton.setBorder(new EmptyBorder(10, 20, 10, 20));

        this.add(title);
        this.add(sampleName);
        this.add(sampleDate);
        this.add(sampleType);

        this.add(modifyButton);
        this.add(emptySpace);
        this.add(deleteButton);
    }
}
