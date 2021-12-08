/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator.alert;

/**
 * This class creates an object used in case of error in the operation sequence
 * @author Group 11
 */
public class AlertInvalidOperationSequence extends AlertError{

    public AlertInvalidOperationSequence(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "Insert a valid operation sequence";
    }

    @Override
    public String getCustomText() {
        return "The operation sequence \"" + getOperation().split(":")[1] + "\" is invalid";
    }
    
}
