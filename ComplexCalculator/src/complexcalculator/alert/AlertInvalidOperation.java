/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator.alert;

/**
 * This class creates an object used in case of error in using the operations
 * @author Group 11
 */

public class AlertInvalidOperation extends AlertError{

    public AlertInvalidOperation(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "Insert a valid operation";
    }

    @Override
    public String getCustomText() {
        return "Unsopperted operation for " + getOperation();
    }
    
}
