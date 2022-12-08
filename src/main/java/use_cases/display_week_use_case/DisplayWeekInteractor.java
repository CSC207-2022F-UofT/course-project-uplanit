package use_cases.display_week_use_case;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        ArrayList<ArrayList<ArrayList<String>>> week = new ArrayList<>();
        LocalDate temp = LocalDateTime.parse(requestModel.getDay(), formatter).toLocalDate();
        LocalDate monday = temp.minusDays(temp.getDayOfWeek().getValue() -1);
        LocalDate counter;
        for (int i=0; i<8; i++){
            counter = monday.plusDays(i);
            for (LocalDateTime key : reader.eventMap().keySet()){
                ArrayList<ArrayList<String>> thisDay = new ArrayList<>();
                week.add(thisDay);
                LocalDate keyDate = key.toLocalDate();
                if (keyDate.equals(counter)){
                    thisDay.add(reader.eventMap().get(key).toStringList());
                }
            }

        }

        DisplayWeekResponseModel accountResponseModel = new DisplayWeekResponseModel(week);
        return presenter.prepareSuccessView(accountResponseModel);
    }
}
