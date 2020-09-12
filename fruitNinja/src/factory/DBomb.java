package factory;
import javafx.scene.image.Image;
import Interfaces.IFruitNinja;

public class DBomb extends Fruits implements IFruitNinja{
	private final int score=-10;
	private  final String fruitType="DBomb";
	private  final Image completeImage=new Image("CompleteDBomb.png");
	private  final Image slicedImage=new Image("CompleteDBomb.png");
	private Image splashImage=new Image("DBombSplash.png");
	private boolean dBomb;
	
	public DBomb(){
        setCompleteImage(completeImage);
        setSlicedImage(slicedImage);
        setSplashImage(splashImage);
        setScore(-10);
        setName("Dbomb");
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
		return "LOSEONELIFE";
	}
	@Override
	public void setFruitsBool(boolean fruitState) {
		this.dBomb=fruitState;
	}
	@Override
	public boolean getFruitsState() {
		return dBomb;
	}

}
