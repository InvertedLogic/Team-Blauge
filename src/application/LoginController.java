package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

	private Main main;
	
    @FXML
    private JFXTextField textFieldLogInScreenUsername;

    @FXML
    private JFXPasswordField textFieldLogInScreenPassword;

    @FXML
    private JFXButton buttonLogInScreenLogIn;

    @FXML
    private JFXButton buttonLogInScreenSettings;

    @FXML
    private JFXButton buttonLogInScreenInformation;

    @FXML
    void buttonLogInScreenInformationPressed(ActionEvent event) {

    }
    
    public void setMainApp(Main main) {
		this.main = main;
	}

    @FXML
    void buttonLogInScreenLogInPressed(ActionEvent event) {
    	//main.showGUI();
    	main.log(textFieldLogInScreenUsername.getText(), "username");
		main.log(textFieldLogInScreenPassword.getText(), "passwort");
    	if(textFieldLogInScreenUsername.getText() == "fiete" && textFieldLogInScreenPassword.getText() == "12345a") {
    		main.log(textFieldLogInScreenUsername.getText(), "username");
    		main.log(textFieldLogInScreenPassword.getText(), "passwort");
    		
    	}
    }

    @FXML
    void buttonLogInScreenSettingsPressed(ActionEvent event) {

    }

}
