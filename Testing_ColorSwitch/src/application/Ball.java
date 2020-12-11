package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball implements Serializable{
	ArrayList<Color> color;
	private float radius;
	private Color color2;
//	private Color ball_Color;
	public Circle c1;
	private float xPostion;
	private float yPosition;
	public Ball()
	{
		color=new ArrayList<Color>();
		color.add(Color.MEDIUMPURPLE);
		color.add(Color.TURQUOISE);
		color.add(Color.YELLOW);
		color.add(Color.DEEPPINK);
	}
//	@Override
//	public String toString() {
//		color
//	}
	public Circle createBall()
	{	this.color2=selectColor();
		
		Circle c1=new Circle(10,color2);
		this.radius=15;
		this.c1=c1;
		c1.setLayoutX(xPostion);
		c1.setLayoutY(yPosition);
		return c1;
	}
	public Color selectColor()
	{
		Random r1=new Random();
		int a=r1.nextInt(4);
		color2=color.get(a);
				
		return color.get(a);
	}
	public Color getColor() {
		return this.color2;
	}
	
	public float getXPosition()
	{
		return this.xPostion;
	}
	public float getYPosition()
	{
		return this.yPosition;
	}
	public void setXPosition(float value)
	{
		this.xPostion=value;
	}
	public void setYPosition(float ballY)
	{
		this.yPosition=ballY;
	}
}
