package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class FBomb implements IFruitNinja{
	private  final int score=0;
	private  final String fruitType="FBomb";
	private  final Image completeImage=new Image("CompleteFBomb");
	private  final Image slicedImage=new Image("slicedFBomb.png");
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
		return "TERIMENATE";
	}

}
