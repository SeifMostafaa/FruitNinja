package Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;


public class DifficultyChoose {
    Stage stage;
    Scene scene;
    GameScreen gameScreen;
    ChooseMode chooseMode;
    AudioClip audioClip;
    public DifficultyChoose(Stage stage){this.stage=stage;}
    public void prepareScene(Context context,AudioClip audioClip){

        this.audioClip=audioClip;
        Button EasyMode=new Button();
        Button NormalMode=new Button();
        Button HardMode=new Button();
        Button Back=new Button();
        ImageView easy=new ImageView(new Image("Easy.png"));
        easy.setFitWidth(155);
        easy.setFitHeight(60);
        ImageView medium=new ImageView(new Image("Medium.png"));
        medium.setFitWidth(155);
        medium.setFitHeight(60);
        ImageView hard=new ImageView(new Image("Hard.png"));
        hard.setFitWidth(155);
        hard.setFitHeight(60);
        ImageView back=new ImageView(new Image("Back.png"));
        back.setFitWidth(155);
        back.setFitHeight(60);
        EasyMode.setGraphic(easy);
        EasyMode.setBackground(null);
        NormalMode.setGraphic(medium);
        NormalMode.setBackground(null);
        HardMode.setGraphic(hard);
        HardMode.setBackground(null);
        Back.setGraphic(back);
        Back.setBackground(null);
        ImageView image=new ImageView(new Image("Wiki-background.jpg"));
        image.setFitHeight(600);
        image.setFitWidth(800);
        VBox vBox=new VBox(10);
        vBox.getChildren().addAll(EasyMode,NormalMode,HardMode,Back);
        vBox.setLayoutY(200);
        vBox.setLayoutX(300);
        Group group=new Group();
        group.getChildren().addAll(image,vBox);
        EasyMode.setCursor(Cursor.HAND);
        EasyMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameScreen.prepareScene(context,1,audioClip);
                stage.setScene(gameScreen.getScene());
            }
        });
        NormalMode.setCursor(Cursor.HAND);
        NormalMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameScreen.prepareScene(context,2,audioClip);
                stage.setScene(gameScreen.getScene());
            }
        });
        HardMode.setCursor(Cursor.HAND);
        HardMode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameScreen.prepareScene(context,3,audioClip);
                stage.setScene(gameScreen.getScene());
            }
        });
        Back.setCursor(Cursor.HAND);
        Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseMode.preparescene(audioClip);
                stage.setScene(chooseMode.getScene());
            }
        });
        scene=new Scene(group,800,600);
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void setChooseMode(ChooseMode chooseMode) {
        this.chooseMode = chooseMode;
    }

    public Scene getScene() {
        return scene;
    }
}
