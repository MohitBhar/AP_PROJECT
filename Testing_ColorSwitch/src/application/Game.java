package application;

import javafx.stage.Stage;

public class Game {
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
