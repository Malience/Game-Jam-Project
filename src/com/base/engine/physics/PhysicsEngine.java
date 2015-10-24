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
	
	
	public void handleCollisions(PhysicsComponent object)
	{
		if(object != important)
		{
			//System.out.println("Collide Start!");
			important.getCollider().setCenter(important.getTransform().getPos());
			object.getCollider().setCenter(object.getTransform().getPos());
				IntersectData i = object.getCollider().intersect(important.getCollider());
				if(object.getDensity() && i.getDoesIntersect())
				{
					important.getTransform().setPos(important.getTransform().getPos().sub(i.getDirection().mul(i.getDistance()).mul(-1)));
					//if(i.getDoesIntersect()) System.out.println("Collides!");
				}
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
