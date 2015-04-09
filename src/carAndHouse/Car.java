package carAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Car {
	Car(){
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
