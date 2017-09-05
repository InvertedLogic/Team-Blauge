package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProjectListController {

	@FXML
	private Label labelUser;

	@FXML
	private JFXButton buttonLogOut;

	@FXML
	private JFXTreeTableView<?> tableProjectList;

	@FXML
	private JFXTextField textFieldProjectName;

	@FXML
	private JFXTextArea textAreaProjectDescription;

	@FXML
	private JFXListView<?> listProjectMember;

	@FXML
	private ImageView buttonAddMember;

	@FXML
	private JFXButton buttonAddProject;

	@FXML
	private JFXButton buttonBack;

	private Main main;

	public ProjectListController() {

	}

	public void init() {

	}

	public void setMainApp(Main main) {
		this.main = main;
	}

	@FXML
	void buttonLogOutPressed(ActionEvent event) {
		main.showLogin();
	}

	@FXML
	void buttonBackPressed(ActionEvent event) {
		main.showGUI();
	}

}
