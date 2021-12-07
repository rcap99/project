/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectse.alert;

import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author win10
 */
public interface AlertStrategy {
    public String getCustomText();
    public String getCustomAlert();
    public String getTitle();
    public AlertType getAlertType();
}
