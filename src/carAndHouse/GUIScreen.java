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

	public int masterIndex = 0;

	List<Car> cars;
	List<House> houses;
	List<ScreenObject> index;

	public int getCar(){
		for(int i=0; i<index.size(); i++){
			index.get(i);
			if(index.get(i).getType().equals("Car")){
				return i;
			}
		}
		return -1;
	}
	public int getHouse(){
		for(int i=0; i<index.size(); i++){
			index.get(i);
			if(index.get(i).getType().equals("House")){
				return i;
			}
		}
		return -1;
	}
	
	public void start(Stage primaryStage) {

		// initialize list of cars and houses
		cars 	= new ArrayList<Car>();
		houses 	= new ArrayList<House>();
		index 	= new ArrayList<ScreenObject>();

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

		pane.getChildren().addAll(carButton, houseButton, deleteCarButton, deleteHouseButton,
				helpButton);

		masterIndex = pane.getChildren().size();

		// add new cars to the thingy
		carButton.setOnAction(event -> {

			//masterIndex++;

			Car car = new Car();
			//car.setIndex(masterIndex);
			cars.add(car);
			index.add(car);

			pane.getChildren().add(car.getShape());

		});

		// add new houses to the thingy
		houseButton.setOnAction(event -> {

			//masterIndex++;

			House house = new House();
			//house.setIndex(masterIndex);
			houses.add(house);
			index.add(house);

			pane.getChildren().add(house.getShape());

		});

		//currently delete either type of object indiscriminately. need to fix.
		deleteCarButton.setOnAction(event ->{
			if(cars.size() > 0) {
				pane.getChildren().remove(masterIndex+getCar());
				cars.remove(0);
				index.remove(getCar());
				//masterIndex--;
			}
		});

		deleteHouseButton.setOnAction(event->{
			if(houses.size() > 0){
				pane.getChildren().remove(masterIndex+getHouse());
				houses.remove(0);
				index.remove(getHouse());
				//masterIndex--;
			}
		});
		//helpButton needs to pop a dialog.
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