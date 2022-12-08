package use_cases.create_dynamic_goal_use_case;
// this interface is used as the set of rules for how the use case interactor will communicate with the controller.
//To create a dynamic goal, the uci needs information form the person creating the goal: title and number of minutes.
//This is basically a list of methods that the uci will use to request the name and minutes of the new goal to the controller.
//how will the use case interactor talk to the controller??
public interface CreateGoalInputBoundary {
    //*personalized data type used to pass information without making parameters infinitely long*
    //Create one of those objects with
    OuputDataStructure create(InputDataStructure inputData);

}
