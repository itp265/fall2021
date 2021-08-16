import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class OpeningScene {

	@FXML
	private TextField fNameFiled;

	@FXML
	private TextField lnameField;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Button SubmitButton;

	private MyApplication myapp;
	@FXML
	void doSubmitData(ActionEvent event) {
		System.out.println("Button pressed");
		if(fNameFiled.getText() == null || lnameField.getText() == null || datePicker.getValue() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("You didn't enter all the data");
			alert.setContentText("Make sure that first name, last name, and birthday have all been entered.");
			alert.showAndWait(); // show the alert and wait for user to press 
			//button before running the next two lines of code
		}
		else {
			String name = fNameFiled.getText() + " " + lnameField.getText();
			LocalDate bday =  datePicker.getValue();

			String info = "You entered: " + name + " as the name, and " + bday + " as the birthday";
			System.out.println(info);
		}
	}

	public void setMainApp(MyApplication a) {
		myapp = a;
	}
}

























