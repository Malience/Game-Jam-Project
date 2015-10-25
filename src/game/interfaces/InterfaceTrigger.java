package game.interfaces;

import com.base.engine.physics.Collider;

import game.Collides;

public class InterfaceTrigger implements Collides
{
	Collider collider;
	boolean density;
	boolean triggered;
	float x,y,z;
	
	
	public InterfaceTrigger(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	@Override
	public Collider getCollider() {
		// TODO Auto-generated method stub
		return collider;
	}

	@Override
	public boolean getDensity() {
		// TODO Auto-generated method stub
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
