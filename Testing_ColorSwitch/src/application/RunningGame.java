package application;


import java.io.Serializable;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningGame implements Serializable{
	private RunGame runGame;
	private AnchorPane anchorPane;
	public Stage stage;
	private Scene scene;
	public AnimationTimer animationTimer;
	public StopDueToHit stopDueToHit;
	private subScene1 s1;
	private subScene1 s2;
	private int count;
	private RunningGame runningGame=this;
	protected Ball b1;
	int bonusThreshold;
	boolean checkForCollision=true;
	ImageView imageBonusImageView;
	protected ArrayList<ObstacleAbstract> obstacles=new ArrayList<ObstacleAbstract>();
	protected ArrayList<star> stars=new ArrayList<star>();
	protected ArrayList<ColorChanger> colorChangers=new ArrayList<ColorChanger>();
	protected int score=0;
	State state;
	private Text scoreText;
	private boolean keyPressed;
	private boolean firstPress=false;
	private boolean ishit;
	public RunningGame(RunGame rGame,State s)
	{
		this.runGame=rGame;
		anchorPane=new AnchorPane();
		scene=new Scene(anchorPane,800,700);
		stage=new Stage();
		stage.setScene(scene);
		display();
		stage.getIcons().add(new Image("/application/Resources/titlelogo.png"));
		if(s==null)
		{
			createColorChanger();
			createBall();
			createStar();
			createObstacle();
			score();
		}
		else {
//			System.out.println("badbfaafffffffffffffffffffbaasdba");
			state=s;
			createColorChanger1();
			createBall1();
			createStar1();
			createObstacle1();
			score();
			this.score=state.score;
			setScore();
		}
		s1=new subScene1("/application/Resources/YellowPanel2.png");
		anchorPane.getChildren().add(s1);
		s2=new subScene1("/application/Resources/YellowPanel2.png");
		anchorPane.getChildren().add(s2);
		moveBall();
		this.bonusThreshold=5;
		this.imageBonusImageView=createBonus();
		
	}
	public void createObstacle()
	{
		Obstacle4 o1=new Obstacle4(400,200-500+90,"1");
		Group g1=o1.createObstacle();
		obstacles.add(o1);
		anchorPane.getChildren().add(g1);
        Obstacle o2=new Obstacle(400,500,"2");
        Group g2=o2.createObstacle();
        obstacles.add(o2);
        anchorPane.getChildren().add(g2);
        Obstacle5 o3=new Obstacle5(400,-200,"3");
		Group g3=o3.createObstacle();
		obstacles.add(o3);
		anchorPane.getChildren().add(g3);
        Obstacle2 o4=new Obstacle2(400,-500,"4");
        Group g4=o4.createObstacle();
        obstacles.add(o4);
        anchorPane.getChildren().add(g4);
        Obstacle3 o5=new Obstacle3(400,-900,"5");
        Group g5=o5.createObstacle();
        obstacles.add(o5);
        anchorPane.getChildren().add(g5);
        Obstacle5 o6=new Obstacle5(400,-1200,"6");
		Group g6=o6.createObstacle();
		obstacles.add(o6);
		anchorPane.getChildren().add(g6);
        
//		Obstacle4 o1=new Obstacle4(400,200-500+90,"1");
//		Group g1=o1.createObstacle();
//		obstacles.add(o1);
//		anchorPane.getChildren().add(g1);
//        Obstacle3 o2=new Obstacle3(400,500,"2");
//        Group g2=o2.createObstacle();
//        obstacles.add(o2);
//        anchorPane.getChildren().add(g2);
//        Obstacle o3=new Obstacle(400,-200,"3");
//		Group g3=o3.createObstacle();
//		obstacles.add(o3);
//		anchorPane.getChildren().add(g3);
//        Obstacle2 o4=new Obstacle2(400,-500,"4");
//        Group g4=o4.createObstacle();
//        obstacles.add(o4);
//        anchorPane.getChildren().add(g4);
//    
				
	}
	public void createStar()
	{
		star star1=new star();
		stars.add(star1);
		star1.setXPosition(380);
		star1.setYPosition(480);
		anchorPane.getChildren().add(star1.createStar());
		star star2=new star();
		stars.add(star2);
		star2.setXPosition(380);
		star2.setYPosition(180);
		anchorPane.getChildren().add(star2.createStar());
	}
	public void createColorChanger()
	{
		ColorChanger changer1=new ColorChanger();
		colorChangers.add(changer1);
		changer1.setXPosition(390);
		changer1.setYPosition(50);
		anchorPane.getChildren().add(changer1.createColor());
		ColorChanger changer2=new ColorChanger();
		colorChangers.add(changer2);
		changer2.setXPosition(390);
		changer2.setYPosition(340);
		anchorPane.getChildren().add(changer2.createColor());
	
	}
	public void createBall()
	{
		b1=new Ball();
		b1.setXPosition(400);
		b1.setYPosition(670);
		anchorPane.getChildren().add(b1.createBall());
		
	}
	public ImageView createBonus()
	{
		ImageView iView=new ImageView("/application/Resources/Bonus Image.png");
		this.anchorPane.getChildren().add(iView);
		iView.setLayoutX(380);
		iView.setLayoutY(-40);
		return iView;
		
	}
	public void createObstacle1()
	{
		
		Obstacle4 o1=new Obstacle4(400,state.obstacleYCoordinates.get(0),"1");
		Group g1=o1.createObstacle();
		obstacles.add(o1);
		anchorPane.getChildren().add(g1);
        Obstacle o2=new Obstacle(400,state.obstacleYCoordinates.get(1),"2");
        Group g2=o2.createObstacle();
        obstacles.add(o2);
        anchorPane.getChildren().add(g2);
        Obstacle5 o3=new Obstacle5(400,state.obstacleYCoordinates.get(2),"3");
		Group g3=o3.createObstacle();
		obstacles.add(o3);
		anchorPane.getChildren().add(g3);
        Obstacle2 o4=new Obstacle2(400,state.obstacleYCoordinates.get(3),"4");
        Group g4=o4.createObstacle();
        obstacles.add(o4);
        anchorPane.getChildren().add(g4);
        Obstacle3 o5=new Obstacle3(400,state.obstacleYCoordinates.get(4),"5");
        Group g5=o5.createObstacle();
        obstacles.add(o5);
        anchorPane.getChildren().add(g5);
        Obstacle5 o6=new Obstacle5(400,state.obstacleYCoordinates.get(5),"6");
		Group g6=o6.createObstacle();
		obstacles.add(o6);
		anchorPane.getChildren().add(g6);
        
				
	}
	
	

	public void createStar1()
	{
		star star1=new star();
		stars.add(star1);
		star1.setXPosition(380);
		star1.setYPosition(state.starYCoordinates.get(0));
		anchorPane.getChildren().add(star1.createStar());
		star star2=new star();
		stars.add(star2);
		star2.setXPosition(380);
		star2.setYPosition(state.starYCoordinates.get(1));
		anchorPane.getChildren().add(star2.createStar());
	}
	public void createColorChanger1()
	{
		ColorChanger changer1=new ColorChanger();
		colorChangers.add(changer1);
		changer1.setXPosition(390);
		changer1.setYPosition(state.colorChangerYCoordinates.get(0));
		anchorPane.getChildren().add(changer1.createColor());
		ColorChanger changer2=new ColorChanger();
		colorChangers.add(changer2);
		changer2.setXPosition(390);
		changer2.setYPosition(state.colorChangerYCoordinates.get(1));
		anchorPane.getChildren().add(changer2.createColor());
	
	}
	
	public void createBall1()
	{
		b1=new Ball();
		b1.setXPosition(400);
		b1.setYPosition(state.ballY);
		anchorPane.getChildren().add(b1.createBall());
		
	}
	
	public void display()
	{
		runGame.stage.hide();
		stage.show();
		background();
		musicButton();
		pause();
		functionKey();
		//key2();
	}
	public void moveBall()
	{
		this.animationTimer=new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				
				if(firstPress==false)
				{
					upKey();
					
				}
				else if(firstPress=true) {
					if(score<=5)
					{
						gravity();
					}
					else {
						gravity1();
					}
					if(imageBonusImageView.getBoundsInParent().intersects(b1.c1.getBoundsInParent()))
					{
						bonusGravity(0);
						imageBonusImageView.setLayoutY(-40);
						bonusThreshold=bonusThreshold*2;
						count=0;
						AnimationTimer animationTimer=new AnimationTimer() {
							
							@Override
							public void handle(long arg0) {
								// TODO Auto-generated method stub
								b1.c1.setEffect(new Shadow());
								count++;
								checkForCollision=false;
								if(count>800)
								{
									this.stop();
									b1.c1.setEffect(null);
									checkForCollision=true;
								}
							}
						};
						animationTimer.start();
					}
					if(score>bonusThreshold)
					{
						createBonus();
						bonusGravity(2);
						
						
					}
					upKey();
					for(ColorChanger x:colorChangers)
					{
						if(b1.c1.getBoundsInParent().intersects(x.iView1.getBoundsInParent()))
						{
							b1.c1.setFill(b1.selectColor());
							x.setYPosition(x.getYPosition()-700);
							x.iView1.setLayoutY(x.getYPosition());
						}
						
					}
					for(star x:stars)
					{
						if(b1.c1.getBoundsInParent().intersects(x.iView1.getBoundsInParent()))
						{
							x.setYPosition(x.getYPosition()-700);
							x.iView1.setLayoutY(x.getYPosition());
							score++;
							runningGame.setScore();
							//stopDueToHit.setScore2();
						}
					}
					for(ObstacleAbstract x:obstacles)
					{		
							int resetVariable=2100;
							if(x.getYPosition()>650)
							{
								if(x instanceof Obstacle3) {
//									
									x.setYPosition(x.getYPosition()-resetVariable);
									for(Circle y:x.circleList)
									{
										y.setCenterY(y.getCenterY()-resetVariable);
									}
									for(Rotate y:x.rotateList)
									{
										y.setPivotY(x.getYPosition());		
									}
									continue;
								}
								if(x instanceof Obstacle3) {
//									
									x.setYPosition(x.getYPosition()-resetVariable);
									for(Circle y:x.circleList)
									{
										y.setCenterY(y.getCenterY()-resetVariable);
									}
									for(Arc y:x.arcList)
									{
										y.setCenterY(x.getYPosition());
//									}	y.setPivotY(x.getYPosition());		
									}
									continue;
								}
								if(x instanceof Obstacle5) {
//									
									x.setYPosition(x.getYPosition()-resetVariable);
									ArrayList<Rectangle> rectangleList=((Obstacle5)x).rectangleList;
//									System.out.println("111111111111111111111111111111");
									for(Rectangle y:rectangleList)
									{
//										System.out.println();
										y.setY(y.getY()-resetVariable);
									}
									for(Rotate y:x.rotateList)
									{
										y.setPivotY(x.getYPosition()+10);		
									}
									continue;
								}
								x.setYPosition(x.getYPosition()-resetVariable);
								
								for(Arc y:x.arcList)
								{
									y.setCenterY(x.getYPosition());
								}
							}
					}
					
					outScreen();
					if(checkForCollision)
					{
					for(ObstacleAbstract o1:obstacles)
					{
						Arc test=o1.checkCollision(b1);
						if(test!=null)
						{
							if(!test.getStroke().toString().contentEquals(b1.c1.getFill().toString()))
							{
								ishit=true;
								hit();
								s2.moveScene1();
								animationTimer.stop();
							}
						}
						
					}
					}
										
				if(b1.getYPosition()<350)
					{
						fun2();
					}
				}
				
				
			}
		};
		animationTimer.start();
	
	}
	public void outScreen()
	{
		if(b1.getYPosition()>=702)
		{
			stopDueToHit=new StopDueToHit(runningGame, runGame, s2);
			stopDueToHit.setScore2();
			animationTimer.stop();
			s2.moveScene1();
			
		}
	}
	public void hit()
	{
		if(ishit)
		{
			stopDueToHit=new StopDueToHit(runningGame, runGame, s2);
			stopDueToHit.setScore2();
			animationTimer.stop();
			firstPress=false;
		}
	}
	public void bonusGravity(int n)
	{
		this.imageBonusImageView.setLayoutY(imageBonusImageView.getLayoutY()+n);
	}
	public void fun2()
	{
		if(keyPressed)
		{

			for(ColorChanger x:colorChangers)
			{
				x.setYPosition(x.getYPosition()+5);
				x.iView1.setLayoutY(x.getYPosition());
			}
			for(star x:stars)
			{
				x.setYPosition(x.getYPosition()+5);
				x.iView1.setLayoutY(x.getYPosition());
			
			}
			for(ObstacleAbstract x:obstacles)
			{	
				
				if(x instanceof Obstacle3) {
//					System.out.println("-----------------");
					
					x.setYPosition(x.getYPosition()+5);
					for(Circle y:x.circleList)
					{
						y.setCenterY(y.getCenterY()+5);
					}
					for(Rotate y:x.rotateList)
					{
//						if(x.getYPosition()>0 ) {
						y.setPivotY(x.getYPosition());
//						}
						
						
					}
					continue;
				}
				if(x instanceof Obstacle5) {
//					
					x.setYPosition(x.getYPosition()+5);
					ArrayList<Rectangle> rectangleList=((Obstacle5)x).rectangleList;
//					System.out.println("111111111111111111111111111111");
					for(Rectangle y:rectangleList)
					{
//						System.out.println();
						y.setY(y.getY()+5);
					}
					for(Rotate y:x.rotateList)
					{
						y.setPivotY(x.getYPosition()+10);		
					}
					continue;
				}
				if(x instanceof Obstacle4) {
					//System.out.println("-----------------");
					
					x.setYPosition(x.getYPosition()+5);
//					System.out.println(x.circleList.size()+"circle size");
//					System.out.println(x.arcList.size()+"arc size");
					
					for(Circle y:x.circleList)
					{
						y.setCenterY(y.getCenterY()+5);
					}
//					for(Arc y:x.arcList)
//					{
//						y.setCenterY(y.getCenterY()+5);
//					}
					ArrayList<PathTransition> pathTransitions=((Obstacle4) x).pathList;
					//System.out.println(pathTransitions.size()+"path size");
					PathTransition trans0=pathTransitions.get(0);
					Duration duration_1=trans0.getCycleDuration();
					double cycle_time=duration_1.toSeconds();
					Duration duration_11=duration_1.divide(2);
					
//					Duration duration22;
					Duration duration_2=trans0.getCurrentTime();
					double total_time=duration_2.toSeconds();
					int n=(int) (total_time/cycle_time);
					boolean b=((total_time-(cycle_time*n))-(cycle_time/2))>0;
					
					for(int i=0;i<x.arcList.size();i++) {
						
						Double d=x.circleList.get(0).getCenterX();
						PathTransition trans=pathTransitions.get(i);
//						Duration duration=trans.getDuration();
						Duration duration1=trans.getCycleDuration();
//						double cycle_time=duration1.toSeconds();
						Duration duration11=duration1.divide(2);
//						
						Duration duration22;
						Duration duration2=trans.getCurrentTime();
//						double total_time=duration2.toSeconds();
//						int n=(int) (total_time/cycle_time);
//						boolean b=((total_time-(cycle_time*n))-(cycle_time/2))>0;
//						Double d1=x.circleList.get(0).getCenterX();
						if(1==0) {
							//System.out.println("********************true------------------"+n);
							duration22=duration2.add(duration11);
						}
						else
						{
							//System.out.println("+++++++++++++++++++++++++++++");
							duration22=duration2;
						}
						
						
//						trans.setAutoReverse(true);
//						trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//						trans.g
//						Duration duration3=trans.getCycleDuration();
						
						trans.stop();
						
//						trans.stop();
						Arc arc=x.arcList.get(i);
						arc.setCenterY(arc.getCenterY()+5);
						trans.setPath(arc);
						
//						trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//						// Let the animation run forever
//						trans.setCycleCount(FadeTransition.INDEFINITE);
//						// Reverse direction on alternating cycles
//						trans.setAutoReverse(true);
//						// Play the Animation
//						trans.play();
						trans.playFrom(duration22);
						
						//System.out.println("path set");
					}
//					for(PathTransition y:((Obstacle4) x).pathList)
//					{
//						y.setPath(arg0);
//						y.setCenterY(y.getCenterY()+5);
//					}
					continue;
				}
				
				x.setYPosition(x.getYPosition()+5);
				for(Arc y:x.arcList)
				{
					y.setCenterY(x.getYPosition());
				}
				
			}
		}
	
	}
	public void gravity()
	{
		//System.out.println(1);
		b1.setYPosition(b1.getYPosition()+2);
		b1.c1.setLayoutY(b1.getYPosition());
	}
	public void gravity1()
	{
		float gravity=(float) (2+((int) (score/5))*0.2);
		if(gravity>3) {
//			System.out.println("set to 4");
			gravity=3;
		}
//		System.out.println("============ gravity"+gravity);
		b1.setYPosition(b1.getYPosition()+gravity);
		b1.c1.setLayoutY(b1.getYPosition());
	}
	public void upKey()
	{
		if(keyPressed)
		{	firstPress=true;

			b1.setYPosition(b1.getYPosition()-7);
			b1.c1.setLayoutY(b1.getYPosition());
		}
	}
	public void functionKey()
	{
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent a)
			{	if(a.getCode()==KeyCode.W)
				{	
					keyPressed=true;
				}
				
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent a)
			{	if(a.getCode()==KeyCode.W)
				{	
					keyPressed=false;
				}
				
			}
		});
				
}
	
	public void background()
	{
		BackgroundFill bFill=new BackgroundFill(Color.web("#292929"),CornerRadii.EMPTY,Insets.EMPTY);
		anchorPane.setBackground(new Background(bFill));
	}
	public void musicButton()
	{
		button b1=new button("/application/Resources/sound1.jpg","/application/Resources/sound1.jpg");
		anchorPane.getChildren().add(b1);
		b1.setLayoutX(680);
		b1.setLayoutY(600);
		b1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent a)
			{
				if(runGame.count==1)
				{
					runGame.mPlayer.pause();
					runGame.count=0;
					ImageView imageView=new ImageView("/application/Resources/sound3.jpg");
					b1.setGraphic(imageView);
				}
				else if(runGame.count==0)
				{
					ImageView imageView=new ImageView("/application/Resources/sound1.jpg");
					b1.setGraphic(imageView);
					runGame.mPlayer.play();
					runGame.count=1;
				}
			}
		});
		b1.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent e)
			{
				ImageView imageView=new ImageView("/application/Resources/sound1.jpg");
				b1.setGraphic(imageView);
			}
		
		});
		b1.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent e)
			{
				//ImageView imageView=new ImageView("/application/Resources/sound1.jpg");
				//b1.setGraphic(imageView);
			}
		
		});
	}
	public void pause()
	{
		button b1=new button("/application/Resources/pause.png","/application/Resources/pause.png");
		anchorPane.getChildren().add(b1);
		b1.setLayoutX(700);
		b1.setLayoutY(0);
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a)
			{
				s1.moveScene1();
				animationTimer.stop();
				PauseGame pauseGame=new PauseGame(runningGame,runGame,s1);
			}
			
		});
		
	}
	
	public void score()
	{
		ImageView imageView=new ImageView("/application/Resources/score1.png");
		anchorPane.getChildren().add(imageView);
		imageView.setLayoutX(0);
		imageView.setLayoutY(0);
		scoreText=new Text();
		scoreText.setText("0");
		scoreText.setFill(Color.WHITE);
		scoreText.setLayoutX(50);
		scoreText.setLayoutY(160);
		scoreText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
		anchorPane.getChildren().add(scoreText);
	}
	public void setScore()
	{
		scoreText.setText(Integer.toString(score));
	}
	public int getScore()
	{
		return score;
	}
}
