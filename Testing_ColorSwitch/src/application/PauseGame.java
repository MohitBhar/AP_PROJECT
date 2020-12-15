package application;

import java.io.IOException;

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
				runningGame.stopDueToHit.setDefaut();
				runningGame.stopDueToHit.setScore1();
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				State state=new State(runningGame.obstacles, runningGame.colorChangers, runningGame.stars, runningGame.b1 , runningGame.score);
				
				// Mohit's design
				State.stateList_stateclass.add(state);
				runGame.stateList.add(state);
				try {
					runGame.serialize(runGame.stateList);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(runningGame.stopDueToHit!=null)
				{
					runningGame.stopDueToHit.setDefaut();
					runningGame.stopDueToHit.setScore1();
					
				}	
				
//				s1.moveScene2();
				runGame.stage.show();
				runningGame.stage.hide();
				
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
