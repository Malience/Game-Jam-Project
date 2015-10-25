package game;

import com.base.engine.components.PhysicsComponent;
import com.base.engine.physics.Collider;

public interface Collides 
{
	public Collider getCollider1();
	public Collider getCollider2();
	public default Collider getCollider(){return getCollider1();}
	public boolean getDensity();
	public void setCollider(Collider collider);
	public void setDensity(boolean density);
	public default PhysicsComponent getComponent1()
	{
		return new PhysicsComponent(getCollider1(), getDensity());
	}
	public default PhysicsComponent getComponent2()
	{
		return new PhysicsComponent(getCollider2(), getDensity());
	}
}
