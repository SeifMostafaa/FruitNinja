package factory;
import javafx.scene.image.Image;
import Interfaces.IFruitNinja;

public class Apple  extends Fruits implements IFruitNinja {
	private final int score=1;
	private  final String fruitType="Apple";
	private  final Image completeImage=new Image("CompleteApple.png");
	private  Image slicedImage=new Image("CompleteApple.png");
	
	public Apple(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
        setScore(5);
        setName("Apple");
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
		return null;
	}

}
