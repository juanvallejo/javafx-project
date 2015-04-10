package carAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * A Car
 */
public class Car {

	private int masterIndex;

	public Car() {
		masterIndex = 0;
	}

	public void setIndex(int index) {
		masterIndex = index;
	}

	public int getIndex() {
		return masterIndex;
	}

	public Circle getShape(){
		Circle	circle = new Circle();
		circle.setFill(Color.BLUE);
		circle.setRadius(10);
		return circle;
	}
}
