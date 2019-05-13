package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class DBomb implements IFruitNinja{
	private final int score=-1;
	private  final String fruitType="DBomb";
	private  Image completeImage=new Image("CompleteDBomb.png");
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
		return "LOSEONELIFE";
	}

}
