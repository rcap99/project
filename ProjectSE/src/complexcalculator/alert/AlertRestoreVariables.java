package complexcalculator.alert;

import java.util.HashMap;
import javafx.scene.control.Alert;
import complexcalculator.ComplexNumber;

/**
 * This class creates an object used in case of error in restoring the variables
 * @author Group 11
 */
public class AlertRestoreVariables implements AlertBase{

    private HashMap<String, ComplexNumber> v;

    public AlertRestoreVariables(HashMap<String, ComplexNumber> v) {
        this.v = v;
    }
    
    @Override
    public String getCustomText() {
        if(v!=null){
            return "Variable/s Restored";
        }
        else{
            return "It's not possible to restore variable/s!";
        }
    }

    @Override
    public String getCustomAlert() {
        if(v!=null){
            String customAlert="The variable/s: \n";
            for(String k: v.keySet()){
                customAlert+="- "+k+": "+v.get(k)+"\n";
            }
            customAlert+="has/have been restored";
            return customAlert;
        }
        else{
            return "Error in restoring variables!";
        }
    }

    @Override
    public String getTitle() {
        if(v!=null){
            return "Restoring Done";
        }
        else{
            return "Restoring Failed";
        }
    }

    @Override
    public Alert.AlertType getAlertType() {
        if(v!=null){
            return Alert.AlertType.INFORMATION;
        }
        else{
            return Alert.AlertType.ERROR;
        }
    }
}
