package com.base.engine.physics;

import com.base.engine.core.Vector3f;

public class IntersectData 
{
	private boolean doesIntersect;
	private float distance;
	private Vector3f dir;
	
	public IntersectData(boolean doesIntersect, float distance) 
	{
		this(doesIntersect, distance, new Vector3f(0,0,0));
	}
	
	public IntersectData(boolean doesIntersect, float distance, Vector3f dir)
	{
		this.doesIntersect = doesIntersect;
		this.distance = distance;
		this.dir = dir;
	}
	public boolean getDoesIntersect() {
		return doesIntersect;
	}
	public float getDistance() {
		return distance;
	}
	public Vector3f getDirection()
	{
		return dir;
	}
	
}
