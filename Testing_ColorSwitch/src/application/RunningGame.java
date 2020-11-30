package application;


import java.util.ArrayList;


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningGame {
	private RunGame runGame;
	private AnchorPane anchorPane;
	public Stage stage;
	private Scene scene;
	public AnimationTimer animationTimer;
	private StopDueToHit stopDueToHit;
	private subScene1 s1;
	private subScene1 s2;
	private RunningGame runningGame=this;
	private Ball b1;
	private ArrayList<Obstacle> obstacles=new ArrayList<Obstacle>();
	private ArrayList<star> stars=new ArrayList<star>();
	private ArrayList<ColorChanger> colorChangers=new ArrayList<ColorChanger>();
	public int score=0;
	private Text scoreText;
	private boolean keyPressed;
	private boolean firstPress=false;
	private boolean ishit=false;
	public RunningGame(RunGame rGame)
	{
		this.runGame=rGame;
		anchorPane=new AnchorPane();
		scene=new Scene(anchorPane,800,700);
		stage=new Stage();
		stage.setScene(scene);
		display();
		stage.getIcons().add(new Image("/application/Resources/titlelogo.png"));
		createColorChanger();
		createBall();
		createStar();
		createObstacle();
		s1=new subScene1("/application/Resources/YellowPanel2.png");
		anchorPane.getChildren().add(s1);
		s2=new subScene1("/application/Resources/YellowPanel2.png");
		anchorPane.getChildren().add(s2);
		//ishit=true;
		moveBall();
		hitScene();
		
		
	}
	public void hitScene()
	{
		if(ishit)
		{
			s2.moveScene1();
			stopDueToHit=new StopDueToHit(runningGame, runGame, s2);
		}
	}
	public void createObstacle()
	{
		Obstacle o1=new Obstacle(400,200,"1");
		Group g1=o1.createObstacle();
		obstacles.add(o1);
		anchorPane.getChildren().add(g1);
		RotateTransition rTrans = new RotateTransition(Duration.millis(3000),g1);
		rTrans.setByAngle(-360);
        rTrans.setCycleCount(Animation.INDEFINITE);
        rTrans.setInterpolator(Interpolator.LINEAR);
        rTrans.play();
        Obstacle o2=new Obstacle(400,500,"2");
        Group g2=o2.createObstacle();
        obstacles.add(o2);
        anchorPane.getChildren().add(g2);
		RotateTransition rTrans1 = new RotateTransition(Duration.millis(3000),g2);
		rTrans1.setByAngle(-360);
        rTrans1.setCycleCount(Animation.INDEFINITE);
        rTrans1.setInterpolator(Interpolator.LINEAR);
        rTrans1.play();
        Obstacle o3=new Obstacle(400,-200,"3");
		Group g3=o3.createObstacle();
		obstacles.add(o3);
		anchorPane.getChildren().add(g3);
		RotateTransition rTrans2 = new RotateTransition(Duration.millis(3000),g3);
		rTrans2.setByAngle(-360);
        rTrans2.setCycleCount(Animation.INDEFINITE);
        rTrans2.setInterpolator(Interpolator.LINEAR);
        rTrans2.play();
        Obstacle o4=new Obstacle(400,-500,"4");
        Group g4=o4.createObstacle();
        obstacles.add(o4);
        anchorPane.getChildren().add(g4);
		RotateTransition rTrans3 = new RotateTransition(Duration.millis(3000),g4);
		rTrans3.setByAngle(-360);
        rTrans3.setCycleCount(Animation.INDEFINITE);
        rTrans3.setInterpolator(Interpolator.LINEAR);
        rTrans3.play();
    
				
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
	public void display()
	{
		runGame.stage.hide();
		stage.show();
		background();
		musicButton();
		score();
		pause();
		functionKey();
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
					gravity();
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
					for(Obstacle x:obstacles)
					{
							if(x.getYPosition()>650)
							{
								x.setYPosition(x.getYPosition()-700);
								for(Arc y:x.arcList)
								{
									y.setCenterY(x.getYPosition());
								}
							}
					}
					for(Obstacle o1:obstacles)
					{
						o1.checkCollision(b1);
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
			for(Obstacle x:obstacles)
			{	
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
//		t1.setOnMousePressed(new EventHandler<MouseEvent>() {
//			
//			public void handle(MouseEvent a)
//			{
//				test++;
//				t1.setText(Integer.toString(test));
//			}
//		});
	}
	public void setScore()
	{
		scoreText.setText(Integer.toString(score));
	}
	
}
