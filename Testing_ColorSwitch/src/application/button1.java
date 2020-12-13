package application;

import java.awt.Font;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class button1 extends Button{
	private String pressedString="application/Resources/yellow_button00.png";
	private String releasedString="application/Resources/yellow_button01.png";
	private final int width=400;
	private final int height=50;
	public button1(String Text)
	{
		this.prefWidth(width);
		this.prefHeight(height);
		this.setText(Text);
		this.setStyle("-fx-font-size:30");
		released();
		actions();
	}
	private void pressed()
	{
		Image image=new Image(pressedString);
		BackgroundImage bImage=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,null);
		this.setBackground(new Background(bImage));
	}
	private void released()
	{
		Image image=new Image(releasedString);
		BackgroundImage bImage=new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,null);
		this.setBackground(new Background(bImage));

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
