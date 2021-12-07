/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

/**
 *
 * @author win10
 */
public class AlertError6 extends AlertError{

    public AlertError6(String operation) {
        super(operation);
    }

    @Override
    public String getCustomAlert() {
        return "Save variables first.";
    }

    @Override
    public String getCustomText() {
        return "There aren't saved variables or the selected variable is empty!";
    }
    
}
