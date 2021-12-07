/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

/**
 *
 * @author win10
 */
public class AlertError4 extends AlertError{

    public AlertError4(String operation) {
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
