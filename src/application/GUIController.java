package application;

import java.io.File;
import java.util.Random;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GUIController {
	@FXML
    private Label labelProjectname;

    @FXML
    private Label labelProjectinformation;

    @FXML
    private Label labelUser;

    @FXML
    private MenuButton menuButtonFilter;

    @FXML
    private Label labelTaskname;

    @FXML
    private Label labelAuthor;

    @FXML
    private Label labelStatus;

    @FXML
    private Label labelColor;

    @FXML
    private Label labelDescription;

    @FXML
    private Label labelTags;

    @FXML
    private Label labelActualAuthor;

    @FXML
    private Label labelActualStatus;

    @FXML
    private JFXTextField textFieldTaskname;

    @FXML
    private JFXColorPicker ColorPicker;

    @FXML
    private JFXTextArea textAreaDescription;

    @FXML
    private JFXListView<?> listViewTags;

    @FXML
    private Label labelComments;

    @FXML
    private JFXListView<?> listViewComments;

    @FXML
    private JFXTextField textFieldTags;

    @FXML
    private JFXButton buttonAddTag;

    @FXML
    private JFXTextField textFieldComments;

    @FXML
    private JFXButton buttonAddComment;
    
    @FXML
    private JFXButton buttonEditTaskName;
    
    @FXML
    private ImageView buttonEditTaskNameIcon;

    @FXML
    private JFXButton buttonProjectselection;

    @FXML
    private JFXButton buttonLogOut;

    @FXML
    private JFXButton buttonProceed;

    @FXML
    private JFXButton buttonReturn;

    @FXML
    private JFXButton buttonInformation;

    @FXML
    private JFXButton buttonTags;

    @FXML
    private JFXButton buttonComments;
    
    @FXML
    private JFXButton buttonNewTask;

    @FXML
    private Label labelToDo;

    @FXML
    private Label labelDoing;

    @FXML
    private Label labelFinished;

    @FXML
    private JFXMasonryPane mansoryPaneToDo;

    @FXML
    private JFXMasonryPane mansoryPaneDoing;

    @FXML
    private JFXMasonryPane mansoryPaneFinished;

	private Main main;

	private JFXColorPicker colorPicker; // https://github.com/jfoenixadmin/JFoenix/issues/408

	public GUIController() {
		this.colorPicker = new JFXColorPicker();
		// this.colorPicker.editableProperty().bind(column.editableProperty());
		// this.colorPicker.disableProperty().bind(column.editableProperty().not());
		this.colorPicker.setOnShowing(event -> {
			// nothing yet
		});
		this.colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {

			// newValue is selected color

		});

	}
	
	public void initnshit() {
		//hier können keylistener und sowas initialisiert werden
    	textFieldTaskname.editableProperty().set(false);

		
		((Scene) labelProjectname.getScene()).setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ESCAPE))
                {
                    main.showLogin();
                }
            }
        });
		
	}
	
	public void setMainApp(Main main) {
		this.main = main;
	}
	
	@FXML
    void ColorPickerSelectionChanged(ActionEvent event) {

    }

    @FXML
    void buttonCommentsPressed(ActionEvent event) {

    }

    @FXML
    void buttonInformationPressed(ActionEvent event) {

    }

    @FXML
    void buttonLogOutPressed(ActionEvent event) {
    	main.showLogin();
    }

    @FXML
    void buttonProceedPressed(ActionEvent event) {

    }

    @FXML
    void buttonProjectselectionPressed(ActionEvent event) {

    }

    @FXML
    void buttonReturnPressed(ActionEvent event) {

    }

    @FXML
    void buttonTagsPressed(ActionEvent event) {

    }
    
    @FXML
    void buttonEditTaskNamePressed(ActionEvent event) {
    	if(textFieldTaskname.editableProperty().get()){
    		textFieldTaskname.editableProperty().set(false);
        	saveEnteredTaskname(textFieldTaskname.getText());
    		/*
    		 * TODO:
    		 * ändere das icon des buttons wieder zu 'Stift'
    		 */
    	}
    	else {
    		
    		this.textFieldTaskname.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent ke)
	            {
	                if (ke.getCode().equals(KeyCode.ENTER))
	                {
	                	saveEnteredTaskname(textFieldTaskname.getText());
	                	textFieldTaskname.editableProperty().set(false);
	                	
	                    /*
	                     * TODO:
	                     * ändere Buttonicon wieder zu stift
	                     * wenn >TAB< gedrueckt waehrend im Textfield soll fokus auf Button gelegt werden
	                     */ 
	                	//File file = new File("/resources/Icons/save.png");
	                	Image img = new Image("./src/main/resources/Icons/save.png",true);
	                	buttonEditTaskNameIcon.setImage(img);
	                	//buttonEditTaskNameIcon.getImage();
	                }
	            } 
	        });
    	
    		textFieldTaskname.editableProperty().set(true);
    		
    		/*
    		 * TODO:
    		 * ändere Icon zu speichern icon
    		 */
    		
    	}
    }
    void saveEnteredTaskname(String name) {
    	textFieldTaskname.setText(name);
    	labelActualAuthor.setText(name);
    }
    
    
    @FXML
    void buttonNewTaskPressed(ActionEvent event) {
    	//Random r = new Random();
    	for (int i = 0; i < 10; i++){
    		Label lbl = new Label();
    		lbl.setPrefSize(100, 100);
    		lbl.setStyle("-fx-background-color: white;");
    		lbl.setText("Ich bin Post-It " + i);
    		mansoryPaneToDo.getChildren().add(lbl);
    		System.out.println("LOL");
    	}
    }
}
