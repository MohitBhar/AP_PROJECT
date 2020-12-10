package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PauseGame {
	private RunningGame runningGame;
	private subScene1 s1;
	private RunGame runGame;
	public PauseGame(RunningGame runningGame,RunGame runGame, subScene1 s1)
	{
		this.runningGame=runningGame;
		this.runGame=runGame;
		this.s1=s1;
		createButtons();
	}
	public void createButtons()
	{
		button b1=new button("/application/Resources/ResumeGame1.png","/application/Resources/ResumeGame2.png");
		button b2=new button("/application/Resources/SaveGame.png","/application/Resources/SaveGame2.png");
		button b3=new button("/application/Resources/MainMenu1.png","/application/Resources/MainMenu.png");
		s1.aPane.getChildren().add(b1);
		s1.aPane.getChildren().add(b2);
		s1.aPane.getChildren().add(b3);
		b1.setLayoutX(100);
		b1.setLayoutY(25);
		b2.setLayoutX(100);
		b2.setLayoutY(100);
		b3.setLayoutX(100);
		b3.setLayoutY(175);
		setActions(b1,b2,b3);

	}
	public void setActions(button b1,button b2,button b3)
	{
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				s1.moveScene2();
				runningGame.animationTimer.start();
				
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				//s1.moveScene2();
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
}
