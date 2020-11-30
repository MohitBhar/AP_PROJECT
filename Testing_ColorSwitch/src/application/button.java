package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class button extends Button{
	private String pressedString;
	private String releasedString;
	private final int width=200;
	private final int height=50;
	public button(String s1,String s2)
	{
		this.pressedString=s1;
		this.releasedString=s2;
		this.prefWidth(width);
		this.prefHeight(height);
		BackgroundFill bFill=new BackgroundFill(Color.web("#292929"),CornerRadii.EMPTY,Insets.EMPTY);
		this.setBackground(new Background(bFill));
		released();
		actions();
	}
	private void pressed()
	{
		ImageView imageView=new ImageView(pressedString);
		this.setGraphic(imageView);
	}
	private void released()
	{
		ImageView imageView=new ImageView(releasedString);
		this.setGraphic(imageView);
	
	}
	private void actions()
	{
		mPressed();
		mReleased();
		mEntered();
		mExited();
	}
	private void mPressed()
	{
		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent a)
			{	if(a.getButton().compareTo(MouseButton.PRIMARY)==0)
				{
					pressed();
				}
			}
		});
	}
	private void mReleased()
	{
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent a)
			{	if(a.getButton().compareTo(MouseButton.PRIMARY)==0)
				{
					released();
				}
			}
		});
	}
	private void mEntered()
	{
		
			this.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent a)
				{
					setEffect(new Glow());
				}
			});
		}
	private void mExited()
	{
		
			this.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent a)
				{
					setEffect(null);
				}
			});
		}
	
	
}
