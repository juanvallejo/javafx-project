package CarAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * A Car
 */

public class Car {

	public Car() {

		Circle	circle = new Circle();
		circle.setFill(Color.BLUE);
		circle.setRadius(10);
		
	}
	public Circle getShape(){
		Circle	circle = new Circle();
		circle.setFill(Color.BLUE);
		circle.setRadius(10);
		return circle;
	}
}
