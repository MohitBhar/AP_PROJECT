package application;

import java.util.ArrayList;

public class State {
		private ArrayList<ObstacleAbstract> obstacles;
		private ArrayList<ColorChanger> colorChangers;
		private ArrayList<star> stars;
		private Ball b1;
		private int score;
		public State(ArrayList<ObstacleAbstract> obstacles,ArrayList<ColorChanger> colorChangers,ArrayList<star> stars,Ball b1,int score)
		{
			this.obstacles=obstacles;
			this.colorChangers=colorChangers;
			this.stars=stars;
			this.b1=b1;
			this.score=score;
		}
		public ArrayList<ObstacleAbstract> getObstacleAbstracts()
		{
			return this.obstacles;
		}
		public ArrayList<ColorChanger> getChangers()
		{
			return this.colorChangers;
		}
		public ArrayList<star> getStars()
		{
			return this.stars;
		}
		public int getScore()
		{
			return this.score;
		}
		public Ball getBall()
		{
			return this.b1;
		}
}
