package game.objects;

import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;

public class Furnishing extends GObject implements Collides
{
	Collider collider;
	boolean density;
	
	public Furnishing(float x, float y, float z)
	{
		super(x,y,z);
	}
	
	@Override
	public Collider getCollider() {
		return collider;
	}

	@Override
	public boolean getDensity() {
		return density;
	}
	
	@Override
	public void setCollider(Collider collider) {
		this.collider = collider;
	}

	@Override
	public void setDensity(boolean density) {
		this.density = density;
	}
}
