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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class ClassicMode implements IStrategy {
	History history = new History ();
    Timeline time;
    int Time=0;
    int seconds=0;
    int FullHearts;
    Stage stage;
    GameOver gameOver;
    ArrayList<Rectangle>     Hearts=new ArrayList<>();
    FruitFactory             fruitFactory = new FruitFactory();
    ArrayList<Rectangle>     fruitObjects=new ArrayList<>();
    ArrayList<factory.Fruits>Fruits=new ArrayList<>();
    Random random=new Random();
    int score=0;
    @Override
    public void dotime(Group root, Label label, Stage stage,GameOver gameOver) {
       this.stage=stage;
       this.gameOver=gameOver;
         time= new Timeline();
        KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub

                Time ++ ;
                seconds++;
                label.setText("Time : "+seconds);
                if(seconds==Time) {

                    if(Time>50&&Time%2==0)
                    { addfruit(root);
                      addfruit(root);
                    }
                    else if(Time>=15&&Time<50){
                        addfruit(root);
                    }
                    else if(Time<15&&Time%2==0)
                    {
                        addfruit(root);
                    }
                }
                if(seconds%10==0)
                    addBomb(root);
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
        ArrayList<String> FruitNames=new ArrayList<>();
        FruitNames.add("Orange");
        FruitNames.add("Pineapple");
        FruitNames.add("Apple");
        FruitNames.add("Swatermelon");
        FruitNames.add("Scoconut");

        Fruits fruits = fruitFactory.getFruit(FruitNames.get(random.nextInt(5)));
        if(Time<=10)
            fruits.setSpeed(4,4);
        else if(Time>=20&&Time<50)
            fruits.setSpeed(3,3);
        else
            fruits.setSpeed(2,2);
        Fruits.add(fruits);
        Rectangle rectangle = new Rectangle(75, 75);
        fruits.AddFruit(rectangle);
        CheckSlice(fruits.getSpeed(),fruits);
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
        for(int i=0;i<3;i++){
            FullHearts++;
            Rectangle heart=new Rectangle();
            heart.setFill(new ImagePattern(new Image("Heart.png")));
            heart.setHeight(40);
            heart.setWidth(40);
            Hearts.add(heart);
            hearts.getChildren().add(Hearts.get(i));}
    }

    @Override
    public void RemoveHeart() {
        if(FullHearts>0)
        {
            Hearts.get(FullHearts-1).setFill(new ImagePattern(new Image("HollowHeart.png")));
            FullHearts--;
            if(FullHearts==0)
            {
                time.stop();
                //TODO: Ediny ya youssef.
                SaveScore();
                gameOver.prepareScene(score,1);
                stage.setScene(gameOver.getScene());

            }
        }
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
                    RemoveHeart();
                if(Fruits.get(i).getName().equals("Fbomb")){
                    time.stop();
                    //TODO: Ediny ya youssef
                    SaveScore();
                    gameOver.prepareScene(score,1);
                    stage.setScene(gameOver.getScene());
                }

                Fruits.get(i).removeFruit(fruitObjects.get(i),Fruits.get(i));
                UpdateScore(Fruits.get(i));
                fruitObjects.remove(chosen);
                Fruits.remove(i);
            }
        }
    }

    @Override
    public int getSeconds() {
        return seconds;
    }

    @Override
    public int getTime() {
        return Time;
    }
    public void CheckSlice(int speed, Fruits node){

        Timeline timeline=new Timeline();
        KeyFrame end=new KeyFrame(Duration.seconds(speed), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(node.getName().equals("Fbomb")||node.getName().equals("Dbomb")){

                }
                else if(!node.isSliced()){

                    RemoveHeart();


                }

            }
        });

        timeline.setCycleCount(1);
        timeline.getKeyFrames().addAll(end);
        timeline.play();


    }

    @Override
    public void ResetGame() {
        time=new Timeline();
        Time=0;
        seconds=0;
        FullHearts=0;
        Hearts=new ArrayList<>();
        fruitFactory = new FruitFactory();
        fruitObjects=new ArrayList<>();
        Fruits=new ArrayList<>();
        score=0;
    }



	@Override
	public void SaveScore() {
		if ( score > history.loadClassic() )
			history.saveClassic(score);
		
	}
}
