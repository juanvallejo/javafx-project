package ThreeDimension;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CarAndHouse extends Application
{
	public static final int SCREENWIDTH = 800;
	public static final int SCREENHEIGHT = 600;
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		car3D car1 = new car3D();
		Group group1 = car1.getCar();

		Camera camera = new PerspectiveCamera();
		Group cameraGroup = new Group();
		// getChildren() is a List
		cameraGroup.getChildren().add(camera);
		group1.getChildren().add(cameraGroup);
		//group2.getChildren().add(cameraGroup);
		//group3.getChildren().add(cameraGroup);
		cameraGroup.setTranslateX(-SCREENWIDTH/2);
		cameraGroup.setTranslateY(-SCREENHEIGHT);
		cameraGroup.setTranslateZ(-1000);
		// For rotating, later
		cameraGroup.rotationAxisProperty().set(new Point3D(0, 1, 0));

		// Scene
		Scene scene = new Scene(group1, SCREENWIDTH, SCREENHEIGHT);
		scene.setCamera(camera);
		primaryStage.setTitle("Car");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		group1.setMouseTransparent(true);
		scene.setOnMouseDragged(me -> {
			cameraGroup.translateZProperty().set(-1000 - (me.getY()*10) );
			cameraGroup.rotateProperty().set((SCREENWIDTH/8 - (me.getX())/20));
		});
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
