package game.interfaces;

import com.base.engine.core.GameObject;

import game.GObject;
import game.RObject;

public class GameOver extends RObject
{
	public GameObject o;
	public GameOver(float x, float y, float z)
	{
		super(x, y, z);
		
		setScale(0.01f);
		setTexture("game over.png");
		setMesh("plane64.obj");	
	}
}
