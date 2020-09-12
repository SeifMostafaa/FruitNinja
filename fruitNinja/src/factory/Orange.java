package factory;

import javafx.scene.image.Image;

import Interfaces.IFruitNinja;

public class Orange extends Fruits implements IFruitNinja{
	private  final int score=1;
	private  final String fruitType="ORANGE";
	private  final Image completeImage=new Image("Orange.png");
	private  final Image slicedImage=new Image("SlicedOrange.png");
	private Image splashImage=new Image("OrangeSplash.png");
	private boolean orange;
	public Orange(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
		setSplashImage(splashImage);
        setScore(1);
        setName("Orange");
		setFruitsBool(true);

    }

	@Override
	public int getScore() {
		return score;
	}
	

	@Override
	public Image getImage(String imageType) {
		if(imageType.equalsIgnoreCase("COMPLETE")) {
			return completeImage;
		}
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
		this.orange=fruitState;
	}

	@Override
	public boolean getFruitsState() {
		return orange;
	}


}
