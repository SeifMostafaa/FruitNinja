package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class SWaterMelon extends Fruits implements IFruitNinja {
	
	private   int score=1;
	private   String fruitType="WATERMELON";
	private  final Image completeImage=new Image("CompleteWaterMelon.png");
	private  final Image slicedImage=new Image("slicedWatermelon.png");
	private Image splashImage=new Image("WaterMelonSplash.png");
	private boolean Swatermelon;
	
	public SWaterMelon(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
		setSplashImage(splashImage);
        setScore(5);
        setName("WaterMelon");
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
		this.Swatermelon=fruitState;
		
	}
	@Override
	public boolean getFruitsState() {
		return Swatermelon;
	}
}
