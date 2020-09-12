package factory;
import javafx.scene.image.Image;
import Interfaces.IFruitNinja;

public class Apple  extends Fruits implements IFruitNinja {
	private final int score=1;
	private  final String fruitType="Apple";
	private  final Image completeImage=new Image("CompleteApple.png");
	private  Image slicedImage=new Image("slicedApple.png");
	private Image splashImage=new Image("AppleSplash.png");
	private boolean apple;
	
	public Apple(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
        setScore(1);
        setName("Apple");
        setSplashImage(splashImage);
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
		this.apple=fruitState;
	}

	@Override
	public boolean getFruitsState() {
		return apple;
	}

}
