package complexcalculator.alert;

/**
 * This class creates an object used in case of invalid operation name
 * @author Group 11
 */
public class AlertUnsupportedOperationName extends AlertError{

    public AlertUnsupportedOperationName(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "There isn't a valid custom operation for the inserted name";
    }

    @Override
    public String getCustomText() {
        return "The custom operation of \"" + getOperation().split(":")[1]+"\" is invalid";
    }
    
}
