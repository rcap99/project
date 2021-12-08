/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectse.alert;

import javafx.scene.control.Alert.AlertType;

/**
 * This is an Interface used for Alert Objects
 * @author Group11
 */
public interface AlertBase {
    /**
     * This method gets the CustomText string used in the alertShow method of the JavaFXController
     * @return a String
     */
    public String getCustomText();
    /**
     * This method return the CustomAlert string used in the alertShow method of the JavaFXController
     * @return a String
     */
    public String getCustomAlert();
    /**
     *
     * This method return the Title string used in the alertShow method of the JavaFXController
     * @return a String 
     */
    public String getTitle();
    /**
     * This method return the AlertType used in the alertShow method of the JavaFXController
     * @return a String
     */
    public AlertType getAlertType();
}
