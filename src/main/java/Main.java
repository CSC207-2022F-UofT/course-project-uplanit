import javax.swing.*;
import java.awt.*;

public class Main {

    // The purpose of this file (by convention) is to instantiate the ui when the program is run.
    // the additional screens that need to be displayed in accordance with use of the GUI will be created as
    // separate files (one per view) in the screens package.
    public static void main(String[] args) {

        //building the main program window
        JFrame application = new JFrame("UPLANIT");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(750,650);

        //adds uplanit
        JLabel label = new JLabel("UPLANNIT");
        label.setBounds(90, 120, 90, 180);

        //adds button
        JButton button = new JButton("LETS GOOOOOOOOOOOOOOOO");

        //creates a panel to show button and label
        JPanel pnl = new JPanel();
        pnl.add(label);
        pnl.add(button);
        pnl.setBorder(BorderFactory.createEmptyBorder(90,10,10,10));

        frame.add(pnl);
        frame.setVisible(true);
    }
}
