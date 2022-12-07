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

public class FileDynamicEvent implements AddDynamicEventDsGateway{

        private final File csvFile;

        private final Map<String, Integer> headers = new LinkedHashMap<>();

        // LinkedHashMap is used to match each column with the headers.

        private final Map<LocalDateTime, AddDynamicEventDsRequestModel> events = new HashMap<>();

        public FileDynamicEvent(String csvPath) throws IOException {
            csvFile = new File(csvPath);

            headers.put("name", 0);
            headers.put("start_time", 1);
            headers.put("end_time", 2);
            headers.put("is_commute", 3);
            headers.put("commute", 4);
            headers.put("location", 5);
            headers.put("event_type", 6);

            if (csvFile.length() == 0) {
                save();
            } else {

                BufferedReader reader = new BufferedReader(new FileReader(csvFile));
                reader.readLine(); // skip header

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String name = String.valueOf(col[headers.get("name")]);

                    String start_time_str = String.valueOf(col[headers.get("start_time")]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

                    LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);

                    String end_time_str = String.valueOf(col[headers.get("end_time")]);
                    LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);

                    // String is_commute_str = String.valueOf(col[headers.get("is_commute")]);
                    // boolean is_commute = !Objects.equals(is_commute_str, "false");

                    String location = String.valueOf(col[headers.get("location")]);

                    // String event_type = String.valueOf(col[headers.get("event_type")]);
                    AddDynamicEventDsRequestModel event = new AddDynamicEventDsRequestModel(name, start_time, end_time,
                            false, null, location);
                    events.put(start_time, event);
                }

                reader.close();
            }
        }

        /**
         * Add requestModel to storage.
         * @param requestModel the user information to save.
         */
        @Override
        public void save(AddDynamicEventDsRequestModel requestModel) {
            events.put(requestModel.getStartTime(), requestModel);
            this.save();
        }

        private void save() {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(csvFile));
                writer.write(String.join(",", headers.keySet()));
                writer.newLine();

                for (AddDynamicEventDsRequestModel event : events.values()) {
                    String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                            event.getName(), event.getStartTime(), event.getEndTime(), event.getIsCommute(),
                            event.getCommute(), event.getLocation(), "D");
                    writer.write(line);
                    writer.newLine();
                }

                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        /**
         * Return whether there is a conflicting event with newEvent to be added to the calendar.
         * @param newEvent the event to check.
         * @return true iff newEvent conflicts with an already existent event.
         */
        @Override
        public boolean checkConflict(AddDynamicEventRequestModel newEvent) {
            for (AddDynamicEventDsRequestModel requestModel : events.values()) {
                if (newEvent.getStartTime().isBefore(requestModel.getEndTime()) &&
                        newEvent.getEndTime().isAfter(requestModel.getStartTime())) {
                    return true;
                }
            }
            return false;
        }

}
