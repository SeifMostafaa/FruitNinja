package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class SWaterMelon extends Fruits implements IFruitNinja {
	
	private  final int score=5;
	private  final String fruitType="WATERMELON";
	private  final Image completeImage=new Image("CompleteWaterMelon.png");
	private  final Image slicedImage=new Image("slicedWatermelon.png");
	
	public SWaterMelon(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
        setScore(10);
        setName("WaterMelon");
    }
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
