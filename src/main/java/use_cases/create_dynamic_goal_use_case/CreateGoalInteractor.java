package use_cases.create_dynamic_goal_use_case;

public class CreateGoalInteractor implements CreateGoalInputBoundary {
    final GatewayWriteToCSV goalGatewayToFile;
    final CreateGoalPresenter goalPresenter;
    final InputDataStructure inputData;

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
        fileWeek.addGoalTime(inputData.getGoalTitle(), inputData.getGoalInMinutes());
        //add new dynamic goal to the file Week
        OuputDataStructure noideawhatthisis= new OuputDataStructure();
        return goalPresenter.prepareSuccessView();
    }
    goalGatewayToFile.save(inputData)

}
