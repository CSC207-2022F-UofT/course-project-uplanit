package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Frameworks/Drivers layer

public class ModifyEventScreen extends JFrame implements ActionListener {

    ModifyEventController controller;

    public ModifyEventScreen(ModifyEventController controller) {

        this.controller = controller;

        JLabel title = new JLabel("Modify Event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton modify = new JButton("modify");

        JPanel buttons = new JPanel();
        buttons.add(modify);

        modify.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        // show options (which info to modify)
    }
}
