package factory;
import javafx.scene.image.Image;
import Interfaces.IFruitNinja;

public class DBomb implements IFruitNinja{
	private final int score=-1;
	private  final String fruitType="DBomb";
	private  final Image completeImage=new Image("CompleteDBomb.png");
	private  final Image slicedImage=new Image("slicedDBomb.png");
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
		return "LOSEONELIFE";
	}

}
