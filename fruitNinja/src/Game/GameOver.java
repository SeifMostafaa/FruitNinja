package Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOver{
	History history = new History ();
	Stage stage;
	Scene scene;
	MainMenu mainMenu;
	ChooseMode chooseMode;
	AudioClip audioClip;
	 GridPane grid=new GridPane();
String score;
	public GameOver(Stage stage) {
		this.stage = stage;
	}

	public void prepareScene(int Score , int slot,AudioClip audioClip) {
		this.audioClip=audioClip;

		score = Integer.toString(Score);
		Group root=new Group();
		
	
		Label highscore=new Label();
		
		if ( slot ==1 )
		highscore.setText(Integer.toString(history.loadClassic()));
		if ( slot ==2 )
			highscore.setText(Integer.toString(history.loadArcade()));
		
		highscore.setLayoutX(340);
		highscore.setLayoutY(520);
		highscore.setFont(Font.font("Forte", 42));
		Color c1 = Color.web("FLORALWHITE",1.0);
		highscore.setTextFill(c1);
		
		Label yourscore=new Label();
		yourscore.setText(score);
		yourscore.setLayoutX(660);
		yourscore.setLayoutY(520);
		yourscore.setFont(Font.font("Forte", 42));
		Color c2 = Color.web("FLORALWHITE",1.0);
		yourscore.setTextFill(c2);
		
		Button back=new Button();
		Image Back = new Image("backtomain.png");
		ImageView ex = new ImageView();
		ex.setImage(Back);
		ex.setFitHeight(60);
		ex.setFitWidth(145);
		
		back.setCursor(Cursor.HAND);
		Button retry=new Button();
		Image Retry = new Image("ChooseMode.png");
		ImageView ex2 = new ImageView();
		ex2.setImage(Retry);
		ex2.setFitHeight(60);
		ex2.setFitWidth(145);
		retry.setCursor(Cursor.HAND);
		
		

		back.setGraphic(ex);
		retry.setGraphic(ex2);
		retry.setBackground(null);
		back.setBackground(null);
	
		
		VBox vbox=new VBox();
		vbox.getChildren().addAll(retry,back);
		//vbox.setAlignment(Pos.BASELINE_CENTER);
		vbox.setLayoutY(450);
		vbox.setLayoutX(333);
		vbox.setSpacing(10);
		HBox hbox = new HBox();
		hbox.getChildren().addAll(highscore,yourscore);
		hbox.setLayoutX(270);
		hbox.setLayoutY(400);
		hbox.setSpacing(170);
		

		retry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				audioClip.stop();
				chooseMode.playAudio();
				stage.setScene(chooseMode.getScene());
			}
		});
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				audioClip.stop();
				mainMenu.playAudio();
				stage.setScene(mainMenu.getScene());
			}
			
		});
		
		ImageView image=new ImageView(new Image("GameOver.jpg"));
		image.setFitHeight(600);
        image.setFitWidth(800);
		root.getChildren().addAll(image,vbox,hbox);
		scene = new Scene(root,800,600);
	}
	public Scene getScene() {
		return scene;
	}
	


	public void setMenu(MainMenu mainMenu) {

	}
	public Stage getStage() {
		return stage;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public void setChooseMode(ChooseMode chooseMode) {
		this.chooseMode = chooseMode;
	}
}
