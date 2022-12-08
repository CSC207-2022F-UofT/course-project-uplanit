import screens.gui_screens.EventInformationScreen;
import screens.gui_screens.EventsAddScreen;
import screens.gui_screens.WeekDisplayScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main {


    // The purpose of this file (by convention) is to instantiate the ui when the program is run.
    // the additional screens that need to be displayed in accordance with use of the GUI will be created as
    // separate files (one per view) in the screens package.
    public static void main(String[] args) throws IOException {
        //=========================================================================
        //building the main program window GUI (will hold all screen components)
        //=========================================================================
        JFrame application = new JFrame("UPLANIT - Schedule Management");
        application.setBackground(Color.white);
        //use a cardlayout to switch between  this screen and the add events screen


        // what action is taken when the screen closes. This is very important for other shifted
        // screens (using separate layout managers) so that when you close one screen, the main
        // program doesn't close
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setSize sets the size of the screen and setDefaultCloseOperation defines
        application.setSize(950,675);

        //=============================================================================
        //application heading display.
        //=============================================================================
        JPanel heading = new JPanel(new FlowLayout());
        heading.setBackground(Color.white);
        heading.setLocation(10, 10);
        heading.setBounds(10, 10, 400, 150);

        JLabel appTitle = new JLabel("UPlanIt"); //creating the JLabel that contains the heading.
        appTitle.setForeground(new Color(12, 7, 125));

//        JLabel logo = new JLabel();
//        logo.setIcon(new ImageIcon());
//        logo.setVisible(true);
//        logo.setBounds(200, 25, 100, 100);
//
//
//        heading.add(logo);
        heading.add(appTitle);
        heading.setVisible(true);

        //============================================================================
        // Week Grid display
        //============================================================================
        JPanel weekDisplay = new WeekDisplayScreen();
        weekDisplay.setBackground(Color.white);
        weekDisplay.setBounds(10, 30, 600, 500);


        //===========================================================================
        //Event display (if selected an event from week
        //===========================================================================
        EventInformationScreen eventInfo = new EventInformationScreen();
        eventInfo.setBounds(620, 200, 250, 400);

        //===========================================================================
        //ADD Buttons
        //==========================================================================
        EventsAddScreen addEvents = new EventsAddScreen();
        addEvents.setBackground(Color.white);
        addEvents.setBounds(620, 30, 250, 150);





        application.getContentPane().add(addEvents);
        application.getContentPane().add(eventInfo);
        application.getContentPane().add(weekDisplay);
        application.getContentPane().add(heading);
        application.setVisible(true);
    }
}
