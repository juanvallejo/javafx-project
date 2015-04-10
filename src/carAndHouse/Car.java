package carAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * A Car
 */
public class Car implements ScreenObject{

	private int masterIndex;

	public Car() {
		masterIndex = 0;
	}

	public Circle getShape(){
		Circle	circle = new Circle();
		circle.setFill(Color.BLUE);
		circle.setRadius(10);
		return circle;
	}
	public String getType(){
		return "Car";
	}
}
