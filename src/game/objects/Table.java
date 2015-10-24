package game.objects;

import com.base.engine.core.Vector2f;
import com.base.engine.physics.BoundingCircle;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;

public class Table extends GObject implements Collides
{
	Collider collider;
	boolean density;
	
	public Table(float x, float y, float z) {
		super(x, y, z, 0.003f, "brown.png", "table001.obj");
		collider = new BoundingCircle(new Vector2f(0,0), 3f);
		density = true;
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
