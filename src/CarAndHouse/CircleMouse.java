package CarAndHouse;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleMouse extends Application {

	@Override
	public void start(Stage primaryStage) {

		Circle circle = new Circle();
		circle.setFill(Color.BLUE);

		// declare group of objects
		Group root = new Group(circle);

		// declare scene
		Scene scene = new Scene(root, 800, 600);

		// Bind means "depends on", not "determines"
		circle.radiusProperty().bind(
				Bindings.divide(scene.heightProperty(), 16)
		);

		circle.centerXProperty().set(scene.heightProperty().get()/2);
		circle.centerYProperty().set(scene.widthProperty().get()/2);
		
		scene.setOnMouseDragged((mouse) -> {
			// circle.centerXProperty().set(mouse.getX());
			// circle.centerYProperty().set(mouse.getY());
			root.getChildren().add(circle);
		});

		primaryStage.setScene(scene);
		primaryStage.setTitle("Look it's a baaaaaaaaall");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
