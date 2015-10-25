package game.interfaces;

import com.base.engine.core.GameObject;

import game.GObject;
import game.RObject;

public class E extends RObject
{
	public GameObject o;
	public E(float x, float y, float z)
	{
		super(x, y, z);
		
		setScale(0.01f);
		setTexture("the e transparent.png");
		setMesh("plane64.obj");	
	}
}
