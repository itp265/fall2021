import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application {
	private Stage myStage;
	private Scene scene1;
	@Override
	public void init() {
		System.out.println("Automtically gets called first for setup");
		try {
			////////////// SETUP FOR EACH SCENE /////////////////////
			//Read in the FXML file
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("Opening.fxml"));
			// get the top-level "root" of the hierarchy
			Parent root = loader.load();
			//Controller for a specific scene
			OpeningScene control = (OpeningScene)loader.getController();
			// ability for controller to communicate back to main application (this)
			control.setMainApp(this);
			//make the scene based on the root hierarchy
			scene1 = new Scene(root, 400, 300);
		}
		catch(IOException e) {
			System.out.println("Application fxml is not set up properly. exiting program");
			e.printStackTrace(); //to see what is happening
			System.exit(1);
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
		myStage = arg0;
		myStage.setTitle("Sample FX Application");
		myStage.setScene(scene1);
		myStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}




