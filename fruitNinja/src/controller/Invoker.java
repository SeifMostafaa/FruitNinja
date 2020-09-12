package controller;

import Game.Context;
import Interfaces.IController;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Invoker implements IController {

	private static Invoker instance;
	
	public static Invoker getInstance() {
		
		if (instance == null)
			instance = new Invoker();
		
		return instance;
	}

	@Override
	public void sliceOn(Scene scene, Context context, Label Score) {
		
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node chosen=event.getPickResult().getIntersectedNode();
                if(chosen!=null){
                    context.SliceFruit(chosen,event.getX(),event.getY());
                    Score.setText("Score: "+context.getScore());

                }
            }
        });
		
	}

	@Override
	public void sliceOff(Scene scene, Context context, Label bonus, Label Score) {
		
		 scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                if(context.VerifyCombo()){
	                    Score.setText("Score: "+context.getScore());
	                    FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),bonus);
	                    fadeTransition.setFromValue(1.0);
	                    fadeTransition.setToValue(0.0);
	                    bonus.setText("Combo "+context.getCombo());
	                    bonus.setLayoutX(event.getX());
	                    bonus.setLayoutY(event.getY());
	                    fadeTransition.play();
	                    context.breakCombo();
	                }
	            }
	        });
		
	}
	
	
	
}
