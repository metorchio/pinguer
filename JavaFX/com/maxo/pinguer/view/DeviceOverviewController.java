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
import javafx.scene.control.cell.PropertyValueFactory;
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
	private Label labelStatus;
	
	@FXML
	private Button btnRefresh;
	
	private MainApp mainApp;

	
	public DeviceOverviewController()
	{
		
	}
	
	private void loadDevices()
	{
		/*
		 * Acá tendría que abrir el archivo de redes y cargarlos!
		 * 
		 * 	CARAJO MIERDA !
		 */
	}
	
	private void showDeviceDetails( ObservableDevice device )
	{
		if ( device != null  )
		{
			labelLocation.setText( device.getLocation().get() );
			labelIP.setText( device.getIP().get() );
			labelStatus.setText("Status.");
		}
		else
		{
			labelLocation.setText( "Location:" );
			labelIP.setText( "IP:" );			
		}
		
	}
	
	@FXML
	private void handleRefresh() throws IOException, InterruptedException
	{
		ObservableDevice selectedItem = deviceTable.getSelectionModel().getSelectedItem();
		labelStatus.setText( selectedItem.isAlive().get() );
		//columnStatus.setCellValueFactory( new PropertyValueFactory<String, String>("Hola") );
	}
	
	@FXML
	public void initialize( ) throws IOException, InterruptedException
	{
		
		columnLocation.setCellValueFactory(cellData -> cellData.getValue().getLocation());
		columnIP.setCellValueFactory(cellData -> cellData.getValue().getIP());
		columnStatus.setCellValueFactory(new PropertyValueFactory<ObservableDevice, String>( "Hola" ) );
		//columnStatus.setCellValueFactory(cellData -> cellData.getValue().isAlive() );
		
		//showDeviceLength(deviceTable);
		//System.out.println( deviceTable.getItems().size() );
		
		deviceTable.getSelectionModel().selectedItemProperty().addListener( (observable, oldValue, newValue)
				-> showDeviceDetails(newValue) );
				
	}
	
	public void setMainApp( MainApp mainApp )
	{
		this.mainApp = mainApp;
		
		deviceTable.setItems( mainApp.getDevices() );
	}
	
}
