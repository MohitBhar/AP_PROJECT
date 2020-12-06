package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StopDueToHit {
	private RunningGame runningGame;
	private subScene1 s1;
	private RunGame runGame;
	private Text scoreText=new Text();
	public StopDueToHit(RunningGame runningGame,RunGame runGame, subScene1 s1)
	{
		this.runningGame=runningGame;
		this.runGame=runGame;
		this.s1=s1;
		createButtons();
	}
	public void createButtons()
	{
		button b1=new button("/application/Resources/Continue2.png","/application/Resources/Continue1.png");
		button b2=new button("/application/Resources/Restart2.png","/application/Resources/Restart1.png");
		button b3=new button("/application/Resources/MainMenu1.png","/application/Resources/MainMenu.png");
		s1.aPane.getChildren().add(b1);
		s1.aPane.getChildren().add(b2);
		s1.aPane.getChildren().add(b3);
		b1.setLayoutX(150);
		b1.setLayoutY(25);
		b2.setLayoutX(150);
		b2.setLayoutY(100);
		b3.setLayoutX(150);
		b3.setLayoutY(175);
		setActions(b1,b2,b3);
		ImageView iv=new ImageView("/application/Resources/totalStar.png");
		iv.setLayoutX(40);
		iv.setLayoutY(60);
		s1.aPane.getChildren().add(iv);
		scoreText=new Text();
		scoreText.setText("0");
		scoreText.setFill(Color.WHITE);
		scoreText.setLayoutX(50);
		scoreText.setLayoutY(150);
		scoreText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
		s1.aPane.getChildren().add(scoreText);
		

	}
	public void setActions(button b1,button b2,button b3)
	{
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				s1.moveScene2();
				runningGame.b1.setYPosition(runningGame.b1.getYPosition()+45);
				runningGame.b1.c1.setLayoutY(runningGame.b1.getYPosition());
				setScore1();
				runningGame.animationTimer.start();
				
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				
			}
		});
		b3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				runGame.stage.show();
				runningGame.stage.hide();
			}
		});
		
	}
	public void setScore1()
	{
		scoreText.setText("");
	}
	
	public void setScore2()
	{
		scoreText.setText(Integer.toString(runningGame.score));
	}

}
