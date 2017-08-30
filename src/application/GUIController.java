package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GUIController {
	
	private Main main;
	
	@FXML
	private Button btn_logOut;
	
	@FXML
	private Button btn_switchProject;
	
	@FXML
	private Button btn_stepForward;
	
	@FXML
	private Button btn_stepBack;
	
	@FXML
	private Button btn_taskInfo;
	
	@FXML
	private Button btn_taskTags;
	
	@FXML
	private Button btn_taskComments;
	
	public void setMainApp(Main main) {
		this.main = main;
	}
}
