package screens;

import use_cases.add_dynamic_event_use_case.AddDynamicEventDsRequestModel;
import use_cases.add_dynamic_event_use_case.AddDynamicEventDsGateway;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileDynamicEvent implements AddDynamicEventDsGateway{

        private File csvFile;

        private Map<String, Integer> headers = new LinkedHashMap<>();

        private  Map<String, AddDynamicEventDsRequestModel> accounts = new HashMap<>();

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
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime start_time = LocalDateTime.parse(start_time_str, formatter);
                    String end_time_str = String.valueOf(col[headers.get("end_time")]);
                    LocalDateTime end_time = LocalDateTime.parse(end_time_str, formatter);
                    String is_commute = String.valueOf(col[headers.get("is_commute")]);
                    String commute = String.valueOf(col[headers.get("commute")]);
                    String location = String.valueOf(col[headers.get("location")]);
                    // String event_type = String.valueOf(col[headers.get("event_type")]);
                    AddDynamicEventDsRequestModel user = new AddDynamicEventDsRequestModel(name, start_time, end_time,
                            is_commute, commute, location);
                    accounts.put(username, user);
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

        }

        private void save() {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(csvFile));
                writer.write(String.join(",", headers.keySet()));
                writer.newLine();

                for (AddDynamicEventDsRequestModel user : accounts.values()) {
                    String line = "%s,%s,%s".formatted(
                            user.getName(), user.getPassword(), user.getCreationTime());
                    writer.write(line);
                    writer.newLine();
                }

                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        /**
         * Return whether a user exists with username identifier.
         * @param identifier the username to check.
         * @return whether a user exists with username identifier
         */
        @Override
        public boolean existsByName(String identifier) {
            return accounts.containsKey(identifier);
        }

}
