package complexcalculator.alert;

/**
 * This class creates an object used in case of error in using the variables
 * @author Group 11
 */
public class AlertEmptyVariables extends AlertError{

    public AlertEmptyVariables(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "Save variables first.";
    }

    @Override
    public String getCustomText() {
        return "There aren't saved variables or the selected variable is empty!";
    }
    
}
