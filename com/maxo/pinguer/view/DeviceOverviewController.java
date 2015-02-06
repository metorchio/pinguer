package com.maxo.pinguer.view;

import java.io.IOException;

import com.maxo.pinguer.MainApp;
import com.maxo.pinguer.model.ObservableDevice;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;


public class DeviceOverviewController 
{
	@FXML
	private TableView<ObservableDevice> deviceTable;
	
	@FXML
	private TableColumn<ObservableDevice, String> columnLocation;
	
	@FXML
	private TableColumn<ObservableDevice, String> columnIP;
	
	@FXML
	private TableColumn<ObservableDevice, String> columnStatus;
	
	@FXML
	private Label labelCantDevices;
	
	@FXML
	private Label labelLocation;
	
	@FXML
	private Label labelIP;
	
	@FXML
	private Button btnRefresh;
	
	private MainApp mainApp;

	
	public DeviceOverviewController()
	{
		
	}
	
	private void showDeviceLength( ObservableList<ObservableDevice> devices )
	{
		if ( devices != null)
			labelCantDevices.setText( Integer.toString( devices.size() ) );
			//labelCantDevices.setText( Integer.toString( deviceTable.getItems().size() ) );
		else
			labelCantDevices.setText("Cant. cámaras.");
	}
	
	private void showDeviceDetails ( ObservableDevice device ) // throws IOException, InterruptedException
	{
		if ( device != null  )
		{
			labelLocation.setText( device.getLocation().get() );
			labelIP.setText( device.getIP().get() );
			//labelIP.setText( device.isAlive().get() );
		}
		else
		{
			labelLocation.setText( "Location:" );
			labelIP.setText( "IP:" );			
		}
		
	}
	
	@FXML
	public void initialize( ) throws IOException, InterruptedException
	{
		
		columnLocation.setCellValueFactory(cellData -> cellData.getValue().getLocation());
		columnIP.setCellValueFactory(cellData -> cellData.getValue().getIP());
		//columnStatus.setCellValueFactory(cellData -> cellData.getValue().isAlive() );
		
		//showDeviceLength(deviceTable);
		
		deviceTable.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue)
				-> showDeviceDetails(newValue) );
		
	}
	
	public void setMainApp( MainApp mainApp )
	{
		this.mainApp = mainApp;
		
		deviceTable.setItems( mainApp.getDevices() );
	}
	
}
