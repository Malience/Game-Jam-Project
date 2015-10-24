package com.base.engine.physics;

import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;

public class BoundingCircle extends Collider
{
	private Vector2f center;
	private float radius;
	
	public BoundingCircle(float radius)
	{
		super(TYPE_SPHERE);
		this.center = new Vector2f(0,0);
		this.radius = radius;
	}
	
	public BoundingCircle(Vector2f center, float radius)
	{
		super(TYPE_SPHERE);
		this.center = center;
		this.radius = radius;
	}
	
//	public IntersectData intersectBoundingCircle(BoundingCircle other)
//	{
//		float radiusDistance = radius + other.radius;
//		float centerDistance = (other.getCenter().sub(center)).length();
//		Vector2f dir = other.getCenter().sub(center).normalized();
//		
//		return new IntersectData(centerDistance < radiusDistance, centerDistance - radiusDistance, new Vector3f(dir.getX(), 0, dir.getY()));
//	}
	
	public void setPos(Vector2f v)
	{
		center = v;
	}
	
//	public Vector2f getCenter() {
//		return center;
//	}
	public float getRadius() {
		return radius;
	}
	public void update(float delta, Vector3f v)
	{
		center = v.getXZ();
	}
}
