package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class SWaterMelon implements IFruitNinja {
	
	private final int score=5;
	private  final String fruitType="WATERMELON";
	private  Image completeImage=new Image("CompleteWaterMelon.png");
	private  Image slicedImage;
	
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Image getImage(String imageType) {
		if(imageType.equalsIgnoreCase("COMPLETE"))
			return completeImage;
		else 
			return slicedImage;
	}

	@Override
	public String getFruitType() {
		return fruitType;
	}

	@Override
	public String getFruitSpecial() {
		// TODO Auto-generated method stub
		return null;
	}



}
