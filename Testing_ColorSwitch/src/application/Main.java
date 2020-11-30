package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Game game=new Game();
			Color color=Color.AQUA;
			Color color2=Color.AQUA;
			
			if(color.toString()=="0x00ffffff") {
				System.out.println("abcd");
			}
			if(color.toString().equals(color2.toString())) {
				System.out.println("abcdef");
			}
			if(color.toString().contentEquals(color2.toString())) {
				System.out.println("a----bcdef");
			}
			System.out.println("====================="+color.toString());
			System.out.println("====================="+color2.toString());
			
			primaryStage=game.getStage();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
