package screens;

import use_cases.display_week_use_case.DisplayWeekDsGateway;
import use_cases.display_week_use_case.DisplayWeekDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileDisplayWeek implements DisplayWeekDsGateway {
    private final File csv;
    private final HashMap<String, Integer> titles = new HashMap<>();
    private final Map<LocalDateTime, DisplayWeekDsRequestModel> events = new HashMap<>();

    public FileDisplayWeek(String path) throws IOException {
        csv = new File(path);

        titles.put("name", 0);
        titles.put("startTime", 1);
        titles.put("endTime", 2);
        titles.put("isCommute", 3);
        titles.put("commuteTime", 4);
        titles.put("location", 5);
        titles.put("eventType", 6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        if (!(csv.length() == 0)) {
            BufferedReader reader = new BufferedReader(new FileReader(csv));
            reader.readLine(); // skip header

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[titles.get("name")];
                LocalDateTime startTime = LocalDateTime.parse(values[titles.get("startTime")], formatter);
                LocalDateTime endTime = LocalDateTime.parse(values[titles.get("endTime")], formatter);
                boolean isCommute = Boolean.parseBoolean(values[titles.get("name")]);
                int commuteTime = Integer.parseInt(values[titles.get("commuteTime")]);
                String location = values[titles.get("location")];
                String eventType = values[titles.get("eventType")];
                DisplayWeekDsRequestModel event = new DisplayWeekDsRequestModel(name, startTime, endTime, isCommute, commuteTime, location, eventType);
                events.put(startTime, event);
            }
            reader.close();
        }
    }


    @Override
    public HashMap<LocalDateTime, DisplayWeekDsRequestModel> eventMap(){
        return this.eventMap();
    }



}
