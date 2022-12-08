package use_cases.create_dynamic_goal_use_case;

import entities.DynamicGoal;
import screens.FileDynamicGoals;


public class CreateGoalInteractor implements CreateGoalInputBoundary {
    final GatewayWriteToCSV goalGatewayToFile;
    final CreateGoalPresenter goalPresenter;
    final InputDataStructure inputData;

    public CreateGoalInteractor(InputDataStructure inputData, GatewayWriteToCSV gateway, CreateGoalPresenter presenter) {
        this.goalGatewayToFile = gateway;
        this.goalPresenter = presenter;
        this.inputData = inputData;
    }


    @Override
    //let us create a Dynamic Goal entity with the inputData given from user. Then let us:
    // 1) save that entity into an outside data structure (for now a CSV file)
    // 2) return to the user the results of their action
    public OuputDataStructure create(InputDataStructure inputData) {
        //add new dynamic goal to the file Week
        if (goalGatewayToFile.goalExistsByName(inputData.getGoalTitle())) {
            return goalPresenter.prepareFailView("You aready have a goal with this name");
        }

        // THIS IS WHERE THE ENTITIES ARE FINALLY USEFUL!!!

        DynamicGoal newGoal = new DynamicGoal(inputData.getGoalTitle(), inputData.getGoalInMinutes(),
                inputData.getStartDate(), inputData.getEndDate());

        if (newGoal.isValid()) {
            return goalPresenter.prepareSuccessView();
        } else {
            return goalPresenter.prepareFailView("The input is invalid");
        }

    }
}


