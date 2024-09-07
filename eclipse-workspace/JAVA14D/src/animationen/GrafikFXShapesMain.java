package animationen;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GrafikFXShapesMain extends Application{
	@Override
	public void start(Stage meineStage) throws Exception {
		FlowPane rootNode = new FlowPane();
	
		Scene meineScene = new Scene(rootNode, 400, 400);
		
		meineStage.setTitle("Einfache Grafiken mit Shapes");
		meineStage.setScene(meineScene);

		Rectangle rechteck = new Rectangle(100, 100);
		rechteck.setStroke(Color.RED);
		rechteck.setStrokeWidth(10);
		rechteck.setFill(Color.BLUE);
		
		Circle kreis= new Circle(100);
		kreis.setStroke(Color.YELLOW);
		kreis.setStrokeWidth(3);
		
		rootNode.getChildren().add(rechteck);
		rootNode.getChildren().add(kreis);
		
		ScaleTransition zoom = new ScaleTransition(Duration.millis(10000), rechteck);
		zoom.setByY(2);
		zoom.setCycleCount(5);
		zoom.setAutoReverse(true);
		zoom.play(); 
		
		Box wuerfel = new Box (100, 100, 100);
		wuerfel.setRotationAxis(new Point3D(90,90,0));
		wuerfel.setRotate(45);
		
		Sphere kugel = new Sphere(100);
		
		rootNode.getChildren().add(wuerfel);
		rootNode.getChildren().add(kugel);

		meineStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
