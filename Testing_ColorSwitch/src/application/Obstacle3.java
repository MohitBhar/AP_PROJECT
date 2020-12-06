package application;

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
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle3 extends ObstacleAbstract{

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
	
//	private float a=70;
	
	public ImageView iView1;
	public Obstacle3(float x,float y,String name)
	{
		xPosition=x;
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
	
		double root2=Math.sqrt(2);
		c1=createCircle(xPosition-a/4,yPosition+(a/2)*(1+root2));
		c1.setFill(Color.MEDIUMPURPLE);
		
		
		c2=createCircle(xPosition+a/4,yPosition+(a/2)*(1+root2));
		c2.setFill(Color.MEDIUMPURPLE);
		c3=createCircle(xPosition+(a/2)*(1+(3*root2)/4),yPosition+(a/2)*(1+(root2)/4));
		c3.setFill(Color.MEDIUMPURPLE);
		c4=createCircle(xPosition+(a/2)*(1+(root2)/4),yPosition+(a/2)*(1+(3*root2)/4));
		c4.setFill(Color.MEDIUMPURPLE);
		
		c5=createCircle(xPosition+(a/2)*(1+root2),yPosition+a/4);
		c5.setFill(Color.DEEPPINK);
		c6=createCircle(xPosition+(a/2)*(1+root2),yPosition-a/4);
		c6.setFill(Color.DEEPPINK);
		c7=createCircle(xPosition+(a/2)*(1+(3*root2)/4),yPosition-(a/2)*(1+(root2)/4));
		c7.setFill(Color.DEEPPINK);
		c8=createCircle(xPosition+(a/2)*(1+(root2)/4),yPosition-(a/2)*(1+(3*root2)/4));
		c8.setFill(Color.DEEPPINK);
		
		
		c9=createCircle(xPosition-a/4,yPosition-(a/2)*(1+root2));
		c9.setFill(Color.YELLOW);
		c10=createCircle(xPosition+a/4,yPosition-(a/2)*(1+root2));
		c10.setFill(Color.YELLOW);
		c11=createCircle(xPosition-(a/2)*(1+(3*root2)/4),yPosition-(a/2)*(1+(root2)/4));
		c11.setFill(Color.YELLOW);
		c12=createCircle(xPosition-(a/2)*(1+(root2)/4),yPosition-(a/2)*(1+(3*root2)/4));
		c12.setFill(Color.YELLOW);
		c15=createCircle(xPosition-(a/2)*(1+(3*root2)/4),yPosition+(a/2)*(1+(root2)/4));
		c15.setFill(Color.TURQUOISE);
		c16=createCircle(xPosition-(a/2)*(1+(root2)/4),yPosition+(a/2)*(1+(3*root2)/4));
		c16.setFill(Color.TURQUOISE);
		
		c13=createCircle(xPosition-(a/2)*(1+root2),yPosition+a/4);
		c13.setFill(Color.TURQUOISE);
		c14=createCircle(xPosition-(a/2)*(1+root2),yPosition-a/4);
		c14.setFill(Color.TURQUOISE);
		
		circleList.add(c1);
		circleList.add(c2);
		circleList.add(c3);
		circleList.add(c4);
		circleList.add(c5);
		circleList.add(c6);
		circleList.add(c7);
		circleList.add(c8);
		circleList.add(c9);
		circleList.add(c10);
		circleList.add(c11);
		circleList.add(c12);
		circleList.add(c13);
		circleList.add(c14);
		circleList.add(c15);
		circleList.add(c16);
		rotation(c16);
		rotation(c15);
		rotation(c14);
		rotation(c13);
		rotation(c12);
		rotation(c11);
		rotation(c10);
		rotation(c9);
		rotation(c8);
		rotation(c7);
		rotation(c6);
		rotation(c5);
		rotation(c4);
		rotation(c3);
		rotation(c2);
		rotation(c1);
//		Circle c3=createCircle(xPosition-a/4,yPosition-3*(a/2));
//		Circle c4=createCircle(xPosition+a/4,yPosition-3*(a/2));
		g1=new Group(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c15,c16,c11,c12,c13,c14);
		return g1;
	}
	public void rotation(Circle c1) {
		Rotate rotationTransform = new Rotate(0, xPosition, yPosition);
		c1.getTransforms().add(rotationTransform);
		rotateList.add(rotationTransform);
//		rotationTransform.setAngle(arg0);
//		rotationTransform.setPivotX(arg0);
		// rotate a square using timeline attached to the rotation transform's angle property.
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
	public boolean isCollison(Ball b1) {
		// TODO Auto-generated method stub
		double a=getDistanceFromCentre(b1);
		if(a<=(95+12) && a>=(85-25)) {
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
		for(int i=0;i<circleList.size();i++) {
			Circle c1=circleList.get(i);
			if(c1.getBoundsInParent().intersects(b1.c1.getBoundsInParent()) && isCollison(b1))
			{
				if(i<4) {
					return a1;
				}
				else if(i>=4&&i<8) {
					return a2;
				}
				else if(i>=12) {
					return a4;
				}
				else if(i>=8&&i<12) {
					return a3;
				}
			}
		}
		return null;
		
	}


}
