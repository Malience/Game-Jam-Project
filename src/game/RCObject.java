package game;

import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

public class RCObject extends RObject implements Collides
{
	private Collider collider1;
	private Collider collider2;
	private boolean density;
	
	public RCObject(float x, float y, float z)
	{
		super(x,y,z);
	}

	@Override
	public Collider getCollider1() {
		return collider1;
	}
	
	@Override
	public Collider getCollider2() {
		return collider2;
	}

	@Override
	public boolean getDensity() {
		return density;
	}
	
	@Override
	public void setCollider(Collider collider) {
		this.collider1 = collider;
		if(collider.getType() == Collider.TYPE_AABB)
			this.collider2 = (Collider) new AABB((AABB)collider);
	}

	@Override
	public void setDensity(boolean density) {
		this.density = density;
	}
	
}