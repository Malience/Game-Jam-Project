package game.objects;

import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;

public class Wall extends GObject implements Collides
{
	Collider collider;
	boolean density;
	
	public Wall(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.005f);
		setTexture("bricks2.jpg");
		setMesh("wall108_108.obj");
		
	}

	@Override
	public Collider getCollider() {
		return collider;
	}

	@Override
	public boolean getDensity() {
		return density;
	}

}
