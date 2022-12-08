package screens.gui_screens;

import screens.controllers.RecurrentEventController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventAddButton extends JPanel implements ActionListener {
    public EventAddButton(String name){
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(2, 2, 2, 2),
                new EtchedBorder()));
        JButton button = new JButton(name);
        button.addActionListener(this);
        button.setForeground(Color.white);
        button.setBackground(new Color(68, 60, 244));
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }
}
