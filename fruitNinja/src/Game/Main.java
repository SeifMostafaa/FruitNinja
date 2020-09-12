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
        DifficultyChoose difficultyChoose=new DifficultyChoose(primaryStage);

        MainMenu.setChoosemode(choosemode);
        choosemode.setGamescreen(GameScreen);
        choosemode.setMenu(MainMenu);
        choosemode.setDifficultyChoose(difficultyChoose);
        difficultyChoose.setGameScreen(GameScreen);
        difficultyChoose.setChooseMode(choosemode);
        GameScreen.setGameOver(gameOver);
        gameOver.setMainMenu(MainMenu);
    	gameOver.setChooseMode(choosemode);


    	MainMenu.prepareScene();


    	
        primaryStage.setScene(MainMenu.getScene());
        primaryStage.show();
    }
}