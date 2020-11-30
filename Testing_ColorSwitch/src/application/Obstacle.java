package application;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Obstacle {
	// TO DEFINE RADIUS FIELD
	private Group g1;
	private double xPosition;
	private double yPosition;
	public ImageView iView1;
	public String nameString;
	private Arc a1,a2,a3,a4;
	public ArrayList<Arc> arcList=new ArrayList<Arc>();

	public Obstacle(float x, float y,String name)
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
		a1.setType(ArcType.OPEN);
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
		a2.setType(ArcType.OPEN);
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
		a3.setType(ArcType.OPEN);
		a3.setStroke(Color.YELLOW);
		arcList.add(a3);
		a4=new Arc();
		a4.setCenterX(xPosition); 
		a4.setCenterY(yPosition); 
		a4.setRadiusX(90); 
		a4.setRadiusY(90); 
		a4.setStartAngle(270); 
		a4.setFill(null);
		a4.setLength(90); 
		a4.setStrokeWidth(10);
		a4.setType(ArcType.OPEN);
		a4.setStroke(Color.TURQUOISE);
		arcList.add(a4);
		this.g1=new Group(a1,a2,a3,a4);
		return g1;
	}
	public void setYPosition(double value)
	{
		this.yPosition=value;
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
	public double getDistanceFromCentre(Ball b1) {
	//System.out.println(this.yPosition-b1.getYPosition()+","+this.yPosition+","+b1.getYPosition()+"name: "+this.nameString);
		return Math.abs(this.yPosition-b1.c1.getLayoutY());
		
	}
	public boolean isCollison(Ball b1) {
		double a=getDistanceFromCentre(b1);
		if(a<=95 && a>=85) {
			return true;
		}
		return false;
	}
	public Group getGroup()
	{
		return this.g1;
	}
	public boolean checkCollision(Ball b1) {
		boolean a= false;
		if(!b1.c1.getFill().toString().equals(a1.getStroke().toString())){
			if(isCollison(b1)) {
//				System.out.println("t1----------------");

			}
		}
		else {
			if(isCollison(b1)) {
				System.out.println("perfect t1");
				return true;
			}
			
		}
//		else {
//			a=true;
//		}
		if(!b1.c1.getFill().toString().equals(a2.getStroke().toString())){
			if(isCollison(b1)) {
//				System.out.println("t2----------------");
			}
		}
		else {
			if(isCollison(b1)) {
				System.out.println("perfect t2");
				return true;
			}
		}
		if(!b1.c1.getFill().toString().equals(a3.getStroke().toString())){
			if(isCollison(b1)) {
//				System.out.println("t3----------------");
			}
		}
		else {
			if(isCollison(b1)) {
				System.out.println("perfect t3");
				return true;
			}
		}
		if(!b1.c1.getFill().toString().equals(a4.getStroke().toString())){
			if(isCollison(b1)) {
//				System.out.println("t4----------------");
			}
		}
		else {
			if(isCollison(b1)) {
				System.out.println("perfect t4");
				return true;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		boolean a=false; for multiple collisons
//		System.out.println("ball "+b1.c1.getFill().toString());
//		System.out.println("a1 "+a1.getStroke().toString());
//		System.out.println("a2 "+a2.getStroke().toString());
//		System.out.println("a3 "+a3.getStroke().toString());
//		System.out.println("a4 "+a4.getStroke().toString());
//		
		
//			if(b1.c1.getFill().toString().equals(a1.getStroke().toString())) {
//		System.out.println("1-----------"+b1.c1.getFill().toString()+":"+a1.getStroke().toString());
//		return true;
//	}
//	else if(b1.c1.getFill().toString().equals(a2.getStroke().toString())) {
//		System.out.println("2-----------"+b1.c1.getFill().toString()+":"+a2.getStroke().toString());
//		return true;
//	}
//	else if(b1.c1.getFill().toString().equals(a3.getStroke().toString())) {
//		System.out.println("3-----------"+b1.c1.getFill().toString()+":"+a3.getStroke().toString());
//		return true;
//	}
//	else if(b1.c1.getFill().toString().equals(a4.getStroke().toString())) {
//		System.out.println("4-----------"+b1.c1.getFill().toString()+":"+a4.getStroke().toString());
//		return true;
//	}
//			System.out.println("TRial1: "+b1.getColor().toString()+":"+a1.getStroke().toString());
//			if(b1.getColor().toString().equals(a1.getStroke().toString())) {
//				System.out.println("1-----------");
//				return true;
//			}
//		}
//		if(b1.c1.getBoundsInParent().intersects(a2.getBoundsInParent())){
//			System.out.println("TRial2: "+b1.getColor().toString()+":"+a2.getStroke().toString());
//			if(b1.getColor().toString().equals(a2.getStroke().toString())) {
//				System.out.println("2-----------");
//				return true;
//			}
//		}
//		if(b1.c1.getBoundsInParent().intersects(a3.getBoundsInParent())){
//			System.out.println("TRial3: "+b1.getColor().toString()+":"+a3.getStroke().toString());
//			if(b1.getColor().toString().equals(a3.getStroke().toString())) {
//				System.out.println("3-----------");
//				return true;
//			}
//		}
//		if(b1.c1.getBoundsInParent().intersects(a4.getBoundsInParent())){
//			System.out.println("TRial4: "+b1.getColor().toString()+":"+a4.getStroke().toString());
//			if(b1.getColor().toString().equals(a4.getStroke().toString())) {
//				System.out.println("1-----------");
//				return true;
//			}
//		}
		return false;
	}
}
