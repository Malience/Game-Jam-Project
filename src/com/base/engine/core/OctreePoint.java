package com.base.engine.core;

public class OctreePoint<E> 
{
	Vector3f position;
	E data;
	
	public OctreePoint()
	{
		
	}
	
	public OctreePoint(Vector3f position)
	{
		this.position = position;
	}
	
	public void addData(E e)
	{
		data = e;
	}
	
	public E getData()
	{
		return data;
	}
	
	public Vector3f getPosition()
	{
		return position;
	}
	
	public void setPosition(Vector3f position)
	{
		this.position = position;
	}
}
