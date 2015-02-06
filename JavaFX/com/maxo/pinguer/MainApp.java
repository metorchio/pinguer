package com.maxo.pinguer;

import java.io.IOException;

import com.maxo.pinguer.model.ObservableDevice;
import com.maxo.pinguer.view.DeviceOverviewController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application 
{

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<ObservableDevice> devices = FXCollections.observableArrayList();
	
	public MainApp() 
	{
		devices.addAll( new ObservableDevice("Calle 1", "192.168.200.30"), 
						new ObservableDevice("Calle 2", "192.168.200.31"),
						new ObservableDevice("Calle 3", "192.168.200.32"),
						new ObservableDevice("Calle 4", "192.168.200.33")			
					  );
	}
	
	public ObservableList<ObservableDevice> getDevices() 
	{
		return devices;
	}
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Pinguer");
		
		initRootLayout();
		
		showDeviceOverview();
	}

	public void initRootLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainApp.class.getResource("view/RootLayout.fxml") );
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void showDeviceOverview()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainApp.class.getResource("view/DeviceOverview.fxml") );
			AnchorPane deviceOverview = (AnchorPane) loader.load();
			
			rootLayout.setCenter(deviceOverview);
			
			DeviceOverviewController controller = loader.getController();
			controller.setMainApp(this);
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Stage getPrimaryStage()
	{
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}











