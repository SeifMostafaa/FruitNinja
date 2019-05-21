package Interfaces;
import javafx.scene.image.Image;
public interface IFruitNinja {
	public int getScore();
	public Image getImage(String imageType);
	public String getFruitType();
	public String getFruitSpecial();
	public void setFruitsBool(boolean fruitState);
	public boolean getFruitsState();
}
