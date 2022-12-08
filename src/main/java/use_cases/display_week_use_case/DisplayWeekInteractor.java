package use_cases.display_week_use_case;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class DisplayWeekInteractor implements DisplayWeekInputBoundary{
    final DisplayWeekDsGateway reader;
    final DisplayWeekPresenter presenter;

    public DisplayWeekInteractor(DisplayWeekDsGateway reader, DisplayWeekPresenter presenter) {
        this.reader = reader;
        this.presenter = presenter;
    }

    @Override
    public DisplayWeekResponseModel create(DisplayWeekRequestModel requestModel) {
        /*
        if (reader.checkConflict(requestModel.getStartTime(), requestModel.getEndTime())){
            return presenter.prepareFailView("Event has conflict");
        } else if (reader.checkConflict(commuteStart, requestModel.getStartTime())){
            return presenter.prepareFailView("Commute has conflict");
        }
        TODO: ADD CHECKERS
        TODO: TURN LOCALDATETIME INTO LOCALDATE
         */
        */
        ArrayList<ArrayList<ArrayList<String>>> result = new ArrayList<ArrayList<ArrayList<>>>;
        LocalDate temp = requestModel.getDay().toLocalDate();
        LocalDate monday = temp.minusDays(temp.getDayOfWeek().getValue() -1);
        for (LocalDateTime key : reader.eventMap().keySet()){
            LocalDate day = key.toLocalDate();


        }

        AddSingleEventResponseModel accountResponseModel = new AddSingleEventResponseModel(event.getName());
        return presenter.prepareSuccessView(accountResponseModel);
    }
}
