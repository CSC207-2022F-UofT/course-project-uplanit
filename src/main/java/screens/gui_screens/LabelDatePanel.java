package screens.gui_screens;

import javax.swing.*;

public class LabelDatePanel extends JPanel {
    public LabelDatePanel(JLabel label, JFormattedTextField dateField) {
        this.add(label);
        this.add(dateField);
    }
}

