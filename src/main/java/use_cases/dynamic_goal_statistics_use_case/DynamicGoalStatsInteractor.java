package use_cases.dynamic_goal_statistics_use_case;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DynamicGoalStatsInteractor implements DynamicGoalStatsInputBoundary{

    final DynGoalDsRequestModel goalsDsGateway;
    final DynEventDsRequestModel eventDsGateway;

    final DynamicGoalStatsPresenter goalStatsPresenter;

    public DynamicGoalStatsInteractor(DynGoalDsRequestModel goalDfGateway,
                                  DynEventDsRequestModel eventDfGateway,
                                  DynamicGoalStatsPresenter goalStatsPresenter) {
        this.goalsDsGateway = goalDfGateway;
        this.eventDsGateway = eventDfGateway;
        this.goalStatsPresenter = goalStatsPresenter;

    }

    @Override
    public DynamicGoalStatsResponseModel create(DynamicGoalStatsRequestModel goalStatsrequestModel) {
        String goal = goalStatsrequestModel.getGoalName();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");


        DynGoalDsRequestModel dynGoalDsRequest = new DynGoalDsRequestModel(goal,)
        DynEventDsRequestModel dynEventDsRequest = new DynEventDsRequestModel(goal,);

        //check
        return goalResponseModel;

        //return DynamicGoalStatsPresenter
                //.prepareSuccessView(goalResponseModel);
    }
}