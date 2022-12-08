package use_cases.create_dynamic_goal_use_case;

import entities.DynamicEvent;

public interface GatewayWriteToCSV {
    //translates from Dynamic Event format to CSV-able format and transcribes to CSV file; implemented by FileCalendar
    void Save(GatewayDataStructure goalsToFile);
    boolean goalExistsByName(String name);
}
