package factory;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

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

    public void AddFruit(Node node,double x,double y){

        TranslateTransition transition=new TranslateTransition();
        transition.setNode(node);
        transition.setCycleCount(1);
        transition.setToY(y);
        transition.setToX(x);
        transition.setDuration(Duration.seconds(1));
      

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setNode(node);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setByAngle(7200);
        rotateTransition.setDuration(Duration.seconds(20));
        


        parallelTransition=new ParallelTransition(rotateTransition,transition);
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

