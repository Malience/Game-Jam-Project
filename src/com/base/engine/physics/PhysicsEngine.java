package com.base.engine.physics;

import java.util.ArrayList;

public class PhysicsEngine 
{
	private ArrayList<PhysicsObject> objects;
	boolean[][] collisions;
	
	public PhysicsEngine()
	{
		objects = new ArrayList<PhysicsObject>();
		collisions = new boolean[1][1];
	}
	
	public void addObject(PhysicsObject object)
	{
		objects.add(object);
	}
	
	public void simulate(float delta)
	{
		for(PhysicsObject object : objects)
		{
			object.integrate(delta);
		}
	}
	
	public void handleCollisions()
	{
		collisions = new boolean[objects.size()][objects.size()];
		for(int i = 0; i < objects.size(); i++)
		{
			for(int j = i + 1; j < objects.size(); j++)
			{
				IntersectData intersectData  = objects.get(i).getCollider().intersect(objects.get(j).getCollider());
				collisions[i][j] = intersectData.getDoesIntersect();
			}
		}
	}
	
	//Temporary//
	public PhysicsObject getObject(int i)
	{
		return objects.get(i);
	}
	
	public int getNumObjects()
	{
		return objects.size();
	}
	
	public boolean[][] getCollisions()
	{
		return collisions;
	}
	
	
}
