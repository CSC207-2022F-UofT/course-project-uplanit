import screens.gui_screens.WeekDisplayScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    // The purpose of this file (by convention) is to instantiate the ui when the program is run.
    // the additional screens that need to be displayed in accordance with use of the GUI will be created as
    // separate files (one per view) in the screens package.
    public static void main(String[] args) throws IOException {
        //=========================================================================
        //building the main program window GUI (will hold all screen components)
        //=========================================================================
        JFrame application = new JFrame("UPLANIT - Schedule Management");

        // what action is taken when the screen closes. This is very important for other shifted
        // screens (using separate layout managers) so that when you close one screen, the main
        // program doesn't close
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setSize sets the size of the screen and setDefaultCloseOperation defines
        application.setSize(850,675);

        //=============================================================================
        //application heading display.
        //=============================================================================
        JPanel heading = new JPanel(new FlowLayout());
        heading.setLocation(10, 10);
        heading.setBounds(10, 10, 400, 50);

        JLabel appTitle = new JLabel("UPlanIt"); //creating the JLabel that contains the heading.

////        BufferedImage logoPng = ImageIO.read(new File("img/logo.png"));
//        JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
//        logo.setBounds(0, 0, 50, 50);
//
//        heading.add(logo);

        heading.add(appTitle);
        heading.setVisible(true);

        //============================================================================
        // Week Grid display
        //============================================================================
        JPanel weekDisplay = new WeekDisplayScreen();
        weekDisplay.setBounds(10, 30, 600, 500);


        //===========================================================================
        //Event display (if selected an event from week
        //===========================================================================



        application.getContentPane().add(weekDisplay);
        application.getContentPane().add(heading);
        application.setVisible(true);
    }
}
