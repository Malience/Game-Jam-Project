package game.interfaces;

import game.GObject;

public class E extends GObject
{
	public E(float x, float y, float z)
	{
		super(x, y, z);
		
		setScale(0.1f);
		setTexture("fog2.png");
		setMesh("plane3.obj");	
	}
}
