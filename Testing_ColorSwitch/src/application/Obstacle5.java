package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle5 extends ObstacleAbstract{

//	Group g1;
//	private float xPosition;
//	private float yPosition;
//	private float xPosition;
//	private float yPosition;
//	Arc a1=new Arc();
//	Arc a2=new Arc();
//	Arc a3=new Arc();
//	Arc a4=new Arc();
//	Circle c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16;
	ArrayList<Rectangle> rectangleList=new ArrayList<Rectangle>();
//	private float a=70;
	private Rectangle rect1,rect2,rect3,rect4,rect1_1,rect2_1,rect3_1,rect4_1;
	
	public ImageView iView1;
	public Obstacle5(float x,float y,String name)
	{
		xPosition=x-80;
		yPosition=y;
	
	}
	private Circle createCircle(double xPosition,double yPosition) {
		Circle circle = new Circle(); 
        circle.setCenterX(xPosition); 
	    circle.setCenterY(yPosition); 
	    circle.setRadius(a/4);
	    return circle;
	}
	public Group createObstacle()
	{
		
		int length=80;
		int breadth=20;
		double x=xPosition;
		double y=yPosition;
		rect1 = new Rectangle (x, y, length, breadth);
		rect2 = new Rectangle (x-breadth, y+breadth, breadth, length);
		rect3 = new Rectangle (x-length-breadth, y, length, breadth);
		rect4 = new Rectangle (x-breadth, y+breadth-length-breadth, breadth, length);
//		rectPath1.setArcHeight(100);
//		rectPath1.setArcWidth(10);
		rect1.setFill(Color.MEDIUMPURPLE);
		rect2.setFill(Color.DEEPPINK);
		rect3.setFill(Color.YELLOW);
		rect4.setFill(Color.TURQUOISE);
		
		
		int length1=80;
		int breadth1=20;
		x=xPosition+160+20;
		y=yPosition;
		rect4_1 = new Rectangle (x, y, length1, breadth);
		rect3_1 = new Rectangle (x-breadth, y+breadth, breadth, length1);
		rect2_1 = new Rectangle (x-length1-breadth, y, length1, breadth);
		rect1_1 = new Rectangle (x-breadth, y+breadth-length1-breadth, breadth, length);
//		rectPath1.setArcHeight(100);
//		rectPath1.setArcWidth(10);
		rect2_1.setFill(Color.MEDIUMPURPLE);
		rect3_1.setFill(Color.DEEPPINK);
		rect4_1.setFill(Color.YELLOW);
		rect1_1.setFill(Color.TURQUOISE);
		
		
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
		
		
		
		rectangleList.add(rect1);
		rectangleList.add(rect2);
		rectangleList.add(rect3);
		rectangleList.add(rect4);
		
		rotation(rect1);
		rotation(rect2);
		rotation(rect3);
		rotation(rect4);
		
		rectangleList.add(rect1_1);
		rectangleList.add(rect2_1);
		rectangleList.add(rect3_1);
		rectangleList.add(rect4_1);
		
		rotation1(rect1_1);
		rotation1(rect2_1);
		rotation1(rect3_1);
		rotation1(rect4_1);
		g1=new Group(rect1,rect2,rect3,rect4,rect1_1,rect2_1,rect3_1,rect4_1);
		return g1;
	}
	public void rotation(Rectangle rectangle ) {
		Rotate rotationTransform = new Rotate(0, xPosition-10, yPosition+10);
		rectangle.getTransforms().add(rotationTransform);
		rotateList.add(rotationTransform);
		Timeline rotationAnimation = new Timeline();
		rotationAnimation.getKeyFrames()
		  .add(
		    new KeyFrame(
		      Duration.seconds(5),
		      new KeyValue(
		        rotationTransform.angleProperty(),
		        360
		      )
		    )
		  );
		rotationAnimation.setCycleCount(Animation.INDEFINITE);
		rotationAnimation.play();
	}
	public void rotation1(Rectangle rectangle ) {
		Rotate rotationTransform = new Rotate(0, xPosition-10+160+20, yPosition+10);
		rectangle.getTransforms().add(rotationTransform);
		rotateList.add(rotationTransform);
		Timeline rotationAnimation = new Timeline();
		rotationAnimation.getKeyFrames()
		  .add(
		    new KeyFrame(
		      Duration.seconds(5),
		      new KeyValue(
		        rotationTransform.angleProperty(),
		        -360
		      )
		    )
		  );
		
		rotationAnimation.setCycleCount(Animation.INDEFINITE);
		rotationAnimation.play();
	}
	
	public void setYPosition(float value)
	{
		this.xPosition=value;
	}
	public void setXPosition(float value)
	{
		this.xPosition=value;
	}
	public double getYPosition()
	{
		return this.yPosition;
	}
	public double getXPosition()
	{
		return this.xPosition;
	}
	@Override
	public double getDistanceFromCentre(Ball b1) {
		return Math.abs(this.yPosition-b1.c1.getLayoutY());			
	}
	@Override
	public boolean isCollison(Ball b1) {
		// TODO Auto-generated method stub
		double a=getDistanceFromCentre(b1);
		if(a<=(20)) {
			return true;
		}

		return false;
	}
	@Override
	public Group getGroup() {
		// TODO Auto-generated method stub
		return g1;
	}
	@Override
	public Arc checkCollision(Ball b1) {
		if(rect1.getBoundsInParent().intersects(b1.c1.getBoundsInParent()) && isCollison(b1))
		{
			return a1;
		}
		else if(b1.c1.getBoundsInParent().intersects(rect2.getBoundsInParent()) && isCollison(b1))
		{
			return a2;
			
		}
		else if(b1.c1.getBoundsInParent().intersects(rect3.getBoundsInParent()) && isCollison(b1))
		{
			return a3;
			
		}
		else if(b1.c1.getBoundsInParent().intersects(rect4.getBoundsInParent()) && isCollison(b1))
		{
			return a4;
			
		}
		return null;
		
	}


}
