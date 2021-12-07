/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

/**
 *
 * @author win10
 */
public class AlertError5 extends AlertError{

    public AlertError5(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "There isn't a valid custom operation for the inserted name";
    }

    @Override
    public String getCustomText() {
        return "The custom operation of \"" + getOperation().split(":")[1]+"\" is invalid";
    }
    
}
