package use_cases.display_week_use_case;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class DisplayWeekDsRequestModel {
        private String name;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private boolean isCommute;
        private String location;
        private int commuteTime;

        private String eventType;


        public DisplayWeekDsRequestModel(String name, LocalDateTime startTime, LocalDateTime endTime, boolean isCommute, int commute, String location, String type){

                this.name = name;
                this.startTime = startTime;
                this.endTime = endTime;
                this.commuteTime = commute;
                this.location = location;
                this.isCommute = isCommute;
                this.eventType = type;
        }
        public String getName() {
                return this.name;
        }

        public int getCommuteTime() {
                return this.commuteTime;
        }
        public LocalDateTime getStartTime() {
                return startTime;
        }
        public LocalDateTime getEndTime() {
                return endTime;
        }
        public String getLocation() {
                return location;
        }
        public boolean isCommute(){
                return this.isCommute;
        }
        public String getEventType(){
                return this.eventType;
        }
        public ArrayList<String> toStringList(){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
                String fStart = this.getStartTime().format(formatter);
                String fEnd = this.getEndTime().format(formatter);
                String fIsCommute = ((Boolean) this.isCommute()).toString();
                String fCommuteTime = ((Integer) this.getCommuteTime()).toString();

                ArrayList<String> result = new ArrayList<>(Arrays.asList(this.getName(), fStart, fEnd, fIsCommute, fCommuteTime, this.getLocation(), this.getEventType()));
                return result;
        }
}
