package carAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;;

public class House {
	House(){
		Rectangle	rect = new Rectangle();
		rect.setFill(Color.RED);
		rect.setHeight(5);
		rect.setWidth(10);
	}
	public Rectangle getShape(){
		Rectangle	rect = new Rectangle();
		rect.setFill(Color.RED);
		rect.setHeight(5);
		rect.setWidth(10);
		return rect;
	}
}
