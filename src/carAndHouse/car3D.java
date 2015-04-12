package ThreeDimension;

import java.util.Random;

import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;


public class car3D extends Shape3D{
	
	PhongMaterial wheelMaterial = new PhongMaterial();
	PhongMaterial bodyMaterial = new PhongMaterial();
	
	Sphere wheel1 = new Sphere(30, 50);
	Sphere wheel2 = new Sphere(30, 50);
	Sphere wheel3 = new Sphere(30, 50);
	Sphere wheel4 = new Sphere(30, 50);
	
	Group car;
	Box body = new Box(200,100,100);
	
	TriangleMesh mesh = new TriangleMesh();
	
	public car3D()
	{
		wheelMaterial.setDiffuseColor(Color.BLACK);
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

		 wheel1.setMaterial(wheelMaterial);
		 wheel1.setTranslateX(100);
		 wheel1.setTranslateY(50);
		 wheel1.setTranslateZ(50);
		 
		 wheel2.setMaterial(wheelMaterial);
		 wheel2.setTranslateX(-50);
		 wheel2.setTranslateY(50);
		 wheel2.setTranslateZ(50);
		 
		 wheel3.setMaterial(wheelMaterial);
		 wheel3.setTranslateX(100);
		 wheel3.setTranslateX(50);
		 wheel3.setTranslateY(50);
		 wheel3.setTranslateZ(-50);
		 
		 wheel4.setMaterial(wheelMaterial);
		 wheel4.setTranslateX(100);
		 wheel4.setTranslateX(-50);
		 wheel4.setTranslateY(50);
		 wheel4.setTranslateZ(-50);
		 
		 //set color of body
		 body.setMaterial(bodyMaterial);
		 
		 car=new Group(body,wheel1,wheel2,wheel3,wheel4);
	}
	
	public Group getCar()
	{
		return car;
	}

	@Override
	protected NGNode impl_createPeer() {
		// TODO Auto-generated method stub
		return null;
	}
}
