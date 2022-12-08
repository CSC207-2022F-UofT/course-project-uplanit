package screens;

import entities.DynamicGoal;
import use_cases.create_dynamic_goal_use_case.GatewayDataStructure;
import use_cases.create_dynamic_goal_use_case.InputDataStructure;
import use_cases.create_dynamic_goal_use_case.GatewayWriteToCSV;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileDynamicGoals implements  GatewayWriteToCSV {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();
    // a Linked hash map is used to bind the titles of the headers in the
    //csv file to their respective column numbers in said csv file, so that it
    // is more intuitive to read from them, and future developers modifying
    //this code (or TAs grading it) have an easier time understanding it.

    private final Map<String, GatewayDataStructure> dynamicGoals = new HashMap<>();

    public FileDynamicGoals(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("Goal name", 0);
        headers.put("Time in minutes", 1);
        headers.put("start date", 2);
        headers.put("end date", 3);
        if (csvFile.length() == 0) {
            Save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // This is to skip the headers when actually reading data
            while ((reader.readLine()) != null) {
                String[] col = reader.readLine().split(",");
                String goalName = String.valueOf(col[headers.get("Goal name")]);
                int duration = Integer.valueOf(col[headers.get("Time in minutes")]);
                // auto unboxing!

                String startDateStr = String.valueOf(col[headers.get("start date")]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
                LocalDate startDate = LocalDate.parse(startDateStr, formatter);
            /* the information about the start and end times of the dynamic goals
            is stored in the CSV file as strings in the dd/MM/yy format, BUT it is saved
            in the GatewayDataStructure as a DateTime object; therefore, it needs to be
            reformated via the formater and parse function
             */

                String endDateStr = String.valueOf(col[headers.get("end date")]);
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
                LocalDate endDate = LocalDate.parse(endDateStr, formatter2);
                GatewayDataStructure dynamicGoal = new GatewayDataStructure(duration, goalName, startDate, endDate);
                dynamicGoals.put(goalName, dynamicGoal);
            }
        }

    }

    @Override
    public void Save(GatewayDataStructure goalsToFile) {
        dynamicGoals.put(goalsToFile.getGoalTitle(), goalsToFile);
        this.Save();
    }

    /**
     * Return whether a dynamic goal already exists with title name.
     * @param name the goal title to check.
     * @return whether a goal exists with with title name.
     */
    @Override
    public boolean goalExistsByName(String name) {
        return dynamicGoals.containsKey(name);
    }

    private void Save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (GatewayDataStructure dynamicGoal : dynamicGoals.values()) {
                String line = String.format("%s,%s,%s,%s",dynamicGoal.getGoalTitle(),
                        dynamicGoal.getGoalInMinutes(), dynamicGoal.getStartDate(),
                        dynamicGoal.getEndDate());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
