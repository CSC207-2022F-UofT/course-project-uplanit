import entities.EventFactory;
import entities.RecurrentEventFactory;
import entities.SingleEventFactory;
import screens.controllers.*;
import screens.gui_screens.*;
import use_cases.add_single_event_use_case.AddSingleEventDsGateway;
import use_cases.add_single_event_use_case.AddSingleEventInputBoundary;
import use_cases.add_single_event_use_case.AddSingleEventInteractor;
import use_cases.add_single_event_use_case.AddSingleEventPresenter;
import use_cases.display_week_use_case.DisplayWeekDsGateway;
import use_cases.recurrent_event_use_case.RecurrentEventDsGateway;
import use_cases.recurrent_event_use_case.RecurrentEventInputBoundary;
import use_cases.recurrent_event_use_case.RecurrentEventInteractor;
import use_cases.recurrent_event_use_case.RecurrentEventPresenter;

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

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("img/logo.png"));
        logo.setVisible(true);
        logo.setBounds(200, 25, 100, 100);


        heading.add(logo);
        heading.add(appTitle);
        heading.setVisible(true);

        //============================================================================
        // Setting up parts to plug into the Use Case+Entities engine
        //============================================================================
        RecurrentEventDsGateway recurrentEvent;
        try {
            recurrentEvent = new FileRecurrentEvent("./events.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could Not Create File");
        }

        RecurrentEventPresenter recurrentEventPresenter = new RecurrentEventResponseFormatter();
        RecurrentEventFactory recurrentEventFactory = new RecurrentEventFactory();
        RecurrentEventInputBoundary recurrentEventInteractor = new RecurrentEventInteractor(recurrentEvent,
                recurrentEventPresenter, recurrentEventFactory);
        RecurrentEventController recurrentEventController = new RecurrentEventController(recurrentEventInteractor);

        AddSingleEventDsGateway singleEvent;
        try {
            singleEvent = new FileAddEvent("./events.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could Not Create File");
        }
//        //for single event
        AddSingleEventPresenter singleEventPresenter = new AddSingleEventResponseFormatter();
        SingleEventFactory singleEventFactory = new SingleEventFactory();
        AddSingleEventInputBoundary singleEventInteractor = new AddSingleEventInteractor(singleEvent,
                singleEventPresenter, singleEventFactory);
        AddSingleEventController singleEventController = new AddSingleEventController(singleEventInteractor);


//        //for displaying week
//        DisplayWeekController displayWeekController;
//        DisplayWeekDsGateway week;


        //============================================================================
        // Week Grid display
        //============================================================================
        JPanel weekDisplay = new WeekDisplayScreen();
        weekDisplay.setBackground(Color.white);
        weekDisplay.setBounds(10, 30, 600, 500);


        //===========================================================================
        //Event display (if selected an event from week)
        //===========================================================================
        EventInformationScreen eventInfo = new EventInformationScreen();
        eventInfo.setBounds(620, 200, 250, 400);

        //===========================================================================
        //Event ADD Buttons
        //==========================================================================

        //for recurrent events
        JPanel recurrentScreen = new RecurrentEventAddScreen(recurrentEventController);
        recurrentScreen.setBounds(620, 30, 300, 200);

        JPanel singleEventScreen = new SingleEventAddScreen(singleEventController);
        singleEventScreen.setBounds(620, 245, 300, 200);

        //Adding all panels to the frame.
        application.getContentPane().add(recurrentScreen);
        application.getContentPane().add(singleEventScreen);
        application.getContentPane().add(weekDisplay);
        application.getContentPane().add(heading);
        application.setVisible(true);
    }
}



//THE FOLLOWING JPANEL SCREEN WAS REMOVED IN FAVOR OF ADDING THE EVENT INPUTS IN THE MAIN APPLICATIONJFRAME
//        EventsAddScreen addEvents = new EventsAddScreen(recurrentEventController);
//        addEvents.setBackground(Color.white);
//        addEvents.setBounds(620, 30, 250, 150);
