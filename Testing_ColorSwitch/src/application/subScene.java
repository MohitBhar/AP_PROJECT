package application;


import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.SubScene;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class subScene extends SubScene {
	private String imagePath;
	public AnchorPane aPane;
	public subScene(String s)
	{	super(new AnchorPane(),1050,700);
		prefHeight(700);
		prefWidth(1050);
		setLayoutX(0);
		setLayoutY(-700);
		this.imagePath=s;
		aPane=(AnchorPane)getRoot();
		background();
		addBack();
	}
	public void background()
	{
		BackgroundFill bFill=new BackgroundFill(Color.web("#292929"),CornerRadii.EMPTY,Insets.EMPTY);
		aPane.setBackground(new Background(bFill));
	
	}
	public void moveScene1()
	{
		TranslateTransition transition=new TranslateTransition();
		System.out.println("Hello1");
		transition.setNode(this);
		transition.setDuration(Duration.seconds(0.7));
		transition.setToY(+700);
		transition.play();
		
	}
	public void moveScene2()
	{
		TranslateTransition transition=new TranslateTransition();
		System.out.println("Hello1");
		transition.setNode(this);
		transition.setDuration(Duration.seconds(1));
		transition.setToY(-700);
		transition.play();
		
	}
	public void addBack()
	{
		button b1=new button("/application/Resources/bla1.png","/application/Resources/bla1.png");
		b1.setPrefHeight(50);
		b1.setPrefWidth(50);
		b1.setLayoutX(30);
		b1.setLayoutY(30);
		aPane.getChildren().add(b1);
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				moveScene2();
			}
		});
	}
	public void addImage(String s1,int x,int y)
	{
		ImageView imageView=new ImageView(s1);
		imageView.setLayoutX(x);
		imageView.setLayoutY(y);
		aPane.getChildren().add(imageView);
		imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent a)
			{
				imageView.setEffect(new Glow());
			}
		});
		imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent a)
			{
				imageView.setEffect(null);
			}
		});
	}
}
