package use_cases.dynamic_goal_statistics_use_case;

import entities.Week;

public class DynamicGoalStatsInteractor implements DynamicGoalStatsInputBoundary{

    final DynamicGoalStatsDsGateway goalStatsDsGateway;
    final DynamicGoalStatsPresenter goalStatsPresenter;

    public UserRegisterInteractor(DynamicGoalStatsDsGateway goalStatsDfGateway,
                                  DynamicGoalStatsPresenter userRegisterPresenter) {
        this.userDsGateway = userRegisterDfGateway;
        this.userPresenter = userRegisterPresenter;

    }

    @Override
    public DynamicGoalStatsResponseModel create(DynamicGoalStatsRequestModel requestModel) {
        if (DynamicGoalStatsDsGateway.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("User already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
            return userPresenter.prepareFailView("Passwords don't match.");
        }
}