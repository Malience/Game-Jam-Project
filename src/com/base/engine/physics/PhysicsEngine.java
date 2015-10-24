package com.base.engine.physics;

import java.util.ArrayList;

import com.base.engine.components.PhysicsComponent;

public class PhysicsEngine 
{
	ArrayList<IntersectData> collisions;
	ArrayList<Collider> colliders;
	public static PhysicsComponent important;
	
	public PhysicsEngine()
	{
		collisions = new ArrayList<IntersectData>();
	}
	
	
	public void handleCollisions(PhysicsComponent object, boolean density)
	{
		if(object != important)
		{
			important.getCollider().setPos(important.getTransform().getPos().getXZ());
			object.getCollider().setPos(object.getTransform().getPos().getXZ());
				IntersectData i = object.getCollider().intersect(important.getCollider());
				if(density)
					important.getTransform().setPos(important.getTransform().getPos().sub(i.getDirection().mul(i.getDistance())));
				addCollision(i);
		}
	}
	
	public void addCollision(IntersectData id)
	{
		collisions.add(id);
	}
	
	public ArrayList<IntersectData> getCollisions()
	{
		return collisions;
	}
	
	
}
