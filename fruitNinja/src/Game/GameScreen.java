
package Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import factory.*;


public class GameScreen {
	Label  lb  = new Label();
	private final Integer starttime=15;
	 private Integer seconds= starttime;
	 
int  th = 15 ;
    Stage stage;
    Scene scene;
    Random random=new Random();
    FruitFactory fruitFactory = new FruitFactory();
    ArrayList<Rectangle>fruitObjects=new ArrayList<>();
    ArrayList<Fruits>Fruits=new ArrayList<>();
    
    Group root=new Group();
    public GameScreen(Stage stage){this.stage=stage;}
    public void prepareScene(){
    	

    	 
    	 lb.setText("Time: 15");
    	 
    	  lb.setFont(Font.font("Forte", 32));
    	  Color c = Color.web("211f1f",1.0);
    	  lb.setTextFill(c);
    	 Stage windows;
    	 
    	 
    	
    	 
      
        scene=new Scene(root,1000,800);
        ImageView image=new ImageView(new Image("Wiki-background.jpg"));
        image.setFitHeight(800);
        image.setFitWidth(1000);
        root.getChildren().addAll(image);
       

      
       

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node chosen=event.getPickResult().getIntersectedNode();
                if(chosen!=null){
                for(int i=0;i<fruitObjects.size();i++){
                    if(chosen.equals(fruitObjects.get(i))){
                        System.out.println(Fruits.get(i).getName());
                        fruitObjects.get(i).setFill(new ImagePattern(Fruits.get(i).getSlicedImage()));
                        Fruits.get(i).removeFruit(fruitObjects.get(i));
                        //Code for is sliced and transition
                        fruitObjects.remove(chosen);
                        Fruits.get(i).setParallelTransition(false);
                        Fruits.remove(i);



                    }
                }
                }
            }
        });
        doTime();
        
        HBox layout= new HBox(5);
        layout.getChildren().add(lb);
        root.getChildren().add(layout);
        
    
        
       
    }
    


    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    
    private void doTime() {
     Timeline time= new Timeline();
     
     
     KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
th -- ;
		    seconds--;
		    lb.setText("Time : "+seconds.toString());
		    if(seconds<=0){
		    	
		    	System.exit(0);
		     time.stop();
		    }
	
		    if(seconds==th){
		    	if (th >= 10)
		    	addfruit();
		    	else
		    	{
		    		addfruit();
		    		
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
    
    
    public void addfruit() {
    	ArrayList <String> FruitNames=new ArrayList<>();
    	FruitNames.add("Orange");
    	FruitNames.add("Pineapple");
    	FruitNames.add("Apple");
    	FruitNames.add("Swatermelon");
    	FruitNames.add("Scoconut");
    	FruitNames.add("Dbomb");
    	FruitNames.add("Fbomb");
    	Fruits fruits = fruitFactory.getFruit(FruitNames.get(random.nextInt(6)+1));
       
    	Fruits.add(fruits);
        Rectangle rectangle = new Rectangle(75, 75);
        rectangle.setLayoutX(100 + random.nextDouble() * 400);
        rectangle.setLayoutY(500);
        fruits.AddFruit(rectangle,random.nextDouble()*100,-random.nextDouble()*400);
        rectangle.setFill(new ImagePattern(fruits.getCompleteImage()));
        fruitObjects.add(rectangle);
        root.getChildren().addAll(rectangle);
    }
    
}
