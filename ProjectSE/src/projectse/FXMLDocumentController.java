/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectse;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projectse.alert.AlertClear;
import projectse.alert.AlertReloadFile;
import projectse.alert.AlertSaveFile;
import projectse.alert.AlertStrategy;


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
    @FXML
    private MenuItem clear;
    
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
        /*if(returnValue!=0)
            c.alertError(returnValue,textField.getText());*/
        textField.clear();
        if(c.getComplexStack().hasChanged()){
            c.getComplexStack().notifyObservers();
            obList.clear();
            obList.addAll(c.getComplexStack());
        }
    }
    

    public static void showAlert(AlertType t,String title,String customAlert, String customText){
        Alert alert=new Alert(t,customAlert);
        alert.setTitle(title);
        alert.setHeaderText(customText);
        Optional <ButtonType> response=alert.showAndWait();
    }
    
    
    @FXML
    private void saveOnFile(ActionEvent event) {
        ComplexNumber.saveOperations();
        c.setAlert(new AlertSaveFile());
        c.alert();
}
    
    @FXML
    private void loadFromFile(ActionEvent event) {
         Set<String> op=ComplexNumber.loadOperations();
         c.setAlert(new AlertReloadFile(op));
         c.alert();
    }

    @FXML
    private void clearFile(ActionEvent event) {
        ComplexNumber.clearOperations();
        c.setAlert(new AlertClear());
        c.alert();
    }
    
}
