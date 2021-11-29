/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectse;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<ComplexNumber> stackView;
    @FXML
    private TextField textField;
    @FXML
    private Button executeButton;
    
    Calculator c;
    ObservableList<ComplexNumber> obList = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<ComplexNumber, String> tableColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Calculator();
        tableColumn.setCellValueFactory(new PropertyValueFactory("complexString"));
        stackView.setItems(obList);
        stackView.setPlaceholder(new Label("Empty stack"));
    }    

    @FXML
    private void execute(ActionEvent event) {
        int returnValue=c.execute(textField.getText());
        if(returnValue!=0)
            alertError(returnValue,textField.getText());
        textField.clear();
        obList.clear();
        List<ComplexNumber>l=c.getLifoList();
        obList.addAll(l);
    }
    private void alertError(int returnValue,String operation){
        String customText,customAlert;
        switch(returnValue){
            case -2:
                customAlert="Insert a valid operation";
                customText="Unsopperted operation for " + operation;
                break;
            case -3:
                customAlert="Insert a valid operation name";
                customText="You cannot use \"" + operation.split(":")[0] + "\" as custom operation name";
                break;
            case -4:
                customAlert="Insert a valid operation sequence";
                customText="The operation sequence \"" + operation.split(":")[1] + "\" is invalid";
                break;
            default:
                customAlert="Insert the correct number of elements in the stack";
                customText="There aren't enough elements in the stack to execute the operation of "+operation;
                break;
        }
        Alert alert=new Alert(AlertType.ERROR,customAlert);
        alert.setTitle("Fatal Error");
        alert.setHeaderText(customText);
        Optional <ButtonType> response=alert.showAndWait();
        }  
    
}
