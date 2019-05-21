package Game;

import Interfaces.IStrategy;
import factory.FruitFactory;
import factory.Fruits;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class ArcadeMode implements IStrategy {
History history = new History ();
    int Time=60;
    int seconds=60;
    Timeline time;
    Stage stage;
    GameOver gameOver;
    FruitFactory fruitFactory = new FruitFactory();
    ArrayList<Rectangle> fruitObjects=new ArrayList<>();
    ArrayList<factory.Fruits>Fruits=new ArrayList<>();
    Random random=new Random();
    int score=0;
    @Override
    public void dotime(Group root, Label label, Stage stage,GameOver gameOver) {
         time= new Timeline();
         KeyFrame  frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

                Time -- ;
                seconds--;
                label.setText("Time : "+seconds);
                if(seconds<=0){

                   //TODO: 
                	
                	
                    time.stop();
                    SaveScore();
                    gameOver.prepareScene(score , 2 );
                    stage.setScene(gameOver.getScene());

                }

                if(seconds==Time) {

                    if(Time>50&&Time%2==0)
                    { addfruit(root);
                    }
                    else if(Time>=15&&Time<50){
                        addfruit(root);
                    }
                    else if(Time<15)
                    {
                        addfruit(root);
                        addfruit(root);
                    }
                }

               // if(seconds%10==0)
               //     addBomb(root);
                // TODO: DBomb action
            }
        });
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if(time!=null){
            time.stop();
        }
        time.play();


    }


    @Override
    public void addfruit(Group root) {

        ArrayList <String> FruitNames=new ArrayList<>();
        FruitNames.add("Orange");
        FruitNames.add("Pineapple");
        FruitNames.add("Apple");
        FruitNames.add("Swatermelon");
        FruitNames.add("Scoconut");

        Fruits fruits = fruitFactory.getFruit(FruitNames.get(random.nextInt(5)));
        if(Time>=50)
            fruits.setSpeed(4,4);
        else if(Time>=20&&Time<50)
            fruits.setSpeed(3,3);
        else
            fruits.setSpeed(2,2);
        Fruits.add(fruits);
        Rectangle rectangle = new Rectangle(75, 75);
        fruits.AddFruit(rectangle);
        rectangle.setFill(new ImagePattern(fruits.getCompleteImage()));
        fruitObjects.add(rectangle);
        root.getChildren().addAll(rectangle);
    }

    @Override
    public void addBomb(Group root) {
        ArrayList<String>BombsNames=new ArrayList<>();
        BombsNames.add("DBomb");
        BombsNames.add("FBomb");
        Fruits Bomb=fruitFactory.getFruit(BombsNames.get(random.nextInt(2)));
        Bomb.setSpeed(3,3);
        Fruits.add(Bomb);
        Rectangle rectangle = new Rectangle(75, 75);
        Bomb.AddFruit(rectangle);
        rectangle.setFill(new ImagePattern(Bomb.getCompleteImage()));
        fruitObjects.add(rectangle);
        root.getChildren().addAll(rectangle);
    }

    @Override
    public void UpdateScore(Fruits fruits) {
        score+=fruits.getScore();
        if(score<0)
            score=0;


    }

    @Override
    public void AddHearts(HBox hearts) {

    }

    @Override
    public void RemoveHeart() {

    }
    @Override
    public int getSeconds(){
        return seconds;
    }
    public int getTime(){
        return Time;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void SliceFruit(Node chosen) {
        for(int i=0;i<fruitObjects.size();i++){

            if(chosen.equals(fruitObjects.get(i))){
                if(Fruits.get(i).getName().equals("Dbomb"))

                if(Fruits.get(i).getName().equals("Fbomb")){
                    time.stop();
                    SaveScore();
                    gameOver.prepareScene(score,2);
                    stage.setScene(gameOver.getScene());
                    //TODO: Fatal bomb sliced.
                    //TODO: time.stop + GameOver scene.
                }

                Fruits.get(i).removeFruit(fruitObjects.get(i),Fruits.get(i));
                UpdateScore(Fruits.get(i));
                fruitObjects.remove(chosen);
                Fruits.remove(i);
            }
        }
    }

    @Override
    public void ResetGame() {
        time= new Timeline();
        Time=60;
        seconds=60;
        fruitFactory = new FruitFactory();
        fruitObjects=new ArrayList<>();
        Fruits=new ArrayList<>();
        score=0;
    }
    @Override
	public void SaveScore() {
		if ( score > history.loadArcade() )
			history.saveArcade(score);
		
	}
}
