package com.maxo.pinguer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutLayoutController 
{
	private RootLayoutController mainWindow;
	
	private Stage aboutLayoutStage;
	
	@FXML
	private Button exit;
	
	@FXML
	private void handleExit( )
	{
		aboutLayoutStage.close();
	}

	public void setStage(Stage stage) 
	{
		this.aboutLayoutStage = stage;		
	}
	
    public void setMainWindow(RootLayoutController mainWindow)
    {
        this.mainWindow = mainWindow;
    }
}
