package screens.controllers;

public class DisplayWeekFailed extends RuntimeException{
    public DisplayWeekFailed(String error){
        super(error);
    }
}
