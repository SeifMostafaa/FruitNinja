package factory;
import javafx.scene.image.Image;
import Interfaces.IFruitNinja;

public class SCoconut extends Fruits implements IFruitNinja{
	private   int score=1;
	private  final String fruitType="COCONUT";
	private  final  Image completeImage=new Image("CompleteCoconut.png");
	private  final Image slicedImage=new Image("slicedCoconut.png");
	private Image splashImage=new Image("CoconutSplash.png");
	private boolean Scoconut;
	
	public SCoconut(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
		setSplashImage(splashImage);
        setScore(1);
        setName("Coconcut");
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
		this.Scoconut=fruitState;
		
	}
	@Override
	public boolean getFruitsState() {
		return Scoconut;
	}

}
