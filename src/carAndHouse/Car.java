package carAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * A Car
 */
public class Car {

	private int masterIndex;

	public Car() {
		masterIndex = 0;
	}

	public Shape getShape(){
		Circle	circle = new Circle();
		circle.setFill(Color.BLUE);
		circle.setRadius(10);
		return circle;
	}
	public String getType(){
		return "Car";
	}
}
