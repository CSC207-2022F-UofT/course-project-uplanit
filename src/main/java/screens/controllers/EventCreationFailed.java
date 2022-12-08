package screens.controllers;

public class EventCreationFailed extends RuntimeException {

    public EventCreationFailed(String error) {
        super(error);
    }
}
