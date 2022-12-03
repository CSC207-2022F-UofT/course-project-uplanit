package use_cases.add_dynamic_event_use_case;

import entities.DynamicEvent;
import entities.DynamicEventFactory;

// Use Case Layer

public class AddDynamicEventInteractor implements AddDynamicEventInputBoundary {

    final AddDynamicEventDsGateway dynamicEventDsGateway;
    final AddDynamicEventPresenter dynamicEventPresenter;
    final DynamicEventFactory dynamicEventFactory;


    public AddDynamicEventInteractor(AddDynamicEventDsGateway addDynamicEventDfGateway,
                                     AddDynamicEventPresenter addDynamicEventPresenter,
                                     DynamicEventFactory dynamicEventFactory) {
        this.dynamicEventDsGateway = addDynamicEventDfGateway;
        this.dynamicEventPresenter = addDynamicEventPresenter;
        this.dynamicEventFactory = dynamicEventFactory;

    }
    @Override
    public AddDynamicEventResponseModel create(AddDynamicEventRequestModel requestModel) {
        if () {
            return dynamicEventPresenter.prepareFailView("User already exists.");
        } else if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
            return dynamicEventPresenter.prepareFailView("Passwords don't match.");
        }

        User user = userFactory.create(requestModel.getName(), requestModel.getPassword());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        LocalDateTime now = LocalDateTime.now();
        UserRegisterDsRequestModel userDsModel = new UserRegisterDsRequestModel(user.getName(), user.getPassword(), now);
        userDsGateway.save(userDsModel);

        UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(user.getName(), now.toString());
        return userPresenter.prepareSuccessView(accountResponseModel);
    }
}
