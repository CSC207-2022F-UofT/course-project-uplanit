package screens.controllers;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import use_cases.add_dynamic_event_use_case.AddDynamicEventDsRequestModel;
import use_cases.modify_event_use_case.EventModifierDsGateway;
import use_cases.modify_event_use_case.EventModifierRequestModel;
import use_cases.modify_event_use_case.EventModifierDsRequestModel;


public class FileEventModifier implements EventModifierDsGateway {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();


    private final Map<String, EventModifierDsRequestModel> events = new HashMap<>();

    private String originalName;
    private LocalDateTime originalStartTime;
    private LocalDateTime originalEndTime;
    private int originalCommuteTime;
    private boolean originalIsCommute;
    private String originalLocation;


    public FileEventModifier(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("name", 0);
        headers.put("start_time", 1);
        headers.put("end_time", 2);
        headers.put("is_commute", 3);
        headers.put("commute", 4);
        headers.put("location", 5);
        headers.put("event_type", 6);

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header


        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");


            String startTimeString = String.valueOf(col[headers.get("start_time")]);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
            LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);

            String name = String.valueOf(col[headers.get("name")]);

            String endTimeString = String.valueOf(col[headers.get("end_time")]);
            LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);

            int commuteTime =  headers.get("commute");

            boolean isCommute = Boolean.parseBoolean(col[headers.get("is_commute")]);

            String location =  String.valueOf(col[headers.get("location")]);

            EventModifierDsRequestModel event = new EventModifierDsRequestModel(name, startTime, endTime,
                        commuteTime, isCommute, location);

            events.put(startTimeString, event);

                /*
                this.originalName = name;
                this.originalStartTime = startTime;
                this.originalEndTime = endTime;
                this.originalCommuteTime = commuteTime;
                this.originalIsCommute = isCommute;
                this.originalLocation = location;
                 */

                reader.close();
                }
            }

    /**
     * Add requestModel to storage.
     * @param reqModel the event information to save.
     */
    @Override
    public void save(EventModifierDsRequestModel reqModel) {

        String id = reqModel.getStartTime().toString();
        events.put(id, reqModel);
        this.Save();
    }

    private void Save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");


            for (EventModifierDsRequestModel event : events.values()) {
                String formattedStartTime= event.getStartTime().format(dateTimeFormatter);
                String formattedEndTime = event.getEndTime().format(dateTimeFormatter);

                String line = String.format("%s,%s,%s,%s,%s,%s",
                        event.getName(), formattedStartTime, formattedEndTime, event.getCommute(),
                        event.getIsCommute(), event.getLocation());

                writer.write(line);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasConflict(EventModifierRequestModel newEvent){
        for (EventModifierDsRequestModel e: events.values()){
            if (newEvent.getStartTime().isBefore(e.getEndTime()) &&
                    newEvent.getEndTime().isAfter(e.getStartTime())){
                return true;
            }
        }
        return false;
    }
}
