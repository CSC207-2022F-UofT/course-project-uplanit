package screens.controllers;

public class EventModificationFailed extends RuntimeException{

    public EventModificationFailed(String error){
        super(error);
    }
}
