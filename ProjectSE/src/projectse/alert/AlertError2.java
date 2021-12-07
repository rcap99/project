/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

/**
 *
 * @author win10
 */
public class AlertError2 extends AlertError{

    public AlertError2(String operation) {
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
