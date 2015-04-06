package carAndHouse;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIScreen extends Application {
	public void start(Stage primaryStage) {
		// Buttons do not expand past their natural size
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.setColumnHalignment(HPos.LEFT);
		Label message = new Label("0 cars and 0 houses");
		Button carButton=new Button("Car");
		Button houseButton=new Button ("House");
		Button deleteCarButton=new Button("Delete Car");
		Button deleteHouseButton=new Button ("Delete House");
		Button helpButton=new Button("Help");
		//pane.setLeft(carButton);
		//pane.setRight(houseButton);//works for borderPane
		List <Car> cars=new ArrayList<Car>();
		List<House> houses = new ArrayList<House>();
		pane.getChildren().addAll(carButton, houseButton, deleteCarButton, deleteHouseButton,
				helpButton, message);
		carButton.setOnAction(event -> {cars.add(new Car());message.setText(cars.size() + 
				" cars and "+houses.size()+" houses.");});
		houseButton.setOnAction(event -> {houses.add(new House());message.setText(cars.size()+
				" cars and "+houses.size()+" houses.");});
		deleteCarButton.setOnAction(event ->{if(cars.size()>0){cars.remove(0);}});
		deleteHouseButton.setOnAction(event->{if(houses.size()>0){houses.remove(0);}});
		//helpButton pops a dialog.
		Group root = new Group(pane);
		Scene scene = new Scene(root, 800, 600);
				
		primaryStage.setScene(scene);
		primaryStage.setTitle("Car and House");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
