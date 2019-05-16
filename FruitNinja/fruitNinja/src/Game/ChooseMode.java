package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChooseMode   {
	ImageView bg = new ImageView();
	Scene scene ;
	GameScreen gamescreen ;
	MainMenu  menu ;
	
	 Group root = new Group();
	 Canvas canvas = new Canvas(800,600);
     GraphicsContext gc = canvas.getGraphicsContext2D();
	 GridPane grid=new GridPane();
	    Button timer=new Button();
	    Button arcade=new Button ();
	    Button back=new Button ();
	    Stage stage ;
	    public ChooseMode(Stage stage) {
	    	this.stage = stage;
	    }
		 
	public void preparescene() {
		
		
		

		 
		 Image background=new Image ("Wiki-background.jpg");
			bg.setImage(background);
			bg.setFitHeight(600);
			bg.setFitWidth(800);

			Image Arcade = new Image("Arcade Mode.png");
			ImageView st = new ImageView();
			st.setImage(Arcade);
			st.setFitHeight(60);
			st.setFitWidth(155);
			
			Image Back = new Image("back.png");
			ImageView ex = new ImageView();
			ex.setImage(Back);
			ex.setFitHeight(50);
			ex.setFitWidth(140);
			
			grid.setMinSize(800, 400);
			grid.add(arcade, 0, 0);
			grid.add(back, 0, 1);
			
			grid.setVgap(7);
			grid.setHgap(7);
			
			GridPane.setHalignment(arcade, javafx.geometry.HPos.LEFT);
			GridPane.setHalignment(back, javafx.geometry.HPos.CENTER);
			grid.setAlignment(Pos.BOTTOM_CENTER);
		 
			arcade.setGraphic(st);
			back.setGraphic(ex);
			arcade.setBackground(null);
			back.setBackground(null);
		 
		
		   
			arcade.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					  gamescreen.prepareScene();
					  stage.setScene(gamescreen.getScene());				}
			});
		    
			
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
	public Scene getScene() {
		return scene;
	}
}
