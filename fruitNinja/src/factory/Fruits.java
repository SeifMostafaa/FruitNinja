package factory;

import Game.ArcadeMode;
import Game.GameScreen;
import Interfaces.IFruitNinja;
import Interfaces.IStrategy;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public abstract class Fruits implements IFruitNinja {

   private Image completeImage;
   private Image slicedImage;
   private Image splashImage;
   private int score;
   private String name;
   boolean Sliced=false;
   private int speed;
   private ParallelTransition parallelTransition;
    public Image getCompleteImage() {
        return completeImage;
    }

    public void setCompleteImage(Image completeImage) {
        this.completeImage = completeImage;
    }

    public Image getSlicedImage() {
        return slicedImage;
    }

    public void setSlicedImage(Image slicedImage) {
        this.slicedImage = slicedImage;
    }

    public void setSplashImage(Image splashImage) {
        this.splashImage = splashImage;
    }

    public Image getSplashImage() {
        return splashImage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSliced() {
        return Sliced;
    }

    public void setSliced(boolean sliced) {
        Sliced = sliced;
    }

    public void setSpeed(int MinSpeed,int MaxSpeed) {
        Random random=new Random();
        speed=random.nextInt(MinSpeed)+MaxSpeed;
    }

    public void AddFruit(Node node){
        Random random=new Random();
        PathTransition pathTransition=new PathTransition();
        QuadCurve quadCurve=new QuadCurve();
        int x=random.nextInt(6)+1;
        switch (x){
            case 1:
                quadCurve.setStartX(0);
                quadCurve.setEndX(800);
                quadCurve.setControlX(300);
                quadCurve.setControlY(-300);
                break;
            case 2:
                quadCurve.setStartX(100);
                quadCurve.setEndX(700);
                quadCurve.setControlX(400);
                quadCurve.setControlY(-200);
                break;
            case 3:
                quadCurve.setStartX(200);
                quadCurve.setEndX(800);
                quadCurve.setControlX(400);
                quadCurve.setControlY(-100);
                break;
            case 4:
                quadCurve.setStartX(750);
                quadCurve.setEndX(150);
                quadCurve.setControlX(400);
                quadCurve.setControlY(-250);
                break;
            case 5:
                quadCurve.setStartX(550);
                quadCurve.setEndX(0);
                quadCurve.setControlX(350);
                quadCurve.setControlY(-100);
                break;
            case 6:
                quadCurve.setStartX(0);
                quadCurve.setEndX(900);
                quadCurve.setControlX(400);
                quadCurve.setControlY(-50);
                break;
        }
        pathTransition.setDuration(Duration.seconds(speed));
        pathTransition.setCycleCount(1);
        quadCurve.setStartY(650);
        quadCurve.setEndY(650);
        pathTransition.setNode(node);
        pathTransition.setPath(quadCurve);

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(node);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setByAngle(7200);
        rotateTransition.setDuration(Duration.seconds(20));



        parallelTransition=new ParallelTransition(rotateTransition,pathTransition);
        parallelTransition.play();


    }

    public void setParallelTransition(Boolean x) {
        if(x) parallelTransition.play();
        else parallelTransition.stop();
    }
    public void removeFruit(Rectangle node , Fruits fruit, double x, double y, Group group){ //throws the fruit down the screen

        ImageView imageView=new ImageView(fruit.getSplashImage());
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3),imageView);

        fadeTransition.setFromValue(0.5);
        fadeTransition.setToValue(0.0);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        group.getChildren().add(imageView);
        fadeTransition.play();
        node.setFill(new ImagePattern(fruit.getSlicedImage()));
        fruit.setSliced(true);
        fruit.setParallelTransition(false);
        fruit.setFruitsBool(false);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(node);
        translateTransition.setCycleCount(1);
        translateTransition.setToY(700);
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.play();
    }


    public int getSpeed() {
        return speed;
    }
}

