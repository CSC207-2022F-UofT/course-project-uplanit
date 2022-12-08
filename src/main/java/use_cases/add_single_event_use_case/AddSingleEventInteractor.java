package use_cases.add_single_event_use_case;

import entities.Event;
import entities.EventFactory;
import entities.SingleEventFactory;

import java.time.LocalDateTime;

public class AddSingleEventInteractor {
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
        LocalDateTime commuteStart = requestModel.getStartTime().minusMinutes(requestModel.getCommuteTime());
        int commuteLength = requestModel.getCommuteTime();
        if (reader.checkConflict(requestModel.getStartTime(), requestModel.getEndTime())){
            return presenter.prepareFailView("Event has conflict");
        } else if (reader.checkConflict(commuteStart, requestModel.getStartTime())){
            return presenter.prepareFailView("Commute has conflict");
        }
        Event commuteEvent = factory.create((requestModel.getName() + " commute"), commuteStart, requestModel.getStartTime(), false, null, requestModel.getLocation());
        if (!commuteEvent.isValid()) {
            return presenter.prepareFailView("Commute was invalid");
        }
        Event event = factory.create(requestModel.getName(), requestModel.getStartTime(), requestModel.getEndTime(), requestModel.isCommute(), commuteEvent, requestModel.getLocation());
        if (!event.isValid()) {
            return presenter.prepareFailView("Event was invalid");
        }

        AddSingleEventDsRequestModel commuteDs = new AddSingleEventDsRequestModel(commuteEvent.getName(), commuteEvent.getStartTime(), commuteEvent.getEndTime(), true, 0, commuteEvent.getLocation(), "S");
        AddSingleEventDsRequestModel eventDs = new AddSingleEventDsRequestModel(event.getName(), event.getStartTime(), event.getEndTime(), false, commuteLength, event.getLocation(), "S");
        reader.save(commuteDs);
        reader.save(eventDs);

        AddSingleEventResponseModel accountResponseModel = new AddSingleEventResponseModel(event.getName());
        return presenter.prepareSuccessView(accountResponseModel);
    }
}
