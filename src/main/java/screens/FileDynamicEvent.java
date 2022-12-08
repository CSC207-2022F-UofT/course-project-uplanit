package screens;

import entities.Event;
import use_cases.add_dynamic_event_use_case.AddDynamicEventDsRequestModel;
import use_cases.add_dynamic_event_use_case.AddDynamicEventDsGateway;
import use_cases.add_dynamic_event_use_case.AddDynamicEventRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


// Frameworks and Drivers layer
public class FileDynamicEvent implements AddDynamicEventDsGateway{

        private final File csvFile;

        private final Map<String, Integer> headers = new LinkedHashMap<>();

        // LinkedHashMap is used to match each column with the headers.

        private final Map<LocalDateTime, AddDynamicEventDsRequestModel> events = new HashMap<>();

    /**
     * Construct FileDynamicEvent given the csvPath.
     *
     * @param csvPath the pathway to creating the csv file
     * @throws IOException may throw IOException
     */
    public FileDynamicEvent(String csvPath) throws IOException {

            // Constructor for creating a csv file which will store the dynamic events in comma separated format
            // There are 7 columns with the following headers in order:
            // name,start_time,end_time,is_commute,commute,location,event_type
            csvFile = new File(csvPath);

            // In the headers linkedHashMap, each column title is matched with the order # of that column for
            // readability purposes.
            headers.put("name", 0);
            headers.put("start_time", 1);
            headers.put("end_time", 2);
            headers.put("is_commute", 3);
            headers.put("commute", 4);
            headers.put("location", 5);
            headers.put("event_type", 6);

            // If there is no event in the csv, save the events that has been created in the current run of the program,
            // which are stored in the HashMap that uses unique event start times as keys and dynamic events (formatted
            // as request models) as values.
            if (csvFile.length() == 0) {
                save();

            // If the csv file is not empty, BufferedReader is used to read from the file efficiently and retrieve the
            // already existent events to store them in the events HashMap.
            } else {

                BufferedReader reader = new BufferedReader(new FileReader(csvFile));
                reader.readLine(); // skip header

                String row;

                // while loop is used to read through the file until an empty line, i.e., end of file.
                while ((row = reader.readLine()) != null) {

                    // String.split(",") method is used to return each element in the line separately.
                    String[] col = row.split(",");
                    String name = String.valueOf(col[headers.get("name")]);

                    String start_time_str = String.valueOf(col[headers.get("start_time")]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

                    LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);

                    String end_time_str = String.valueOf(col[headers.get("end_time")]);
                    LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);

                    String location = String.valueOf(col[headers.get("location")]);

                    // By default, is_commute = false, commute = null, and event_type = "D" for dynamic events. There is
                    // no need to read these from the csv file as what to write for these columns is already known.
                    // The information read for the event is stored as type AddDynamicEventDsRequestModel and is added
                    // to the events HashMap.
                    AddDynamicEventDsRequestModel event = new AddDynamicEventDsRequestModel(name, start_time, end_time,
                            false, null, location);
                    events.put(start_time, event);
                }

                // The reader is closed for clean-up.
                reader.close();
            }
        }

        /**
         * Add requestModel to storage.
         * @param requestModel the event information to save.
         */
        @Override
        public void save(AddDynamicEventDsRequestModel requestModel) {
            events.put(requestModel.getStartTime(), requestModel);
            this.save();
        }

    /**
     * Save the dynamic events in events HashMap to the csv file.
     */
    private void save() {

            // BufferedWriter is used for efficiently adding the events to the csv file.
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(csvFile));

                // String.join method is used to return the keys in headers (column titles) in comma separated format.
                writer.write(String.join(",", headers.keySet()));
                writer.newLine();

                // Based on team discussions, we decided to store the start and end times for events in the following
                // format:
                // dd/MM/yy HH:mm
                // For example, if a dynamic event starts at 11:45 AM on July 29, 2023, it will be written in the csv
                // file as: 29/07/23 11:45
                // The DateTimeFormatter object stores this pattern.
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

                // for loop to go through all the dynamic events stored in events HashMap.
                // The values are of type AddDynamicEventDsRequestModel, whose properties can be reached through getters
                // and setters.
                for (AddDynamicEventDsRequestModel event : events.values()) {

                    // The DateTimeFormatter object dateTimeFormatter is used to convert the LocalDateTime (return
                    // type for AddDynamicEventDsRequestModel.getStartTime() method) into String.
                    String formatted_start_time = event.getStartTime().format(dateTimeFormatter);
                    String formatted_end_time = event.getEndTime().format(dateTimeFormatter);

                    // The row for the event is created using the String.format() method.
                    String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                            event.getName(), formatted_start_time, formatted_end_time, event.getIsCommute(),
                            "0", event.getLocation(), "D");
                    writer.write(line);
                    writer.newLine();
                }

                // The writer is closed for clean-up.
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        /**
         * Return whether there is a conflicting event with newEvent to be added to the calendar.
         * @param newEvent the event to check.
         * @return true if and only if newEvent conflicts with an already existent event.
         */
        @Override
        public boolean checkConflict(AddDynamicEventRequestModel newEvent) {

            // for loop is used to iterate through all events (requestModel) in the events HashMap to check for any
            // conflict.
            for (AddDynamicEventDsRequestModel requestModel : events.values()) {

                // There is a conflict if the start time of the newEvent is before the end time of an already
                // existent event AND the end time of the newEvent is after the start time of an already existent
                // event.
                if (newEvent.getStartTime().isBefore(requestModel.getEndTime()) &&
                        newEvent.getEndTime().isAfter(requestModel.getStartTime())) {
                    return true;
                }
            }
            return false;
        }

}
