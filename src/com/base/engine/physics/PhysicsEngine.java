package com.base.engine.physics;

import java.util.ArrayList;
import java.util.HashMap;

import com.base.engine.components.PhysicsComponent;
import com.base.engine.core.Vector3f;

public class PhysicsEngine 
{
	HashMap<Collider, IntersectData> collisions;
	public static PhysicsComponent important;
	
	public PhysicsEngine()
	{
		collisions = new HashMap<Collider, IntersectData>();
	}
	
	
	public void handleCollisions(PhysicsComponent object)
	{
		if(object != important)
		{
			//System.out.println("Collide Start!");
			important.getCollider().setCenter(important.getTransform().getPos());
			object.getCollider().setCenter(object.getTransform().getPos());
			
			important.getCollider().setRot(important.getTransform().getRot());
			object.getCollider().setRot(object.getTransform().getRot());
				IntersectData i = object.getCollider().intersect(important.getCollider());
				if(object.getDensity() && i.getDoesIntersect())
				{
					important.getTransform().setPos(important.getTransform().getPos().sub(new Vector3f(i.getDirection().getX(), 0, i.getDirection().getZ()).normalized().mul(i.getDistance()).mul(-1)));
					if(i.getDoesIntersect()) System.out.println("Collides!");
				}
				addCollision(object.getCollider(), i);
				//if(i.getDoesIntersect()) System.out.println("Collides!");
		}
	}
	
	public void addCollision(Collider c, IntersectData id)
	{
		collisions.put(c, id);
	}
	
	public IntersectData getCollision(Collider c)
	{
		return collisions.get(c);
	}
	
	
}
