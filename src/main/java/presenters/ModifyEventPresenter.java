package presenters;
import java.util.Scanner;

public class ModifyEventPresenter {
    // how this (is supposed to) work
    // 1) scan what type of info the user is trying to modify (name/startTime/endTime/commute/location)
        // (1-1) make 5 methods in gui
        // (1-2) gui needs to call the corresponding method in the presenter
    // 3) send that to controller

    private final String infoType;
    private final String modifiedInfo;

    /**
     * Constructs a presenter
     */

    public ModifyEventPresenter(){
        this.modifiedInfo = "";
        this.infoType = "";
    }

    public void GetNewInfo(String[] input) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String modifiedInfo = scanner.nextLine();  // Read user input
    }

    public String SetNewInfo() {
        return modifiedInfo;
    }
}
