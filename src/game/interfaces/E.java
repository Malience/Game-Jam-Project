package game.interfaces;

import game.GObject;

public class E extends GObject
{
	public E(float x, float y, float z)
	{
		super(x, y, z);
		
		setScale(0.01f);
		setTexture("the e transparent.png");
		setMesh("plane64.obj");	
	}
}
