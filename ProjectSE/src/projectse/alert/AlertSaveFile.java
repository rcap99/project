/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

import java.util.Set;
import javafx.scene.control.Alert;
import projectse.ComplexNumber;

/**
 *
 * @author win10
 */
public class AlertSaveFile implements AlertStrategy{
    
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
