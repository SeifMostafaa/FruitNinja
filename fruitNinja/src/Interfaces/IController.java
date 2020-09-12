package Interfaces;

import Game.Context;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public interface IController {
	
	public void sliceOn(Scene scene ,Context context, Label Score);
	
	public void sliceOff(Scene scene, Context context, Label bonus, Label Score);

}
