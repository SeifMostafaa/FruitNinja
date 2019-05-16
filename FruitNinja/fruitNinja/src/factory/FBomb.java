package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class FBomb extends Fruits implements IFruitNinja{
	private  final int score=0;
	private  final String fruitType="FBomb";
	private  final Image completeImage=new Image("CompleteFBomb.png");
	private  final Image slicedImage=new Image("CompleteFBomb.png");

	public FBomb(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
        setScore(-10000);
        setName("Fbomb");
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
		return "TERIMENATE";
	}

}
