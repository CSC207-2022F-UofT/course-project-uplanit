package screens.controllers;

public class AddDynamicGoalFailed extends RuntimeException{
    //message
    public AddDynamicGoalFailed(String errorMessage){
        super(errorMessage);
    }
}
