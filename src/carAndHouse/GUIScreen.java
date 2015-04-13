package carAndHouse;

import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * UI Builder. Adds 3D cars and houses to the screen.
 * TODO: Fix object rotation
 * @author amalee, DooroftheTrog, juanvallejo
 */

public class GUIScreen extends Application {

	public final int SCREENWIDTH 	= 800;
	public final int SCREENHEIGHT 	= 600;

	public double mouseInitialX;
	public double mouseInitialY;

	public boolean dragHappened;

	List<ScreenObject> objects;

	/**
	 * Remove the first object of type "Car" found on the list
	 */
	public int getFirstElementInstance(List<ScreenObject> list, String element) {

		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getType().equals(element)){
				return i;
			}
		}

		return -1;

	}

	public void start(Stage stage) {

		// initialize variables
		objects 		= new ArrayList<ScreenObject>();

		mouseInitialX 	= 0.0;
		mouseInitialY 	= 0.0;

		dragHappened 	= false;

		// define 3D components
		Camera camera = new PerspectiveCamera();
		Group cameraGroup = new Group();

		// define camera initial rotation state.
		cameraGroup.getChildren().add(camera);
		cameraGroup.rotationAxisProperty().set(new Point3D(0, 0, 0));


		StackPane mainSceneLayout = new StackPane();
		mainSceneLayout.setPrefSize(800, 600);
		mainSceneLayout.setMinSize(800, 600);

		FlowPane buttonSceneLayout = new FlowPane(Orientation.VERTICAL);
		buttonSceneLayout.setStyle("-fx-background-color: transparent");

		FlowPane drawSceneLayout = new FlowPane(Orientation.VERTICAL);
		drawSceneLayout.setStyle("-fx-background-color: transparent");

		// create subscenes
		SubScene buttonScene = new SubScene(buttonSceneLayout, 800, 600);
		SubScene drawScene = new SubScene(drawSceneLayout, 800, 600);

		// create subscene components
		Button carButton 			= new Button("Car");
		Button houseButton 			= new Button("House");
		Button deleteCarButton 		= new Button("Delete Car");
		Button deleteHouseButton 	= new Button("Delete House");
		Button helpButton			= new Button("Help");

		// set subscene properties
		drawScene.setCamera(camera);

		buttonScene.setOnMouseDragged(me -> {

			dragHappened = true;
			
			cameraGroup.translateYProperty().set(((me.getY()-mouseInitialY)*10) );
			cameraGroup.translateXProperty().set(((me.getX()-mouseInitialX)*10));

			//cameraGroup.translateZProperty().set((cameraGroup.getTranslateZ() - ((me.getY() - mouseInitialY) * 0.25)));
			//cameraGroup.rotateProperty().set(cameraGroup.rotateProperty().get() + ((me.getX() - mouseInitialX) * 20));

		});

		buttonScene.setOnMousePressed(me -> {
			mouseInitialX = me.getX();
			mouseInitialY = me.getY();
		});

		// add mouse events
		buttonScene.setOnMouseReleased(me -> {

			if(dragHappened) {
				dragHappened = false;
				return;
			}

		});

		// add new cars to the pane
		carButton.setOnAction(event -> {

				car3D car = new car3D();
				objects.add(car);

				drawSceneLayout.getChildren().add(car.getShape());

		});

		// add new houses to the pane
		houseButton.setOnAction(event -> {

			house3D house = new house3D();
			objects.add(house);

			drawSceneLayout.getChildren().add(house.getShape());

		});

		// delets the fist car on the object's list / from the screen
		deleteCarButton.setOnAction(event -> {
			
			int elementIndex = getFirstElementInstance(objects, "Car");

			if(objects.size() > 0 && elementIndex != -1) {
				drawSceneLayout.getChildren().remove(elementIndex);
				objects.remove(elementIndex);
			}

		});

		// delets the fist house on the object's list / from the screen
		deleteHouseButton.setOnAction(event->{
				
			int elementIndex = getFirstElementInstance(objects, "House");

			if(objects.size() > 0 && elementIndex != -1) {
				drawSceneLayout.getChildren().remove(elementIndex);
				objects.remove(elementIndex);
			}

		});

		helpButton.setOnAction(event -> {

			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(stage);

			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren().add(

				new Text("Help\nYou can add new cars with the 'Car'"
            	+ " button, and add\n new houses with the 'House' button. The oldest house\n"
            	+ " or car will be deleted when you select 'Delete House'\n or 'Delete Car'"
            	+ " respectively. Click and drag the screen\n to rotate the camera. Camera"
            	+ " will move opposite\n the direction of your mouse (ie up mouse = further\n"
            	+ " away, down mouse = closer, right mouse = left, etc.)"
            	
			));

			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.show();

		});

		// add children to the button scene layout
		buttonSceneLayout.getChildren().addAll(carButton, houseButton, deleteCarButton, deleteHouseButton, helpButton);

		// add children to the main scene layout
		mainSceneLayout.getChildren().addAll(drawScene, buttonScene);

		// define main scene
		Scene scene = new Scene(mainSceneLayout, 800, 600);

		stage.setScene(scene);
		stage.setTitle("Car And House");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}