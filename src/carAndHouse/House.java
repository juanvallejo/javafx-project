package carAndHouse;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;;

public class House implements ScreenObject {

	/**
	 * index of object in thingy
	 */
	private int masterIndex;

	House() {
		masterIndex = 0;
	}

	/**
	 * Sets the index of the object on the thingy
	 */

	public Rectangle getShape(){
		Rectangle	rect = new Rectangle();
		rect.setFill(Color.RED);
		rect.setHeight(5);
		rect.setWidth(10);
		return rect;
	}
	public String getType(){
		return "House";
	}
}
