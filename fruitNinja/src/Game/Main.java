package Game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	MainMenu MainMenu=new MainMenu(primaryStage);
    	GameScreen GameScreen=new GameScreen(primaryStage);
    	

    	GameScreen.prepareScene();
        primaryStage.setScene(GameScreen.getScene());
      
        primaryStage.show();
    }
}
