package screens;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import entities.Event;
import use_cases.modify_event_use_case.ModifyEventDsGateway;
import use_cases.modify_event_use_case.ModifyEventDsRequestModel;

public class FileEvents implements ModifyEventDsGateway {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, ModifyEventDsRequestModel> events = new HashMap<>();

    public FileEvents(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("name", 0);
        headers.put("startTime", 1);
        headers.put("endTime", 2);
        headers.put("commuteTime", 0);
        headers.put("isCommute", 0);
        headers.put("location", 0);

        if (csvFile.length() == 0) {
            Save();
        }

        else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");

                String name = String.valueOf(col[headers.get("name")]);
                String startTimeString = String.valueOf(col[headers.get("startTime")]);
                String endTimeString = String.valueOf(col[headers.get("endTime")]);
                int commuteTime =  headers.get("commuteTime");
                boolean isCommute = Boolean.parseBoolean(col[headers.get("isCommute")]);
                String location =  String.valueOf(col[headers.get("location")]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);
                LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);


                ModifyEventDsRequestModel event = new ModifyEventDsRequestModel(name, startTime, endTime, commuteTime,
                        isCommute, location);
                events.put(startTimeString, event);
            }
            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param eventsToFile the event information to save.
     */
    @Override
    public void save(ModifyEventDsRequestModel eventsToFile) {
        events.put(eventsToFile.getName(), eventsToFile);
        this.Save();
    }

    private void Save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (ModifyEventDsRequestModel e : events.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        e.getName(), e.getStartTime(), e.getEndTime(), e.getCommute(),
                        e.getIsCommute(), e.getLocation());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
