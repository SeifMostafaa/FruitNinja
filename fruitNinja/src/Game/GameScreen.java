
package Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import factory.*;


public class GameScreen {
	

	Label  lb  = new Label();
	Label Score=new Label();
	int score=0;
    Stage stage;
    Scene scene;
    MainMenu menu;
    ChooseMode ChooseMode;
    GameOver gameOver;
    Context context=new Context();

    public GameScreen(Stage stage){this.stage=stage;}
    public void prepareScene(Context context){

        context.resetGame();
        Group root=new Group();
        this.context=context;
    	lb.setText("Time: "+context.getSeconds());
    	lb.setFont(Font.font("Forte", 32));
    	lb.setTextFill(Color.FLORALWHITE);

        Score.setText("Score: "+score);
        Score.setFont(Font.font("Forte", 32));
        Score.setTextFill(Color.FLORALWHITE);

        Stage windows;

        scene=new Scene(root,800,600);


        ImageView image=new ImageView(new Image("Wiki-background.jpg"));
        image.setFitHeight(600);
        image.setFitWidth(800);
        root.getChildren().addAll(image);
       

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node chosen=event.getPickResult().getIntersectedNode();
                if(chosen!=null){
                    context.SliceFruit(chosen);
                    Score.setText("Score: "+context.getScore());
                }
            }
        });
        context.doTime(root,lb,stage,gameOver);
        HBox layout= new HBox(500);
        layout.getChildren().addAll(lb,Score);
        HBox hearts=new HBox(20);
        hearts.setLayoutX(300);
        hearts.setLayoutY(0);
        context.AddHearts(hearts);
        root.getChildren().addAll(layout,hearts);
       
    }
    public Stage getStage() {
        return stage;
    }
    public Scene getScene() {
        return scene;
    }
	public void setMenu(MainMenu menu) {
		this.menu = menu;
	}
	public void setChooseMode(ChooseMode chooseMode) {
		ChooseMode = chooseMode;
	}

    public void setGameOver(GameOver gameOver) {
        this.gameOver = gameOver;
    }
}
