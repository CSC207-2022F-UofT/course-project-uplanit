package screens.gui_screens;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecurrentEventAddScreen extends JPanel implements ActionListener {



    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
//            userRegisterController.create(username.getText(),
//                    String.valueOf(password.getPassword()),
//                    String.valueOf(repeatPassword.getPassword()));
//            JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
