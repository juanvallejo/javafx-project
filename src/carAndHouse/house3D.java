package  carAndHouse;

import java.util.Random;

import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;

/**
 * @author Juan Vallejo
 * @author Amanda Lee
 * @author Ian Miller
 */

public class house3D extends Shape3D implements ScreenObject {

	final public static int DEFAULT_SHAPE_SIZE = 200;

	PhongMaterial roofMaterial = new PhongMaterial();
	PhongMaterial bodyMaterial = new PhongMaterial();
	
	Group house;
	Box body = new Box(200,200,200);
	Box window1 = new Box(40,40,5);
	Box window2 = new Box(40,40,5);
	
	TriangleMesh roofMesh = new TriangleMesh();
	MeshView roof;
	public house3D()
	{
		roofMaterial.setDiffuseColor(Color.BROWN);
		//create the roof
		roofMesh.getPoints().addAll(
				0,0,0,
				0,100,-200,
				-200,100,0,
				200,100,0,
				0,100,200
				);
		
		roofMesh.getFaces().addAll(
		        0,0,  2,0,  1,0,          // Front left face
		        0,0,  1,0,  3,0,          // Front right face
		        0,0,  3,0,  4,0,          // Back right face
		        0,0,  4,0,  2,0,          // Back left face
		        4,0,  1,0,  2,0,          // Bottom rear face
		        4,0,  3,0,  1,0           // Bottom front face
		    ); 
		roofMesh.getTexCoords().addAll(0, 0);
		roof = new MeshView(roofMesh);
		roof.setTranslateY(-200);
		roof.setDrawMode(DrawMode.FILL);
		roof.setMaterial(roofMaterial);
		
		window1.setTranslateZ(100);
		window1.setMaterial(roofMaterial);
		
		window2.setTranslateZ(-100);
		window2.setMaterial(roofMaterial);
		
		Random rand = new Random();
		int colorSelect = rand.nextInt(5);
		switch(colorSelect)
		{
		case 0: bodyMaterial.setDiffuseColor(Color.RED);
				break;
		case 1: bodyMaterial.setDiffuseColor(Color.PURPLE);
				break;
		case 2: bodyMaterial.setDiffuseColor(Color.CRIMSON);
				break;
		case 3: bodyMaterial.setDiffuseColor(Color.GREEN);
				break;
		case 4: bodyMaterial.setDiffuseColor(Color.BLUE);
				break;
		}
		 //set color of body
		 body.setMaterial(bodyMaterial);
		 
		 house=new Group(body,roof,window1,window2);
	}
	
	public Group getShape()
	{
		return house;
	}

	@Override
	protected NGNode impl_createPeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "House";
	}
}
