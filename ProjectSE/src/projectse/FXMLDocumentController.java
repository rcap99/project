/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectse;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author win10
 */
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
        tableColumn.setCellValueFactory(new PropertyValueFactory("complex"));
        stackView.setItems(obList);
        
    }    

    @FXML
    private void execute(ActionEvent event) {
        c.execute(textField.getText());
        textField.clear();
        obList.add(c.getComplexStack().peek()); //non va bene
    }
    
}
