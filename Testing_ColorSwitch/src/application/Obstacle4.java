package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle4 extends ObstacleAbstract{
	
//	protected double xPosition;
//	protected double yPosition;
//	protected Group g1;
//	Circle c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16;
//	Rotate r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;
//	
//	float a=70;
//	private double xPosition;
//	private double yPosition;
//	public ImageView iView1;
//	public String nameString;
//	protected Arc a1,a2,a3,a4;
//	public ArrayList<Arc> arcList=new ArrayList<Arc>();
//	public ArrayList<Circle> circleList=new ArrayList<Circle>();
	public ArrayList<PathTransition> pathList=new ArrayList<PathTransition>();
//	
	
	public ImageView iView1;
	public Obstacle4(float x,float y,String name)
	{
		xPosition=x;
		yPosition=y;
		
	
	}
	private Circle createCircle(double radius) {
		Circle circle = new Circle(); 
//        circle.setCenterX(xPosition); 
//	    circle.setCenterY(yPosition); 
	    circle.setRadius(radius);
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
//		arcList.add(a1);
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
		
//		arcList.add(a2);
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
//		arcList.add(a3);
	
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
//		arcList.add(a4);

	
		double root2=Math.sqrt(2);
//		c1=createCircle(l/4+20);
//		c1.setFill(Color.MEDIUMPURPLE);
		
		c2=createCircle(l/4);
		c2.setFill(Color.DEEPPINK);
		c3=createCircle(l/4);
		c3.setFill(Color.DEEPPINK);
		c4=createCircle(l/4);
		c4.setFill(Color.DEEPPINK);
		
		c5=createCircle(l/4);
		c5.setFill(Color.YELLOW);
		c6=createCircle(l/4);
		c6.setFill(Color.YELLOW);
		c7=createCircle(l/4);
		c7.setFill(Color.YELLOW);
		
		c8=createCircle(l/4);
		c8.setFill(Color.MEDIUMPURPLE);
		c9=createCircle(l/4);
		c9.setFill(Color.MEDIUMPURPLE);
		c10=createCircle(l/4);
		c10.setFill(Color.MEDIUMPURPLE);
		
		c11=createCircle(l/4);
		c11.setFill(Color.TURQUOISE);
		c12=createCircle(l/4);
		c12.setFill(Color.TURQUOISE);
		c13=createCircle(l/4);
		c13.setFill(Color.TURQUOISE);
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
		int increment=0;
//		rotation(c1,0);
//		increment=6;
		double x=6;
		rotation(c2,x);
		double d=3.8;//l=70
//		double d=5.42;//l=100
		
		rotation(c3,x+d);
		rotation(c4,x+2*d);
		rotation(c5,x+3*d);
		rotation(c6,x+4*d);
		rotation(c7,x+5*d);
		rotation(c8,x+6*d);
		rotation(c9,x+7*d);
		rotation(c10,x+8*d);
		rotation(c11,x+9*d);
		rotation(c12,x+10*d);
		rotation(c13,x+11*d);
		
//		Circle c3=createCircle(xPosition-a/4,yPosition-3*(a/2));
//		Circle c4=createCircle(xPosition+a/4,yPosition-3*(a/2));
//		g1=new Group(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c15,c16,c11,c12,c13,c14);
		g1=new Group(c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13);
		return g1;
	}
	public void rotation(Circle c,double increment) {
		Arc a11=new Arc();
//		Arc a2=new Arc();
//		int xPosition=380;
//		int yPosition=380;
//		
		int x=20;
		x=x+25;
		int r=500;
		a11.setCenterX(xPosition); 
		a11.setCenterY(yPosition); 
		a11.setRadiusX(r); 
		a11.setRadiusY(r); 
		a11.setStartAngle(180+x+increment); 
		
		a11.setLength(l1);
		a11.setFill(null);
		a11.setStrokeWidth(10);		
		a11.setType(ArcType.OPEN);
		a11.setStroke(Color.MEDIUMPURPLE);
		arcList.add(a11);
		PathTransition trans = new PathTransition(Duration.seconds(10), a11, c);

		pathList.add(trans);
		trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		// Let the animation run forever
		trans.setCycleCount(FadeTransition.INDEFINITE);
		// Reverse direction on alternating cycles
//		trans.setAutoReverse(false);
		// Play the Animation
		trans.play();
	

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
		if(a<=(500+25) && a>=(500-25)) {
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
				if(i<3) {
					return a2;
				}
				else if(i>=3&&i<6) {
					return a3;
				}
				else if(i>=9) {
					return a4;
				}
				else if(i>=6&&i<9) {
					return a1;
				}
			}
		}
		return null;
		
	}



}




