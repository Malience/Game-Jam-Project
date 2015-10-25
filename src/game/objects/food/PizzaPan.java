package game.objects.food;

import game.GObject;
import game.objects.Furnishing;

public class PizzaPan extends GObject
{
	public PizzaPan(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.1f);
		setTexture("fog2.png");
		setMesh("pizzapan2.obj");	
	}

}
