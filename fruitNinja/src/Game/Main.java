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
    	primaryStage.initStyle(StageStyle.UNDECORATED);
    	
        ChooseMode choosemode =new ChooseMode (primaryStage);
    	GameScreen GameScreen=new GameScreen(primaryStage);
    	MainMenu MainMenu=new MainMenu(primaryStage , GameScreen);
        GameOver gameOver=new GameOver(primaryStage);

        MainMenu.setChoosemode(choosemode);
        choosemode.setGamescreen(GameScreen);
        choosemode.setMenu(MainMenu);
        GameScreen.setGameOver(gameOver);
    	gameOver.setMainMenu(MainMenu);
    	gameOver.setChooseMode(choosemode);

    	MainMenu.prepareScene();
    	choosemode.preparescene();

    	
        primaryStage.setScene(MainMenu.getScene());
        primaryStage.show();
    }
}