package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChooseMode   {
	ImageView bg = new ImageView();
	Scene scene ;
	GameScreen gamescreen ;
	MainMenu  menu ;
	DifficultyChoose difficultyChoose;
	Context context=new Context();
	 Canvas canvas = new Canvas(800,600);
     GraphicsContext gc = canvas.getGraphicsContext2D();
     AudioClip audioClip;
	Stage stage ;

	    public ChooseMode(Stage stage) {
	    	this.stage = stage;
	    }
		 
	public void preparescene(AudioClip audioClip) {

        this.audioClip=audioClip;
		Button timer=new Button();
		Button arcade=new Button ();
		Button classic=new Button();
		Button back=new Button ();

		Group root = new Group();

		GridPane grid=new GridPane();

		 Image background=new Image ("Wiki-background.jpg");
			bg.setImage(background);
			bg.setFitHeight(600);
			bg.setFitWidth(800);

			Image Arcade = new Image("Arcade Mode.png");
			Image Classic=new Image("Classic Mode.png");
			ImageView st = new ImageView();
			ImageView classi=new ImageView();

			classi.setImage(Classic);
			classi.setFitHeight(60);
			classi.setFitWidth(155);

			st.setImage(Arcade);
			st.setFitHeight(60);
			st.setFitWidth(155);
			
			Image Back = new Image("back.png");
			ImageView ex = new ImageView();
			ex.setImage(Back);
			ex.setFitHeight(50);
			ex.setFitWidth(140);
			
			grid.setMinSize(800, 400);
			grid.add(classic,0,0);
			grid.add(arcade, 0, 1);
			grid.add(back, 0, 2);
			
			grid.setVgap(7);
			grid.setHgap(7);
			
			GridPane.setHalignment(arcade, javafx.geometry.HPos.LEFT);
			GridPane.setHalignment(back, javafx.geometry.HPos.CENTER);
			grid.setAlignment(Pos.BOTTOM_CENTER);

			classic.setGraphic(classi);
			arcade.setGraphic(st);
			back.setGraphic(ex);
			classic.setBackground(null);
			arcade.setBackground(null);
			back.setBackground(null);
		 
		
			arcade.setCursor(Cursor.HAND);
			arcade.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					context=new Context();
					context.setStrategy(new ArcadeMode());
					  difficultyChoose.prepareScene(context,audioClip);
					  stage.setScene(difficultyChoose.getScene());				}
			});
			classic.setCursor(Cursor.HAND);
		    classic.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					context=new Context();
					context.setStrategy(new ClassicMode());
					difficultyChoose.prepareScene(context,audioClip);
					stage.setScene(difficultyChoose.getScene());
				}
			});
			back.setCursor(Cursor.HAND);
			back.setOnAction(new EventHandler<ActionEvent>() {
				
				
				@Override
				public void handle(ActionEvent event) {
				
				stage.setScene(menu.getScene());
				}
				
				
				});
			

			root.getChildren().addAll(bg,canvas,grid);
			scene = new Scene(root);
			
		  
}
	
	public void setMenu(MainMenu menu) {
		this.menu = menu;
	}
	public void setGamescreen(GameScreen gamescreen) {
		this.gamescreen = gamescreen;
	}
	public void setDifficultyChoose(DifficultyChoose difficultyChoose) {
		this.difficultyChoose = difficultyChoose;
	}
	public Scene getScene() {
	    	return scene;
	}
	public void playAudio(){
		audioClip=new AudioClip("file:menu.mp3");
		audioClip.play();
	}
}
