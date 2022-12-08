package screens;

import use_cases.add_single_event_use_case.AddSingleEventDsGateway;
import use_cases.add_single_event_use_case.AddSingleEventDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileAddEvent implements AddSingleEventDsGateway {
    private final File csv;
    private final HashMap<String, Integer> titles = new HashMap<>();
    private final HashMap<LocalDateTime, AddSingleEventDsRequestModel> events = new HashMap<>();

    public FileAddEvent(String path) throws IOException {
        csv = new File(path);

        titles.put("name", 0);
        titles.put("startTime", 1);
        titles.put("endTime", 2);
        titles.put("isCommute", 3);
        titles.put("commuteTime", 4);
        titles.put("location", 5);
        titles.put("eventType", 6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        if (csv.length() == 0) {
            save();
        } else {
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
                AddSingleEventDsRequestModel event = new AddSingleEventDsRequestModel(name, startTime, endTime, isCommute, commuteTime, location, eventType);
                events.put(startTime, event);
            }
            reader.close();
        }
    }

    @Override
    public void save(AddSingleEventDsRequestModel requestModel) {
        events.put(requestModel.getStartTime(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csv));
            writer.write(String.join(",", titles.keySet()));
            writer.newLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

            for (AddSingleEventDsRequestModel event : events.values()) {
                String fStart = event.getStartTime().format(formatter);
                String fEnd = event.getEndTime().format(formatter);
                String fIsCommute = ((Boolean) event.isCommute()).toString();
                String fCommuteTime = ((Integer) event.getCommuteTime()).toString();

                String line = String.format("%s,%s,%s,%s,%s,%s,%s", event.getName(), fStart, fEnd, fIsCommute, fCommuteTime, event.getEventType());
                writer.write(line);
                writer.newLine();

            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkConflict(LocalDateTime start, LocalDateTime end){
        for (AddSingleEventDsRequestModel e: this.events.values()){
            if (start.isBefore(e.getEndTime()) &&
                    end.isAfter(e.getStartTime())){
                return true;
            }
        }
        return false;
    }
}
