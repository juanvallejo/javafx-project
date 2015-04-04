package carAndHouse;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIScreen extends Application {
	public void start(Stage primaryStage) {
		// Buttons do not expand past their natural size
		BorderPane pane = new BorderPane();
		pane.setLeft(new Button("Car"));
		pane.setRight(new Button("House"));
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
