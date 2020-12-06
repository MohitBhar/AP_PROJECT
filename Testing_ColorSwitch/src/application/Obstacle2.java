package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class Obstacle2 extends ObstacleAbstract{
	// TO DEFINE RADIUS FIELD
//	private Group g1;
////	private double xPosition;
////	private double yPosition;
//	public ImageView iView1;
//	public String nameString;
//	private Arc a1,a2,a3,a4;
//	public ArrayList<Arc> arcList=new ArrayList<Arc>();

	public Obstacle2(float x, float y,String name)
	{
		this.xPosition=x;
		this.yPosition=y;
		this.nameString=name;
	}
	public Group createObstacle()
	{
		a1=new Arc();
		a1.setCenterX(xPosition); 
		a1.setCenterY(yPosition); 
		a1.setRadiusX(90); 
		a1.setRadiusY(90); 
		a1.setStartAngle(0); 
		a1.setLength(90);
		a1.setFill(null);
		a1.setStrokeWidth(10);		
		a1.setType(ArcType.CHORD);
		a1.setStroke(Color.MEDIUMPURPLE);
		arcList.add(a1);
		a2=new Arc();
		a2.setCenterX(xPosition); 
		a2.setCenterY(yPosition); 
		a2.setRadiusX(90); 
		a2.setRadiusY(90); 
		a2.setStartAngle(90); 
		a2.setLength(90);
		a2.setFill(null);
		a2.setStrokeWidth(10);
		a2.setType(ArcType.CHORD);
		a2.setStroke(Color.DEEPPINK);
		
		arcList.add(a2);
		a3=new Arc();
		a3.setCenterX(xPosition); 
		a3.setCenterY(yPosition); 
		a3.setRadiusX(90); 
		a3.setRadiusY(90); 
		a3.setStartAngle(180); 
		a3.setLength(90);
		a3.setFill(null);
		a3.setStrokeWidth(10);
		a3.setType(ArcType.CHORD);
		a3.setStroke(Color.YELLOW);
		arcList.add(a3);
	
		a4=new Arc();
		a4.setCenterX(xPosition); 
		a4.setCenterY(yPosition); 
		a4.setRadiusX(90); 
		a4.setRadiusY(90); 
		a4.setStartAngle(270); 
		a4.setLength(90); 
		a4.setFill(null);
		a4.setStrokeWidth(10);
		a4.setType(ArcType.CHORD);
		a4.setStroke(Color.TURQUOISE);
		arcList.add(a4);
		rotation(a4);
		rotation(a3);
		rotation(a2);
		rotation(a1);
		
		this.g1=new Group(a1,a2,a3,a4);
		return g1;
	}
	
	public double getDistanceFromCentre(Ball b1) {
	//System.out.println(this.yPosition-b1.getYPosition()+","+this.yPosition+","+b1.getYPosition()+"name: "+this.nameString);
		return Math.abs(this.yPosition-b1.c1.getLayoutY());
		
	}
	public boolean isCollison(Ball b1) {
		double a=getDistanceFromCentre(b1);
		if(a<=95 && a>=(85-28)) {
			return true;
		}
		return false;
	}
	public void rotation(Arc a4) {
		Timeline arcAnimation3 = new Timeline(
	            new KeyFrame(Duration.ZERO, new KeyValue(a4.startAngleProperty(), a4.getStartAngle(), Interpolator.LINEAR)),
	            new KeyFrame(Duration.seconds(3), new KeyValue(a4.startAngleProperty(), a4.getStartAngle() - 360, Interpolator.LINEAR))
	        );
	        arcAnimation3.setCycleCount(Animation.INDEFINITE);
	        arcAnimation3.play();
	
	
	}
	public Group getGroup()
	{
		return this.g1;
	}
	public Arc checkCollision(Ball b1) {
		if(a1.getBoundsInParent().intersects(b1.c1.getBoundsInParent()) && isCollison(b1))
		{
			return a1;
		}
		else if(b1.c1.getBoundsInParent().intersects(a2.getBoundsInParent()) && isCollison(b1))
		{
			return a2;
			
		}
		else if(b1.c1.getBoundsInParent().intersects(a3.getBoundsInParent()) && isCollison(b1))
		{
			return a3;
			
		}
		else if(b1.c1.getBoundsInParent().intersects(a4.getBoundsInParent()) && isCollison(b1))
		{
			return a4;
			
		}
		return null;
	}
	
	
}
