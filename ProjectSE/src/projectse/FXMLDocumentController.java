/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectse;

import java.net.URL;
import java.util.ArrayList;
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
            alertErrore(returnValue,textField.getText());
        textField.clear();
        obList.clear();
        ArrayList<ComplexNumber>l=c.getLifoList();
        obList.addAll(l);
    }
    private void alertErrore(int returnValue,String operation){
        String customText,customAlert;
        switch(returnValue){
            case -2:
                customAlert="Insert a valid operation";
                customText="Unsopperted operation for " + operation;
                break;
            default:
                customAlert="Insert the correct number of elements in the stack";
                customText="There aren't enough elements in the stack to execute the operation of "+operation;
                break;
        }
        Alert alert=new Alert(AlertType.INFORMATION,customAlert);
        alert.setTitle("Fatal Error");
        alert.setHeaderText(customText);
        Optional <ButtonType> response=alert.showAndWait();
        }  
    
}
