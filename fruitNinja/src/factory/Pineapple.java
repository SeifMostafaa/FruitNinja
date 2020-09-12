package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class Pineapple extends Fruits implements IFruitNinja{
	private final int score=1;
	private  final String fruitType="PINEAPPLE";
	private  final Image completeImage=new Image("CompletePineapple.png");
	private  final Image slicedImage=new Image("slicedPineapple.png");
	private Image splashImage=new Image("PineAppleSplash.png");
	private boolean pineapple;
	public Pineapple(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
		setSplashImage(splashImage);
        setScore(1);
        setName("Pineapple");
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
		return null;
	}

	@Override
	public void setFruitsBool(boolean fruitState) {
		this.pineapple=fruitState;
		
	}

	@Override
	public boolean getFruitsState() {
		return pineapple;
	}


}
