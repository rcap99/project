package complexcalculator.alert;

import javafx.scene.control.Alert;

/**
 * This class creates an object used in case of error of the clearFile operation
 * @author Group 11
 */
public class AlertClear implements AlertBase{

    @Override
    public String getCustomText() {
        return "Operation/s Deleted";
    }

    @Override
    public String getCustomAlert() {
        return "The operation/s has/have been deleted";
    }

    @Override
    public String getTitle() {
        return "Clear Done";
    }

    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.INFORMATION;
    }
    
}
