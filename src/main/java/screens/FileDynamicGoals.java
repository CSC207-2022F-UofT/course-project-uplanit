package screens;

import use_cases.create_dynamic_goal_use_case.InputDataStructure;
import use_cases.create_dynamic_goal_use_case.GatewayWriteToCSV;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileDynamicGoals implements  GatewayWriteToCSV{

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();
    // a Linked hash map is used to bind the titles of the headers in the
    //csv file to their respective column numbers in said csv file, so that it
    // is more intuitive to read from them, and future developers modifying
    //this code (or TAs grading it) have an easier time understanding it.


    @Override
    public boolean Save(InputDataStructure newDynamicGoal) {
        return false;
    }
}
