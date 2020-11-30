package application;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class subScene1 extends SubScene {
	private String imagePath;
	public AnchorPane aPane;
	public subScene1(String s)
	{	super(new AnchorPane(),400,250);
		prefHeight(250);
		prefWidth(400);
		setLayoutX(200);
		setLayoutY(-250);
		this.imagePath=s;
		aPane=(AnchorPane)getRoot();
		background();
	}
	public void background()
	{
		Image i1=new Image(imagePath);
		BackgroundImage backgroundImage=new BackgroundImage(i1,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		aPane.setBackground(new Background(backgroundImage));
	
	}
	public void moveScene1()
	{
		TranslateTransition transition=new TranslateTransition();
	
		transition.setNode(this);
		transition.setDuration(Duration.seconds(0.3));
		transition.setToY(+450);
		transition.play();
		
	}
	public void moveScene2()
	{
		TranslateTransition transition=new TranslateTransition();
		transition.setNode(this);
		transition.setDuration(Duration.seconds(1));
		transition.setToY(-450);
		transition.play();
		
	}
}

