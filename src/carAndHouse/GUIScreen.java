package carAndHouse;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIScreen extends Application {

	public static final int SCREENWIDTH = 800;
	public static final int SCREENHEIGHT = 600;
	public int masterIndex = 0;

	List<car3D> cars;
	List<house3D> houses;
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
		cars 	= new ArrayList<car3D>();
		houses 	= new ArrayList<house3D>();
		index 	= new ArrayList<ScreenObject>();

		// Buttons do not expand past their natural size
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		FlowPane sub  = new FlowPane(Orientation.VERTICAL);
		pane.setColumnHalignment(HPos.LEFT);
		pane.setMinSize(SCREENWIDTH, SCREENHEIGHT);
		Camera camera = new PerspectiveCamera();
		Group cameraGroup = new Group();
		// getChildren() is a List
		cameraGroup.getChildren().add(camera);
		cameraGroup.setTranslateX(-SCREENWIDTH/2);
		cameraGroup.setTranslateY(-SCREENHEIGHT);
		cameraGroup.setTranslateZ(-1000);
		// For rotating, later
		cameraGroup.rotationAxisProperty().set(new Point3D(0, 1, 0));

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

			car3D car = new car3D();
			//car.setIndex(masterIndex);
			cars.add(car);
			index.add(car);

			pane.getChildren().add(car.getShape());

		});

		// add new houses to the pane
		houseButton.setOnAction(event -> {

			//masterIndex++;

			house3D house = new house3D();
			//house.setIndex(masterIndex);
			houses.add(house);
			index.add(house);

			pane.getChildren().add(house.getShape());

		});

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
		helpButton.setOnAction(event -> {

			final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(primaryStage);
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("Help\nYou can add new cars with the 'Car'"
            		+ " button, and add\n new houses with the 'House' button. The oldest house\n"
            		+ " or car will be deleted when you select 'Delete House'\n or 'Delete Car'"
            		+ " respectively. Click and drag the screen\n to rotate the camera. Camera"
            		+ " will move opposite\n the direction of your mouse (ie up mouse = down \n"
            		+ " camera.)"));
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();

		});
		Group root = new Group(pane);
		Scene scene = new Scene(root, SCREENWIDTH, SCREENHEIGHT);
		SubScene scene2 = new SubScene(sub, SCREENWIDTH,SCREENHEIGHT);
		sub.setMouseTransparent(true);

		scene2.setCamera(camera);
		scene2.setOnMouseDragged(me -> {
			cameraGroup.translateZProperty().set(-1000 - (me.getY()*10) );
			cameraGroup.rotateProperty().set((SCREENWIDTH/8 - (me.getX())/20));
		});

		//helpButton needs to pop a dialog.

		//Stage secondaryStage=new Stage();
		//secondaryStage.setScene(scene2);
		//secondaryStage.show();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Car and House");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
