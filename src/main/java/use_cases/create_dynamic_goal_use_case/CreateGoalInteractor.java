package use_cases.create_dynamic_goal_use_case;

public class CreateGoalInteractor implements CreateGoalInputBoundary {

    public CreateGoalInteractor(InputDataStructure inputData, GatewayWriteToCSV gateway, CreateGoalPresenter presenter){
        this.goalGatewayToFile = gateway;
        this.goalPresenter = presenter;
        this.inputData = inputData;
    }


    @Override
    //let us create a Dynamic Goal entity with the inputData given from user. Then let us:
    // 1) save that entity into an outside data structure (for now a CSV file)
    // 2) return to the user the results of their action
    public outputDataStructure create(InputDataStructure inputData) {
        Goal = new
    }
}
