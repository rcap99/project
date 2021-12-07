/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

import java.util.Set;
import javafx.scene.control.Alert;

/**
 *
 * @author win10
 */
public class AlertReload implements AlertStrategy{
    
    private Set<String> op;
    
    public AlertReload(Set<String> op) {
        this.op = op;
    }
    
    
    @Override
    public String getCustomText() {
        if(!op.isEmpty()){
            return "Operation/s Reloaded";
        }else{
            return "There aren't operations that need to be reloaded!";
        }
    }

    @Override
    public String getCustomAlert() {
        if(!op.isEmpty()){
            String customAlert="The operation/s of: \n";
            for(String s: op){
                customAlert+="- "+s+"\n";
            }
            customAlert+="has/have been reloaded";
            return customAlert;
        }else{
            return "Save at least one operation!";
        }}

    @Override
    public String getTitle() {
        if(!op.isEmpty()){
            return "Reloading Done";
        }else{
            return "Reloading Failed";
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
