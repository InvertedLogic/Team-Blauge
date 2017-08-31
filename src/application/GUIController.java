package application;

import com.jfoenix.controls.JFXColorPicker;

import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;

public class GUIController {
	
	private Main main;
	
	
private JFXColorPicker colorPicker;		// https://github.com/jfoenixadmin/JFoenix/issues/408
	
	
	public GUIController() {
		this.colorPicker = new JFXColorPicker();
        //this.colorPicker.editableProperty().bind(column.editableProperty());
        //this.colorPicker.disableProperty().bind(column.editableProperty().not());
        this.colorPicker.setOnShowing(event -> {
            //nothing yet
        });
        this.colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            
        		//newValue is selected color
                
        });
    
		}
	
	
	
	public void setMainApp(Main main) {
		this.main = main;
	}
}
