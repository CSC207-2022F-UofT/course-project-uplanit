package screens.gui_screens;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class EventAddButton extends JPanel {
    public EventAddButton(String name){
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new EtchedBorder()));
        JButton button = new JButton(name);
        button.setForeground(Color.white);
        button.setBackground(new Color(68, 60, 244));
        this.add(button);
    }


}
