import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author kendra
 *
 */
public class MainApp extends Application {

	//instance variables
	private Stage stage;
	private Scene openScene;
	private Scene secondScene;
	
	@Override
	public void init() {
		// because of template design pattern, this method is always called when a program starts
		System.out.println("Initializing application");
		try { //shift-ctrl.cmd - o
			////////////// SETUP FOR EACH SCENE /////////////////////
			//Read in the FXML file
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("OpeningScene.fxml"));
			FXMLLoader loader2  = new FXMLLoader(getClass().getResource("SecondScene.fxml"));
			// get the top-level "root" of the hierarchy
			Parent root = loader.load();
			
			//Controller for a specific scene
			OpeningController control = (OpeningController)loader.getController();
			SecondSceneControl control2 = (SecondSceneControl)loader2.getController();
		
			
			// ability for controller to communicate back to main application (this)
			control.setMainApp(this);
			
			//make the scene based on the root hierarchy
			openScene = new Scene(root, 500, 400);
			secondScene = new Scene(loader2.load(), 500, 400);
		}
		catch(IOException e) {
			System.out.println("Application fxml is not set up properly. exiting program");
			e.printStackTrace(); //to see what is happening
			System.exit(1);
		}
		
		
	}
	
	@Override
	public void stop() {
		// because of template design pattern, this method is always called when a program ends
		System.out.println("Shutting down application, make sure to SAVE data");
		
	}
	@Override
	public void start(Stage myStage) throws Exception {
		stage = myStage; // put the stage as an instance variable
		myStage.setTitle("265 AMAZING GUI"); // window the title it needs
		
		
	
		myStage.setScene(openScene);
		myStage.show();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

	public void goToSecondScene() {// TODO Auto-generated method stub
		stage.setScene(secondScene);
		stage.show();
	}

}
