package Game;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenu {
	ChooseMode choosemode ;
	 public MainMenu(Stage stage , GameScreen GameScreen) {
		 this.stage = stage ;
		 this.gamescreen =GameScreen ;
	 }
	Stage stage;
	Scene scene;
	GameScreen gamescreen ;
	ImageView bg = new ImageView();
	 
	 Group root=new Group();
	 Canvas canvas=new Canvas(800,600);
	 GraphicsContext gc = canvas.getGraphicsContext2D();
	 GridPane grid=new GridPane();
     Button chooseMode=new Button() ;
     Button exitG=new Button();
     AudioClip audioClip;
     
	
	 public void prepareScene() {
		 audioClip=new AudioClip("file:menu.mp3");
		 audioClip.play();
		
		//--------------------Image View--------------------\\
		Image background=new Image ("Wiki-background.jpg");
		bg.setImage(background);
		bg.setFitHeight(600);
		bg.setFitWidth(800);
		
		
		
		Image start = new Image("ChooseMode.png");
		ImageView st = new ImageView();
		st.setImage(start);
		st.setFitHeight(60);
		st.setFitWidth(155);
		
		Image exit = new Image("exitG.png");
		ImageView ex = new ImageView();
		ex.setImage(exit);
		ex.setFitHeight(60);
		ex.setFitWidth(155);
		
		
		
		grid.setMinSize(800, 400);
		grid.add(chooseMode, 1, 0);
		grid.add(exitG, 1, 1);
		grid.setVgap(7);
		grid.setHgap(7);

		GridPane.setHalignment(chooseMode, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(exitG, javafx.geometry.HPos.CENTER);
		grid.setAlignment(Pos.BOTTOM_CENTER);
		
		//----------------Buttons Image View----------------\\
		
		
		chooseMode.setGraphic(st);
		exitG.setGraphic(ex);
		chooseMode.setBackground(null);
		exitG.setBackground(null);
		
		chooseMode.setCursor(Cursor.HAND);
		chooseMode.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

			choosemode.preparescene(audioClip);
			stage.setScene(choosemode.getScene());

			}
		});
		
		
		exitG.setCursor(Cursor.HAND);
		exitG.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
			System.exit(0);
			}
			
			});
			
		
		root.getChildren().addAll(bg,canvas,grid);
		scene = new Scene(root);
		

}

public Stage getStage() {
    return stage;
}

public void setGamescreen(GameScreen gamescreen) {
	this.gamescreen = gamescreen;
}
public void setChoosemode(ChooseMode choosemode) {
	this.choosemode = choosemode;
}

public Scene getScene() {

	 	return scene;
}
	public void playAudio(){
		audioClip=new AudioClip("file:menu.mp3");
		audioClip.play();
	}
}