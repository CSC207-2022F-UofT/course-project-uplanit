package use_cases.delete_event_use_case;

public class InputData {
    private String title;
    private int time;
    public InputData(String title, int timeMinutes){
        this.title = title;
        this.time = timeMinutes;
    }
}
