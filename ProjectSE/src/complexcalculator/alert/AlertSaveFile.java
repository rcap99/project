package complexcalculator.alert;

import java.util.Set;
import javafx.scene.control.Alert;
import complexcalculator.ComplexNumber;

/**
 * This class creates an object used when saving the operations
 * @author Group 11
 */
public class AlertSaveFile implements AlertBase{
    
    private Set<String> op=ComplexNumber.getOperationsNames();
    
    @Override
    public String getCustomText() {
        if (!op.isEmpty()){
            return "Operation/s Saved";
        }
        else{
            return "There aren't operations that need to be saved!";
        }
    }

    @Override
    public String getCustomAlert() {
        if (!op.isEmpty()){
            String customAlert="The operation/s of: \n";
            for(String s: op){
                customAlert+="-"+s+"\n";
            }
        customAlert+="has/have been saved";
        return customAlert;
        }
        else{
            return "Define at least one operation!";
        }
    }

    @Override
    public String getTitle() {
        if(!op.isEmpty()){
            return "Saving Done";
        }
        else{
            return "Saving Failed";
        }
    }

    @Override
    public Alert.AlertType getAlertType() {
        if(!op.isEmpty()){
            return Alert.AlertType.INFORMATION;
        }else{
            return Alert.AlertType.ERROR;
        }
    }
    
}
