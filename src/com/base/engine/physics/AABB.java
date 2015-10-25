package com.base.engine.physics;

import com.base.engine.core.Quaternion;
import com.base.engine.core.Vector3f;

public class AABB extends Collider
{
	private Vector3f minExtents;
	private Vector3f maxExtents;
	private Quaternion rot;
	
	public AABB(Vector3f center, float width, float height)
	{
		this(new Vector3f(center.getX() - width/2, center.getY() - height/2, center.getZ() + width/2), 
			new Vector3f(center.getX() + width/2, center.getY() + height/2, center.getZ() + width/2));
	}
	
	public AABB(Vector3f minExtents, Vector3f maxExtents) {
		super(TYPE_AABB);
		this.minExtents = minExtents;
		this.maxExtents = maxExtents;
	}
	
	public IntersectData intersectAABB(AABB other)
	{
		Vector3f distances1 = other.getMinExtents().rotate(other.getRot()).sub(getMaxExtents().rotate(rot));
		Vector3f distances2 = getMinExtents().rotate(rot).sub(other.getMaxExtents().rotate(other.getRot()));
		Vector3f distances = distances1.max(distances2);
		
		float maxDistance = distances.max();
		
		Vector3f v1 = minExtents.rotate(rot).add(maxExtents.rotate(rot)).mul(1/2f);
		Vector3f v2 = other.getMinExtents().rotate(other.getRot()).add(other.getMaxExtents().rotate(other.getRot())).mul(1/2f);
		
		return new IntersectData(maxDistance < 0, maxDistance, v1.sub(v2).normalized());
	}
	
	public static void test()
	{
		AABB aabb1 = new AABB(new Vector3f(0.0f,0.0f,0.0f), new Vector3f(1.0f,1.0f,1.0f));
		AABB aabb2 = new AABB(new Vector3f(1.0f,1.0f,1.0f), new Vector3f(2.0f,2.0f,2.0f));
		AABB aabb3 = new AABB(new Vector3f(1.0f,0.0f,0.0f), new Vector3f(2.0f,1.0f,1.0f));
		AABB aabb4 = new AABB(new Vector3f(0.0f,0.0f,-2.0f), new Vector3f(1.0f,1.0f,-1.0f));
		AABB aabb5 = new AABB(new Vector3f(0.0f,0.5f,0.0f), new Vector3f(1.0f,1.5f,1.0f));
		AABB aabb6 = new AABB(new Vector3f(0.3f,0.5f,0.7f), new Vector3f(1.3f,1.5f,1.7f));
		
		IntersectData aabb1Intersectaabb2 = aabb1.intersectAABB(aabb2);
		IntersectData aabb1Intersectaabb3 = aabb1.intersectAABB(aabb3);
		IntersectData aabb1Intersectaabb4 = aabb1.intersectAABB(aabb4);
		IntersectData aabb1Intersectaabb5 = aabb1.intersectAABB(aabb5);
		IntersectData aabb1Intersectaabb6 = aabb1.intersectAABB(aabb6);
		
		assert(aabb1Intersectaabb2.getDoesIntersect() 	== false);
		assert(aabb1Intersectaabb2.getDistance()		== 0.0f);
		
		assert(aabb1Intersectaabb3.getDoesIntersect() 	== false);
		assert(aabb1Intersectaabb3.getDistance()		== 0.0f);
		
		assert(aabb1Intersectaabb4.getDoesIntersect() 	== false);
		assert(aabb1Intersectaabb4.getDistance()		== 1.0f);
		
		assert(aabb1Intersectaabb5.getDoesIntersect() 	== true);
		assert(aabb1Intersectaabb5.getDistance()		== -0.5f);
		
		assert(aabb1Intersectaabb6.getDoesIntersect() 	== true);
		assert(aabb1Intersectaabb6.getDistance()		== -0.3f);
		
//		System.out.println("A1 - A3: " + aabb1Intersectaabb3.getDoesIntersect() + " , Distance: " + aabb1Intersectaabb3.getDistance());
//		System.out.println("A1 - A4: " + aabb1Intersectaabb4.getDoesIntersect() + " , Distance: " + aabb1Intersectaabb4.getDistance());
//		System.out.println("A1 - A5: " + aabb1Intersectaabb5.getDoesIntersect() + " , Distance: " + aabb1Intersectaabb5.getDistance());
//		System.out.println();
	}
	
	public Vector3f getMinExtents() {
		return minExtents;
	}
	public Vector3f getMaxExtents() {
		return maxExtents;
	}
	
	public void setCenter(Vector3f center)
	{
		Vector3f v = minExtents.sub(maxExtents).mul(1/2f);
		minExtents = center.sub(v);
		maxExtents = center.add(v);
	}
	
	public void setRot(Quaternion rot)
	{
		this.rot = rot;
	}
	
	public Quaternion getRot()
	{
		return rot;
	}
	
}
