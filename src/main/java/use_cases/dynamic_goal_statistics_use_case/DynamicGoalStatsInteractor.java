package use_cases.dynamic_goal_statistics_use_case;

public class DynamicGoalStatsInteractor implements DynamicGoalStatsInputBoundary{

    final DynamicGoalStatsDsGateway goalStatsDsGateway;
    final DynamicGoalStatsPresenter goalStatsPresenter;

    public DynamicGoalStatsInteractor(DynamicGoalStatsDsGateway goalStatsDfGateway,
                                  DynamicGoalStatsPresenter goalStatsPresenter) {
        this.goalStatsDsGateway = goalStatsDfGateway;
        this.goalStatsPresenter = goalStatsPresenter;

    }

    @Override
    public DynamicGoalStatsResponseModel create(DynamicGoalStatsRequestModel requestModel) {
        String goal = requestModel.getGoalName();

        DynamicGoalStatsDsRequestModel statsDsModel = new DynamicGoalStatsDsRequestModel(goal);
        goalStatsDsGateway.save(statsDsModel);

        // need to access csv file
        DynamicGoalStatsResponseModel goalResponseModel = new DynamicGoalStatsResponseModel(goal);

        //check
        return goalResponseModel;

        //return DynamicGoalStatsPresenter
                //.prepareSuccessView(goalResponseModel);
    }
}