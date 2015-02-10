package com.maxo.pinguer.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import com.maxo.pinguer.MainApp;

public class RootLayoutController 
{
	private MainApp mainApp;
	
    public void setMainApp(MainApp mainApp) 
    {
        this.mainApp = mainApp;
    }
	
    @FXML
    private void handleNew()
    {
    	mainApp.getDevices().clear();
    	    	
    }
    
    @FXML
    private void handleOpen()
    {
    	FileChooser fileChooser = new FileChooser();
    	
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls");
    	fileChooser.getExtensionFilters().add(extFilter);
    	
    	File file = fileChooser.showOpenDialog( mainApp.getPrimaryStage() );
    	
    	if (file != null)
    	{
    		try
    		{
    			mainApp.loadDevicesFromXLS(file);
    		}
    		catch (Exception e)
    		{
    			System.err.println("Not file found.");
    		}
    	}
    	
    }
    
    @FXML
    private void handleAbout()
    {
    	
    	
    }
    
    @FXML
    private void handleExit()
    {
    	System.exit(0);
    }
    
}
