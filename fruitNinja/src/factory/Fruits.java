package factory;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

import java.util.Random;

public abstract class Fruits {

   private Image completeImage;
   private Image slicedImage;
   private int score;
   private String name;
   private ParallelTransition parallelTransition;
   int count=0;
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

    public void AddFruit(Node node){
        Random random=new Random();
        PathTransition pathTransition=new PathTransition();
        QuadCurve quadCurve=new QuadCurve();
        int x=random.nextInt(6)+1;
        System.out.println(x);
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

        pathTransition.setDuration(Duration.seconds(random.nextInt(4)+2));
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
    public void removeFruit( Node node ){ //throws the fruit down the screen


        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(node);
        translateTransition.setCycleCount(1);
        translateTransition.setToY(700);
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.play();
    }

	
}

