package screens.controllers;

import use_cases.dynamic_goal_statistics_use_case.DynEventDsRequestModel;
import use_cases.dynamic_goal_statistics_use_case.DynamicGoalStatsDsGateway;
import use_cases.dynamic_goal_statistics_use_case.DynGoalDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileGoalStats implements DynamicGoalStatsDsGateway {

    private final File csvGoalsFile;
    private final File csvDynEventFile;

    private final Map<String, Integer> headersGoals = new LinkedHashMap<>();
    private final Map<String, Integer> headersDynEvents = new LinkedHashMap<>();

    private final Map<String, DynEventDsRequestModel> eventsMap = new HashMap<>();
    private final Map<String, DynGoalDsRequestModel> goalsMap = new HashMap<>();

    public FileGoalStats(String csvGoalsPath, String csvDynamicPath) throws IOException {

        // files
        csvGoalsFile = new File(csvGoalsPath);
        csvDynEventFile = new File(csvDynamicPath);

        // headers
        headersGoals.put("Goal name", 0);
        headersGoals.put("Time in minutes", 1);
        headersGoals.put("start date", 2);
        headersGoals.put("end date", 3);

        headersDynEvents.put("name", 0);
        headersDynEvents.put("start_time", 1);
        headersDynEvents.put("end_time", 2);
        headersDynEvents.put("is_commute", 3);
        headersDynEvents.put("commute", 4);
        headersDynEvents.put("location", 5);
        headersDynEvents.put("event_type", 6);

        if (csvGoalsFile.length() == 0) {}

        BufferedReader reader1 = new BufferedReader(new FileReader(csvDynEventFile));
        reader1.readLine(); // skips the header

            // Reads dynamic event csv file
            String row1;
            while ((row1 = reader1.readLine()) != null) {
                String[] col1 = row1.split(",");
                String name = String.valueOf(col1[headersDynEvents.get("name")]);

                String start_time_str = String.valueOf(col1[headersDynEvents.get("start_time")]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

                LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);

                String end_time_str = String.valueOf(col1[headersDynEvents.get("end_time")]);
                LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);

                DynEventDsRequestModel events = new DynEventDsRequestModel(name, start_time, end_time);
                eventsMap.put(name, events);
            }
            reader1.close();

            BufferedReader reader2 = new BufferedReader(new FileReader(csvGoalsFile));
            reader2.readLine(); // skips the header

            // Reads dynamic goal csv file
            String row2;
            while ((row2 = reader2.readLine()) != null) {
                String[] col = reader2.readLine().split(",");
                String goalName = String.valueOf(col[headersGoals.get("Goal name")]);
                int duration = Integer.parseInt(col[headersGoals.get("Time in minutes")]);

                DynGoalDsRequestModel goals = new DynGoalDsRequestModel(goalName, duration);
                goalsMap.put(goalName, goals);

            }
            reader2.close();
        }

        public Map getGoalsMap(){
        return this.goalsMap;
        }

    public Map getEventsMap(){
        return this.eventsMap;
    }

    }