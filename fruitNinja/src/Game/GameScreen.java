
package Game;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
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

import controller.Invoker;
import factory.*;


public class GameScreen {
	

	Label  lb  = new Label();
	Label Score=new Label();
	int score=0;
    Stage stage;
    Scene scene;
    MainMenu menu;
    ChooseMode ChooseMode;
    DifficultyChoose difficultyChoose;
    GameOver gameOver;
    Context context=new Context();
    AudioClip audioClipMain;
    Invoker inv = new Invoker().getInstance();
    

    public GameScreen(Stage stage){this.stage=stage;}
    public void prepareScene(Context context,int x,AudioClip audioClip){
        audioClip.stop();
        this.audioClipMain=audioClip;
        this.audioClipMain.setVolume(0.25);
        this.audioClipMain.play();
        context.resetGame();
        Group root=new Group();
        this.context=context;
        Label bonus=new Label();
        bonus.setFont(Font.font("Forte", 32));
        bonus.setTextFill(Color.ORANGE);
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
       

       inv.sliceOn(scene, context, Score);

       inv.sliceOff(scene, context, bonus, Score);
   
        if(x==1)
        context.EasyDoTime(root,lb,stage,gameOver,audioClipMain);
        else if(x==2)
            context.MediumDoTime(root,lb,stage,gameOver,audioClipMain);
        else if(x==3)
            context.HardDoTime(root,lb,stage,gameOver,audioClipMain);
        HBox layout= new HBox(500);
        layout.getChildren().addAll(lb,Score);
        HBox hearts=new HBox(20);
        hearts.setLayoutX(300);
        hearts.setLayoutY(0);
        context.AddHearts(hearts);
        root.getChildren().addAll(layout,hearts,bonus);
       
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

    public void setDifficultyChoose(DifficultyChoose difficultyChoose) {
        this.difficultyChoose = difficultyChoose;
    }
}
