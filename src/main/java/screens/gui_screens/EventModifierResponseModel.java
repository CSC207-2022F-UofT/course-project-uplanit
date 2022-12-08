package screens.gui_screens;

public class EventModifierResponseModel {

    // what we want to give to the presenter
    String name;
    String message;

    public EventModifierResponseModel(String name, String message)
    {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }
}
