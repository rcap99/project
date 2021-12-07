/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

/**
 *
 * @author win10
 */
public class AlertError1 extends AlertError {

    public AlertError1(String operation) {
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
