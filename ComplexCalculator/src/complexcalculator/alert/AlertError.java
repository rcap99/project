/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator.alert;

import javafx.scene.control.Alert;

/**
 * This is an abstract class that implements some common method used for the other alert objects
 * @author Group 11
 */
public abstract class AlertError implements AlertBase{
    private String operation; 
    
    public AlertError(String operation) {
        this.operation=operation;
    }
    
    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.ERROR;
   }

    @Override
    public String getTitle(){
        return "Fatal Error";
    }

    @Override
    public abstract String getCustomAlert();

    @Override
    public abstract String getCustomText();

    public String getOperation() {
        return operation;
    }

    
    
}
