package factory;

import Interfaces.IFruitNinja;

public class FruitFactory {
	public Fruits getFruit(String fruitType) {
	   if(fruitType.equalsIgnoreCase("ORANGE"))
			return new Orange();
		else if(fruitType.equalsIgnoreCase("PINEAPPLE"))
		return new Pineapple();
		else if(fruitType.equalsIgnoreCase("Apple"))
			return new Apple();
		else if (fruitType.equalsIgnoreCase("SWATERMELON"))
			return new SWaterMelon();
		else if(fruitType.equalsIgnoreCase("SCoconut"))
			return new SCoconut();
		else if(fruitType.equalsIgnoreCase("DBOMB"))
			return new DBomb();
		else if(fruitType.equalsIgnoreCase("FBOMB"))
			return new FBomb();
		else
			return null;
	 }
	
	
	
}
