//Screen that displays the events in a week. It uses GridLayout as Layout Manager

package screens.gui_screens;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WeekDisplayScreen extends JPanel implements ActionListener {

    public WeekDisplayScreen() {
        this.setLayout(new GridLayout());
        int[] lst = {4, 3, 2, 4, 5, 6, 2};
        for (int i:lst) {
            DayDisplay day = new DayDisplay(i);
            this.add(day);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
