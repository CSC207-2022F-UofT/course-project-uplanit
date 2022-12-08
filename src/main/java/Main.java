import javax.swing.*;
import java.awt.*;

public class Main {

    // The purpose of this file (by convention) is to instantiate the ui when the program is run.
    // the additional screens that need to be displayed in accordance with use of the GUI will be created as
    // separate files (one per view) in the screens package.
    public static void main(String[] args) {

        //building the main program window GUI (will hold all screen components)
        JFrame application = new JFrame("UPLANIT - Schedule Management");

        // what action is taken when the screen closes. This is very important for other shifted
        // screens (using separate layout managers) so that when you close one screen, the main
        // program doesn't close
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setSize sets the size of the screen and setDefaultCloseOperation defines
        application.setSize(850,675);

//        //adds uplanit
//        JLabel label = new JLabel("UPLANNIT");
//        label.setBounds(350, 10, 90, 180);
//
//        //adds button
//        JButton button = new JButton("LETS GOOOOOOOOOOOOOOOO");
//
//        //creates a panel to show button and label
//        JPanel pnl = new JPanel();
//        pnl.add(label);
//        pnl.add(button);
//        pnl.setBorder(BorderFactory.createEmptyBorder(,10,10,10));
//
//        application.add(pnl);
        application.setVisible(true);
    }
}
