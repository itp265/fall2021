import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OpeningController {

    @FXML
    private TextField firstnameTF;

    @FXML
    private TextField lNameTF;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button submitButton;
    
    @FXML
    private Label errorMessage;
    
    private MainApp myApp;
    public void setMainApp(MainApp app) {
    	myApp = app;
    	
    }

    @FXML
    void doSubmit(ActionEvent event) {
    	System.out.println("Someone clicked the submit button");
    	if( firstnameTF.getText().isBlank() || lNameTF.getText().isBlank() || datePicker.getValue() == null) {
    		errorMessage.setText("You do not fill out all of the necessary form components");
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Warning Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("You didn't enter all the data, please fill out all fields");
    		alert.showAndWait();
    		
    	}
    	else {
    		String name  = firstnameTF.getText() + " " + lNameTF.getText();
    		LocalDate bday = datePicker.getValue();
    	
    		System.out.println("Got person data: " + name + " with bday = " + bday);
    		errorMessage.setText("");
    		myApp.goToSecondScene();
    	}
    }

}
