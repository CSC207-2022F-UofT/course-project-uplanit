package screens;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import use_cases.modify_event_use_case.EventModifierDsGateway;
import use_cases.modify_event_use_case.EventModifierRequestModel;
import use_cases.modify_event_use_case.EventModifierDsRequestModel;


public class FileEventModifier implements EventModifierDsGateway {
    private final File csvFile;

    private final Map<String, Integer> headers;


    private final Map<String, EventModifierDsRequestModel> events = new HashMap<>();

    private String originalName;
    private LocalDateTime originalStartTime;
    private LocalDateTime originalEndTime;
    private int originalCommuteTime;
    private boolean originalIsCommute;
    private String originalLocation;


    public FileEventModifier(String csvPath, Map<String, Integer> headers,
                             LocalDateTime startTimeIdentifier) throws IOException {
        csvFile = new File(csvPath);
        this.headers = headers;
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


            // if it matches the event that user wants to modify, stop the reader?
            if (startTime == startTimeIdentifier){
                String name = String.valueOf(col[headers.get("name")]);

                String endTimeString = String.valueOf(col[headers.get("end_time")]);
                LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);

                int commuteTime =  headers.get("commute");

                boolean isCommute = Boolean.parseBoolean(col[headers.get("is_commute")]);

                String location =  String.valueOf(col[headers.get("location")]);

                this.originalName = name;
                this.originalStartTime = startTime;
                this.originalEndTime = endTime;
                this.originalCommuteTime = commuteTime;
                this.originalIsCommute = isCommute;
                this.originalLocation = location;

                reader.close();
                }
            }
        }

    /**
     * Add requestModel to storage.
     * @param reqModel the event information to save.
     */
    @Override
    public void save(EventModifierDsRequestModel reqModel) {

        checkChangedInfo(reqModel);

        String id = reqModel.getStartTime().toString();
        events.put(id, reqModel);
        this.Save();
    }

    private void Save() {
        BufferedWriter writer;
        try {
            String line = "";
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");


            for (EventModifierDsRequestModel event : events.values()) {
                String formattedStartTime= event.getStartTime().format(dateTimeFormatter);
                String formattedEndTime = event.getEndTime().format(dateTimeFormatter);

                line = String.format("%s,%s,%s,%s,%s,%s",
                        event.getName(), formattedStartTime, formattedEndTime, event.getCommute(),
                        event.getIsCommute(), event.getLocation());
            }

            // overwrite the corresponding line
            writer.write(line);

            writer.newLine();
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

    public void checkChangedInfo (EventModifierDsRequestModel reqModel){
        boolean n = false;
        boolean s = false;
        boolean e = false;
        boolean cTime = false;
        boolean isC = false;
        boolean l = false;

        if (!reqModel.getName().equals("")){
            n = true;
        }

        if (reqModel.getStartTime() != null){
            s = true;
        }
        if (reqModel.getEndTime() != null){
            e = true;
        }
        if (reqModel.getCommute() != -1){
            cTime = true;
        }

        if (reqModel.getIsCommute() != originalIsCommute){
            isC = true;
        }

        if (!reqModel.getLocation().equals("")){
            l = true;
        }



        if (!n){
            reqModel.setName(originalName);
        }

        if (!s){
            reqModel.setStartTime(originalStartTime);
        }

        if (!e){
            reqModel.setEndTime(originalEndTime);
        }

        if (!cTime){
            reqModel.setCommuteTime(originalCommuteTime);
        }

        if (!isC){
            reqModel.setIsCommute(originalIsCommute);
        }

        if (!l){
            reqModel.setLocation(originalLocation);
        }
    }
}
