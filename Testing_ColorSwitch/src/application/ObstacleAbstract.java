package application;

import java.io.Serializable;
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
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public abstract class ObstacleAbstract implements Serializable{
	protected double xPosition;
	protected double yPosition;
	protected Group g1;
	Circle c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16;
	Rotate r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;
	int r=500;
	int l=70;
	int l1=40;
	float a=70;
//	private double xPosition;
//	private double yPosition;
	public ImageView iView1;
	public String nameString;
	protected Arc a1,a2,a3,a4;
	public ArrayList<Arc> arcList=new ArrayList<Arc>();
	public ArrayList<Circle> circleList=new ArrayList<Circle>();
	public ArrayList<Rotate> rotateList=new ArrayList<Rotate>();
	public abstract Group createObstacle();
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
	public abstract boolean isCollison(Ball b1) ;
	public abstract Group getGroup();

	public abstract Arc checkCollision(Ball b1) ;
	
	

}
