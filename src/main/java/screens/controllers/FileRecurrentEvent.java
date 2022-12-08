package screens.controllers;

import use_cases.recurrent_event_use_case.RecurrentEventDsGateway;
import use_cases.recurrent_event_use_case.RecurrentEventDsRequestModel;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class FileRecurrentEvent implements RecurrentEventDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<LocalDateTime, RecurrentEventDsRequestModel> events = new HashMap<>();


    public FileRecurrentEvent(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("name", 0);
        headers.put("startTime", 1);
        headers.put("endTime", 2);
        headers.put("isCommute", 3);
        headers.put("commute", 4);
        headers.put("location", 5);
        headers.put("eventType", 6);

        if (csvFile.length() == 0) {
            save();
        }
        else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();  // skip header

            String row;

            while ((row = reader.readLine()) != null) {

                String[] col = row.split(",");
                String name = String.valueOf(col[headers.get("name")]);
                String stringStart = String.valueOf(col[headers.get("startTime")]);
                String stringEnd = String.valueOf(col[headers.get("endTime")]);
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
                LocalDateTime startTime = LocalDateTime.parse(stringStart, formatter2);
                LocalDateTime endTime = LocalDateTime.parse(stringEnd, formatter2);
                String isCommute = String.valueOf(col[headers.get("isCommute")]);
                String stringCommute = String.valueOf(col[headers.get("commute")]);
                int commute = Integer.parseInt(stringCommute);
                String location = String.valueOf(col[headers.get("location")]);
                String eventType = String.valueOf(col[headers.get("eventType")]);

                RecurrentEventDsRequestModel event = new RecurrentEventDsRequestModel(name, startTime, endTime,
                        Boolean.parseBoolean(isCommute), commute, location, eventType);

                events.put(startTime, event);
            }

            reader.close();
        }
    }


    /**
     * Add created request model to storage
     * @param requestModel the event information to save.
     */
    @Override
    public void save(RecurrentEventDsRequestModel requestModel) {
        events.put(requestModel.getStartTime(), requestModel);
        this.save();
    }


    private void save() {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

            for (RecurrentEventDsRequestModel event : events.values()) {
                String formattedStart = event.getStartTime().format(formatter);
                String formattedEnd = event.getEndTime().format(formatter);
                String formattedIs = ((Boolean) event.getIsCommute()).toString();
                String formattedCom = ((Integer) event.getCommuteTime()).toString();

                String line = String.format("%s,%s,%s,%s,%s,%s,%s", event.getName(), formattedStart, formattedEnd,
                        formattedIs, formattedCom, event.getLocation(), event.getEventType());
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return whether this event conflicts with another
     * @param startTime the start time to check.
     * @param endTime the end time to check.
     */
    @Override
    public boolean hasConflict(LocalDateTime startTime, LocalDateTime endTime) {

        if (events.containsKey(startTime)) {
            return false;
        }
        for (LocalDateTime start : events.keySet()) {
            LocalDateTime end = events.get(start).getEndTime();

            if (!(startTime.isBefore(start) & endTime.isBefore(start)) |
            !(startTime.isAfter(end) & endTime.isAfter(end))) {
                return false;
            }
        }
        return true;
    }
}
