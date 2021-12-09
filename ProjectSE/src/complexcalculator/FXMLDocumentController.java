package complexcalculator;


import complexcalculator.alert.AlertClear;
import complexcalculator.alert.AlertReloadFile;
import complexcalculator.alert.AlertSaveFile;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class defines the Controller who comunicates with the view and the calculator (model)
 * @author Group11
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
    @FXML
    private MenuItem clear;
    
    /**
     * Initialize the calculator
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new Calculator();
        tableColumn.setCellValueFactory(new PropertyValueFactory("complexString"));
        stackView.setItems(obList);
        stackView.setPlaceholder(new Label("Empty stack"));
        }   
    
    /**
     * Executes the desired operation and clears the text field
     * @param event : execute operation
     */
    @FXML
    private void execute(ActionEvent event) {
        int returnValue=c.execute(textField.getText());
        textField.clear();
        if(c.getComplexStack().hasChanged()){
            c.getComplexStack().notifyObservers();
            obList.clear();
            obList.addAll(c.getComplexStack());
        }
    }
    
    /**
     * Shows the alert
     * @param t : the type of the alert
     * @param title : title of the alert
     * @param customAlert : change the style of the alert
     * @param customText : change text of the alert
     */
    public static void showAlert(AlertType t,String title,String customAlert, String customText){
        Alert alert=new Alert(t,customAlert);
        alert.setTitle(title);
        alert.setHeaderText(customText);
        Optional <ButtonType> response=alert.showAndWait();
    }
    
    /**
     * Saves the file containing the operations
     * @param event : click on the save button from the menu item
     */
    @FXML
    private void saveOnFile(ActionEvent event) {
        ComplexNumber.saveOperations();
        c.setAlert(new AlertSaveFile());
        c.alert();
}
    
    /**
     * Loads the file previously saved
     * @param event : click on the load button from the menu item
     */
    @FXML
    private void loadFromFile(ActionEvent event) {
         Set<String> op=ComplexNumber.loadOperations();
         c.setAlert(new AlertReloadFile(op));
         c.alert();
    }
    
    /**
     * Clears the file containing all the operations
     * @param event : clik on the clear button from the menu item
     */
    @FXML
    private void clearFile(ActionEvent event) {
        ComplexNumber.clearOperations();
        c.setAlert(new AlertClear());
        c.alert();
    }
    
}
