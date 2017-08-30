package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	BorderPane root = new BorderPane();
	Stage primaryStage = new Stage();
	
	@Override
	public void start(Stage primaryStage) {
		try {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("BLAUGE Kanban");
	        initRoot();
	        //showGUI();
	        showLogin();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initRoot() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("rootLayout.fxml"));
            root = (BorderPane) loader.load();
       
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void showGUI() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GUI.fxml"));
            AnchorPane GUI = (AnchorPane) loader.load();

            root.setCenter(GUI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void showLogin() {
		 try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("loginScreen.fxml"));
	            AnchorPane GUI = (AnchorPane) loader.load();

	            root.setCenter(GUI);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	