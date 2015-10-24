package game;

import com.base.engine.components.PhysicsComponent;
import com.base.engine.physics.Collider;

public interface Collides 
{
	public Collider getCollider();
	public boolean getDensity();
	public default PhysicsComponent getComponent()
	{
		return new PhysicsComponent(getCollider(), getDensity());
	}
}
