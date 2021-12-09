package complexcalculator.alert;

/**
 * This class creates an object used in case of error in the operation name
 * @author Group 11
 */
public class AlertOperationName extends AlertError{

    public AlertOperationName(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "Insert a valid operation name";
    }

    @Override
    public String getCustomText() {
        return "You cannot use \"" + getOperation().split(":")[0] + "\" as custom operation name";
    }
    
}
