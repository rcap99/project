/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator.alert;

/**
 * This class creates an object used in case of error in the number of elements in the stack
 * @author Group 11
 */
public class AlertNumberElements extends AlertError {

    public AlertNumberElements(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "Insert the correct number of elements in the stack";
    }

    @Override
    public String getCustomText() {
        return "There aren't enough elements in the stack to execute the operation of "+getOperation();
    }

    

    
    
}
