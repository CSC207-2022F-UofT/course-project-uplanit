package screens.controllers;
import javax.swing.*;

public class LabelTextPanel extends JPanel {

// Frameworks/Drivers layer
        public LabelTextPanel(JLabel label, JTextField textField) {
            this.add(label);
            this.add(textField);
        }

        public LabelTextPanel(JLabel label, JCheckBox checkbox){
            this.add(label);
            this.add(checkbox);
        }
}
