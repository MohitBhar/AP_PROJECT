package application;

import java.io.Serializable;

import javafx.stage.Stage;

public class Game implements Serializable{
	private RunGame runGame;
	public Game()
	{
		runGame=new RunGame();
	}
	public Stage getStage()
	{
		return runGame.getStage();
	}
	
}	
