package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class FBomb extends Fruits implements IFruitNinja{
	private  final int score=0;
	private  final String fruitType="FBomb";
	private  final Image completeImage=new Image("FBomb.png");
	private  final Image slicedImage=new Image("FBomb.png");
	private Image splashImage=new Image("WaterMelonSplash.png");
	private boolean fBomb;
	public FBomb(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
        setSplashImage(splashImage);
        setScore(0);
        setName("Fbomb");
		setFruitsBool(true);
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
		return "TERIMENATE";
	}
	@Override
	public void setFruitsBool(boolean fruitState) {
		this.fBomb=fruitState;
	}
	@Override
	public boolean getFruitsState() {
		return fBomb;
	}

}
