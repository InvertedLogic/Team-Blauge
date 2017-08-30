package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;

public class LoginController {
	
	private Main main;
	
	@FXML
	private Button btn_LogIn;


	public void logInHandler() {
		main.showGUI();
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
}
