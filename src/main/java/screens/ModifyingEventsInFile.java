package screens;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import use_cases.modify_event_use_case.ModifyEventDsGateway;
import use_cases.modify_event_use_case.ModifyEventRequestModel;
import use_cases.modify_event_use_case.ModifyEventDsRequestModel;
import use_cases.modify_event_use_case.ModifyEventResponseModel;


public class ModifyingEventsInFile implements ModifyEventDsGateway {
    private final File csvFile;

    private final Map<String, Integer> headers;


    private final Map<String, ModifyEventDsRequestModel> events = new HashMap<>();

    public ModifyingEventsInFile(String csvPath, Map<String, Integer> headers,
                                 LocalDateTime startTimeIdentifier) throws IOException {
        csvFile = new File(csvPath);
        this.headers = headers;


        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");


            String startTimeString = String.valueOf(col[headers.get("startTime")]);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
            LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);


            // if it matches the event that user wants to modify stop the reader?
            if (startTime == startTimeIdentifier){
                String name = String.valueOf(col[headers.get("name")]);

                String endTimeString = String.valueOf(col[headers.get("endTime")]);
                LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);

                int commuteTime =  headers.get("commuteTime");

                boolean isCommute = Boolean.parseBoolean(col[headers.get("isCommute")]);

                String location =  String.valueOf(col[headers.get("location")]);

                ModifyEventDsRequestModel event = new ModifyEventDsRequestModel(name, startTime, endTime, commuteTime,
                        isCommute, location);

                events.put(startTimeString, event);
                reader.close();
                }
            }
        }

    /**
     * Add requestModel to storage.
     * @param reqModel the event information to save.
     */
    @Override
    public void save(ModifyEventDsRequestModel reqModel) {

        // what I'm trying to do here:
        // Since the [info user DOE NOT want to modify] is set to irrelevant values (see screen class), I want to only use the modifed info
        // in other words, in the csv file, I don't want to edit anything for non-modified info and only overwrite the modified info.

        // i have no fucking clue if im doing this entire usecase correctly kill me

        if (!reqModel.getName().equals("")){

        }

        if (reqModel.getStartTime() != null){

        }
        if (reqModel.getEndTime() != null){

        }
        if (reqModel.getCommute() != -1){

        }

        if (!reqModel.getLocation().equals("")){

        }

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

    @Override
    public boolean hasConflict(ModifyEventRequestModel newEvent){
        for (ModifyEventDsRequestModel e: events.values()){
            if (newEvent.getStartTime().isBefore(e.getEndTime()) &&
                    newEvent.getEndTime().isAfter(e.getStartTime())){
                return true;
            }
        }
        return false;
    }
}
