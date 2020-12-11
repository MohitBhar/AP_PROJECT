package application;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public class ColorChanger implements Serializable{
	private float xPosition;
	private float yPosition;
	private String pathString;
	public ImageView iView1;
	public ColorChanger()
	{
		pathString="/application/Resources/Color.png";
	}
	public ImageView createColor()
	{
		ImageView iView=new ImageView(pathString);
		iView.setLayoutX(getXPosition());
		iView.setLayoutY(getYPosition());
		this.iView1=iView;
		return iView;
	}
	public void setXPosition(float value)
	{
		this.xPosition=value;
	}
	public float getXPosition()
	{
		return this.xPosition;
	}
	public void setYPosition(float value)
	{
		this.yPosition=value;
	}
	public float getYPosition()
	{
		return this.yPosition;
	}
}
