package factory;
import javafx.scene.image.Image;
import Interfaces.IFruitNinja;

public class SCoconut implements IFruitNinja{
	private  final int score=5;
	private  final String fruitType="COCONUT";
	private  final  Image completeImage=new Image("CompleteCoconut.png");
	private  final Image slicedImage=new Image("slicedCoconut.png");
	
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
