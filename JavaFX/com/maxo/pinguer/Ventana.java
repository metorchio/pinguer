package com.maxo.pinguer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ventana extends Application {

	
    public static void main(String[] args) {
        Application.launch(Ventana.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
        
        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root));
        stage.show();
    }
}





/*
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Ventana extends Application
{
	public class Dev
	{	
		private String location;
		private String ip;
		
		Dev (String location, String ip)
		{
			this.location = location;
			this.ip = ip;
		}
	
	
		public String getLocation()
		{
			return this.location;
		}
		
		public String getIP()
		{
			return this.ip;
		}

	}
	
	
	private TableView<Dev> tableView = new TableView<>();
	
	private ObservableList<Dev> dataList = 
			FXCollections.observableArrayList(
					new Dev( "Calle1", "10.1.1.1" ),
					new Dev( "Calle2", "10.1.1.2" ),
					new Dev( "Calle3", "10.1.1.3" ),
					new Dev( "Calle4", "10.1.1.4" ),
					new Dev( "Calle5", "10.1.1.5" )
			);

	
	public static void asd(String[] args)
	{
		launch( args );
	}
	
	
    @Override
    public void start(Stage primaryStage)
    {
    	primaryStage.setTitle("Pinguer");
    	
    	javafx.scene.Group root = new javafx.scene.Group();
    	
    	tableView.setEditable(false);
    	
    	TableColumn columnLocation = new TableColumn("Ubicación");
    	columnLocation.setCellValueFactory( new PropertyValueFactory< Dev, String >("location") );
    	columnLocation.setMinWidth( 100 );
    	
    	TableColumn columnIP = new TableColumn("IP");
    	columnIP.setCellValueFactory( new PropertyValueFactory< Dev, String >("IP") );
    	columnIP.setMinWidth( 70 );
    	
    	TableColumn columnStatus = new TableColumn("Estado");
    	columnStatus.setMinWidth( 100 );
    	
    	tableView.setItems(dataList);
    	tableView.getColumns().addAll(columnLocation, columnIP, columnStatus);
    	
    	VBox vBox = new VBox();
    	vBox.setSpacing( 10 );
    	vBox.getChildren().add(tableView);
    	
    	root.getChildren().add(vBox);
    	
    	primaryStage.setScene( new Scene(root, 500, 350) );
    	primaryStage.show();
    	
    	
    }
	
}
*/