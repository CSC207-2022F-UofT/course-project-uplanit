package screens;

import use_cases.dynamic_goal_statistics_use_case.DynamicGoalStatsDsRequestModel;
import use_cases.dynamic_goal_statistics_use_case.DynamicGoalStatsDsGateway;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileGoalStats implements DynamicGoalStatsDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, DynamicGoalStatsDsRequestModel> goals = new HashMap<>();

    public FileGoalStats(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("goal", 0);
        headers.put("timeSpent", 1);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));

            reader.readLine(); // skips the header

            String row;

            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String goal = String.valueOf(col[headers.get("goal")]);

                String timeSpent = String.valueOf(col[headers.get("totalTimeSpent")]);

                DynamicGoalStatsDsRequestModel goalStats = new DynamicGoalStatsDsRequestModel(goal, timeSpent);
                goals.put(goal, goalStats);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(DynamicGoalStatsDsRequestModel requestModel) {
        goals.put(requestModel.getGoalName(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (DynamicGoalStatsDsRequestModel goalStats : goals.values()) {
                String line = String.format("%s,%s", goalStats.getGoalName(), goalStats.getTimeSpent());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}