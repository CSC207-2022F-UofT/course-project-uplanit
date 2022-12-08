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
        this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Your Weekly Schedule");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        JPanel schedule = new JPanel(new GridLayout());

        int[] lst = {4, 3, 2, 4, 5, 6, 2};
        for (int i:lst) {
            DayDisplay day = new DayDisplay(i);
            schedule.add(day);
        }

        this.add(schedule);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
