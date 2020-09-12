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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class ArcadeMode implements IStrategy {
    AudioClip audioClip;
    History history = new History ();
    int Time=60;
    int seconds=60;
    int Combo=0;
    Timeline time;
    Stage stage;
    GameOver gameOver;
    Group group;
    FruitFactory fruitFactory = new FruitFactory();
    ArrayList<Rectangle> fruitObjects=new ArrayList<>();
    ArrayList<factory.Fruits>Fruits=new ArrayList<>();
    Random random=new Random();
    int score=0;

    @Override
    public void EasyDoTime(Group root, Label label, Stage stage, GameOver gameOver,AudioClip audioClip) {
        this.audioClip=audioClip;
        time= new Timeline();
        this.group=root;
        this.stage=stage;
        this.gameOver=gameOver;
        KeyFrame  frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

                Time -- ;
                seconds--;
                label.setText("Time : "+seconds);
                if(seconds<=0){
                    audioClip.stop();
                    time.stop();
                    SaveScore();
                    AudioClip audioClip1=new AudioClip("file:Fbomb.mp3");
                    gameOver.prepareScene(score , 2 ,audioClip1);
                    stage.setScene(gameOver.getScene());
                }

                if(seconds==Time) {

                    if(Time>50&&Time%3==0)
                    {
                        addEasyFruit(root);
                    }
                    else if(Time>=15&&Time<50){
                        addEasyFruit(root);
                    }
                    else if(Time<15)
                    {
                        addEasyFruit(root);
                    }
                }

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
    public void MediumDoTime(Group root, Label label, Stage stage,GameOver gameOver,AudioClip audioClip) {
        this.audioClip=audioClip;
        time= new Timeline();
         this.group=root;
         this.stage=stage;
         this.gameOver=gameOver;
         KeyFrame  frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

                Time -- ;
                seconds--;
                label.setText("Time : "+seconds);
                if(seconds<=0){

                   //TODO: 
                	
                	audioClip.stop();
                    time.stop();
                    SaveScore();
                    AudioClip audioClip1=new AudioClip("file:Fbomb.mp3");
                    audioClip1.play();
                    gameOver.prepareScene(score , 2 ,audioClip1);
                    stage.setScene(gameOver.getScene());

                }

                if(seconds==Time) {
                    if(Time==59)
                        addBomb(root);
                    if(Time>50&&Time%2==0)
                    { addMediumFruit(root);
                    }
                    else if(Time>=25&&Time<50){
                        addMediumFruit(root);
                    }
                    else if(Time<25)
                    {
                        addMediumFruit(root);
                        addMediumFruit(root);
                    }
                }
                if(seconds%10==0)
                    addBomb(root);
               if(seconds%20==0)
               {
                   addBomb(root);
                   addBomb(root);
               }
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
    public void HardDoTime(Group root, Label label, Stage stage, GameOver gameOver,AudioClip audioClip) {
        this.audioClip=audioClip;
        time= new Timeline();
        this.group=root;
        this.stage=stage;
        this.gameOver=gameOver;
        KeyFrame  frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

                Time -- ;
                seconds--;
                label.setText("Time : "+seconds);
                if(seconds<=0){

                    //TODO:

                    audioClip.stop();
                    time.stop();
                    SaveScore();
                    AudioClip audioClip1=new AudioClip("file:Fbomb.mp3");
                    audioClip1.play();
                    gameOver.prepareScene(score , 2 ,audioClip1);
                    stage.setScene(gameOver.getScene());

                }

                if(seconds==Time) {
                    if(Time==59)
                        addBomb(root);
                    if(Time>50)
                    { addHardFruit(root);
                    }
                    else if(Time>=25&&Time<50){
                        addHardFruit(root);
                        addHardFruit(root);
                    }
                    else if(Time<23)
                    {
                        addHardFruit(root);
                        addHardFruit(root);
                        addHardFruit(root);
                    }
                }

                if(seconds%10==0)
                { addBomb(root);
                  addBomb(root);
                }
                if(seconds%20==0)
                {
                    addBomb(root);
                    addBomb(root);
                    addBomb(root);
                }
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
    public void addEasyFruit(Group root) {
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
            fruits.setSpeed(4,3);
        else
            fruits.setSpeed(3,3);
        Fruits.add(fruits);
        Rectangle rectangle = new Rectangle(75, 75);
        fruits.AddFruit(rectangle);
        rectangle.setFill(new ImagePattern(fruits.getCompleteImage()));
        fruitObjects.add(rectangle);
        root.getChildren().addAll(rectangle);
    }

    @Override
    public void addMediumFruit(Group root) {

        ArrayList <String> FruitNames=new ArrayList<>();
        FruitNames.add("Orange");
        FruitNames.add("Pineapple");
        FruitNames.add("Apple");
        FruitNames.add("Swatermelon");
        FruitNames.add("Scoconut");

        Fruits fruits = fruitFactory.getFruit(FruitNames.get(random.nextInt(5)));
        if(Time>=50)
            fruits.setSpeed(4,3);
        else if(Time>=20&&Time<50)
            fruits.setSpeed(3,3);
        else
            fruits.setSpeed(3,2);
        Fruits.add(fruits);
        Rectangle rectangle = new Rectangle(75, 75);
        fruits.AddFruit(rectangle);
        rectangle.setFill(new ImagePattern(fruits.getCompleteImage()));
        fruitObjects.add(rectangle);
        root.getChildren().addAll(rectangle);
    }

    @Override
    public void addHardFruit(Group root) {
        ArrayList <String> FruitNames=new ArrayList<>();
        FruitNames.add("Orange");
        FruitNames.add("Pineapple");
        FruitNames.add("Apple");
        FruitNames.add("Swatermelon");
        FruitNames.add("Scoconut");

        Fruits fruits = fruitFactory.getFruit(FruitNames.get(random.nextInt(5)));
        if(Time>=50)
            fruits.setSpeed(3,3);
        else if(Time>=20&&Time<50)
            fruits.setSpeed(3,2);
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
    public void SliceFruit(Node chosen,double x,double y) {
        for(int i=0;i<fruitObjects.size();i++){

            if(chosen.equals(fruitObjects.get(i))){
                if(Fruits.get(i).getName().equalsIgnoreCase("Dbomb")==false && Fruits.get(i).getName().equals("Fbomb")==false){
                    addCombo();
                    AudioClip audioClip=new AudioClip("file:splash.mp3");
                    audioClip.play();
                }
                if(Fruits.get(i).getName().equals("Dbomb"))
                {   breakCombo();
                    AudioClip audioClip=new AudioClip("file:Dbomb.mp3");
                    audioClip.play();
                }
                if(Fruits.get(i).getName().equals("Fbomb")){
                    AudioClip audioClip=new AudioClip("file:Fbomb.mp3");
                    audioClip.play();
                    time.stop();
                    SaveScore();
                    gameOver.prepareScene(score , 2 ,audioClip);
                    stage.setScene(gameOver.getScene());
                    //TODO: Fatal bomb sliced.
                    //TODO: time.stop + GameOver scene.
                }

                Fruits.get(i).removeFruit(fruitObjects.get(i),Fruits.get(i),x,y,group);
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

    @Override
    public void addCombo() {
        Combo++;
    }

    @Override
    public boolean VerifyCombo() {
        if(Combo>=3){
            score+=Combo*2;
            return true;
        }
        Combo=0;
        return false;
    }
    @Override
    public void breakCombo() {
        Combo=0;
    }
    @Override
    public int getCombo() {
        return Combo;
    }
}
