package javaFX;

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
		Group root = new Group(circle);
		Scene scene = new Scene(root, 800, 600);
		// Bind means "depends on", not "determines"
		circle.radiusProperty().bind(
				Bindings.divide(scene.heightProperty(), 16));
		circle.centerXProperty().set(scene.heightProperty().get()/2);
		circle.centerYProperty().set(scene.widthProperty().get()/2);
		
		scene.setOnMouseDragged((me) -> {
			circle.centerXProperty().set(me.getX());
			circle.centerYProperty().set(me.getY());
		});
		primaryStage.setScene(scene);
		primaryStage.setTitle("Shipping / Billing");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
