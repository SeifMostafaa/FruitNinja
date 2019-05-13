package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class Orange implements IFruitNinja{
	private final int score=1;
	private  final String fruitType="ORANGE";
	private  Image completeImage=new Image("CompleteOrange.png");
	private  Image slicedImage;
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Image getImage(String imageType) {
		// TODO Auto-generated method stub
		if(imageType.equalsIgnoreCase("COMPLETE")) {
			return completeImage;
		}
		else 
			return slicedImage;
	}

	@Override
	public String getFruitType() {
		// TODO Auto-generated method stub
		return fruitType;
	}

	@Override
	public String getFruitSpecial() {
		// TODO Auto-generated method stub
		return null;
	}


}
