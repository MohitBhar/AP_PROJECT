package application;

import java.io.Serializable;
import java.util.ArrayList;

public class State implements Serializable {
		transient public static ArrayList<State> stateList_stateclass=new ArrayList<State>();
		transient private ArrayList<ObstacleAbstract> obstacles;
		transient private ArrayList<ColorChanger> colorChangers;
		transient private ArrayList<star> stars;
		transient private Ball b1;
		protected int score;
		protected float ballY;
		protected ArrayList<Float> obstacleYCoordinates=new ArrayList<Float>();
		protected ArrayList<Float> starYCoordinates=new ArrayList<Float>();
		protected ArrayList<Float> colorChangerYCoordinates=new ArrayList<Float>();
		public State(ArrayList<ObstacleAbstract> obstacles,ArrayList<ColorChanger> colorChangers,ArrayList<star> stars,Ball b1,int score)
		{
			this.obstacles=obstacles;
			this.colorChangers=colorChangers;
			this.stars=stars;
			this.b1=b1;
			this.score=score;
			save();
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
		public void saveObstacleY() {
			for(ObstacleAbstract x:obstacles) {
				obstacleYCoordinates.add((float) x.getYPosition());
			}
		}
		public void saveColorChangerY() {
			for(ColorChanger x:colorChangers) {
				colorChangerYCoordinates.add(x.getYPosition());
			}
		}public void saveStarY() {
			for(star x:stars) {
				starYCoordinates.add(x.getYPosition());
			}
		}
		public void saveBallY() {
			this.ballY=(float) b1.c1.getLayoutY();
		}
		
		public void save() {
			saveBallY();
			saveColorChangerY();
			saveObstacleY();
			saveStarY();
		}
		
		
		public Ball getBall()
		{
			return this.b1;
		}
}
