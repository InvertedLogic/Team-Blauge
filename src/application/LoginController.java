package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

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
    
    public LoginController() {
    	
    	System.out.println("created LoginController");
    	
    	
    	/*
    	 * Keylistener for calling login function when pressing ENTER in passwordline
    	 * doesn't work yet, don't know why
    	 */
    	JFXPasswordField textFieldLogInScreenPassword = new JFXPasswordField();
    	/*textFieldLogInScreenPassword.setOnKeyPressed(event -> {
    		   if(event.getCode() == KeyCode.ENTER){
    			     checkLoginData();
    		   }
    	});*/
    	
    	textFieldLogInScreenPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER))
                {
                    checkLoginData();
                }
            }
        });
        
    }
    
    
    public void setMainApp(Main main) {
		this.main = main;
	}

    
    
    @FXML
    void buttonLogInScreenLogInPressed(ActionEvent event) {
    	checkLoginData();
    }
    
    private String username = "fiete";
    private String passwort = "123";
    
    public void checkLoginData() {
    	main.log("Check Login");
	    if(textFieldLogInScreenUsername.getText().equals(username)  && textFieldLogInScreenPassword.getText().equals(passwort)) {
			main.showGUI();
		}
    }

    @FXML
    void buttonLogInScreenSettingsPressed(ActionEvent event) {

    }

}
