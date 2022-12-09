package screens.controllers;

public class AddSingleEventFailed extends RuntimeException{
    public AddSingleEventFailed(String error){
        super(error);
    }
}
