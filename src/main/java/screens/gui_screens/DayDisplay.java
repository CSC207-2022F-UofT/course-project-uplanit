package screens.gui_screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DayDisplay extends JPanel {

    public DayDisplay(int e) {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createDashedBorder(Color.LIGHT_GRAY));
        //random events created
        for (int i = 0; i <= e; i++) {
            EventDisplay ev = new EventDisplay();
            this.add(ev);
        }

    }
}
