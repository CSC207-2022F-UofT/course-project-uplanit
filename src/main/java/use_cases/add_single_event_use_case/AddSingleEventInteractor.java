package use_cases.add_single_event_use_case;

import entities.Event;
import entities.EventFactory;
import entities.SingleEventFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddSingleEventInteractor implements AddSingleEventInputBoundary {
/*
CALL EVENT FACTORY

 */
    final AddSingleEventDsGateway reader;
    final AddSingleEventPresenter presenter;
    final EventFactory factory;

    public AddSingleEventInteractor(AddSingleEventDsGateway reader, AddSingleEventPresenter presenter,
                                    SingleEventFactory factory) {
        this.reader = reader;
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public AddSingleEventResponseModel create(AddSingleEventRequestModel requestModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(requestModel.getStartTime(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(requestModel.getStartTime(), formatter);
        int commuteLength = Integer.parseInt(requestModel.getCommuteTime());
        LocalDateTime commuteStart = startTime.minusMinutes(commuteLength);

        if (reader.checkConflict(startTime, endTime)){
            return presenter.prepareFailView("Event has conflict");
        } else if (reader.checkConflict(commuteStart, startTime)){
            return presenter.prepareFailView("Commute has conflict");
        }
        Event commuteEvent = factory.create((requestModel.getName() + " commute"), commuteStart, startTime, false, null, requestModel.getLocation());
        if (!commuteEvent.isValid()) {
            return presenter.prepareFailView("Commute was invalid");
        }
        Event event = factory.create(requestModel.getName(), startTime, endTime, true, commuteEvent, requestModel.getLocation());
        if (!event.isValid()) {
            return presenter.prepareFailView("Event was invalid");
        }

        AddSingleEventDsRequestModel commuteDs = new AddSingleEventDsRequestModel(commuteEvent.getName(), commuteEvent.getStartTime(), commuteEvent.getEndTime(), true, 0, commuteEvent.getLocation(), "S");
        AddSingleEventDsRequestModel eventDs = new AddSingleEventDsRequestModel(event.getName(), event.getStartTime(), event.getEndTime(), false, commuteLength, event.getLocation(), "S");
        reader.save(commuteDs);
        reader.save(eventDs);

        AddSingleEventResponseModel response = new AddSingleEventResponseModel(event.getName());
        return presenter.prepareSuccessView(response);
    }
}
