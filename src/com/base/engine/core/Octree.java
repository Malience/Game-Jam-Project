package com.base.engine.core;

import java.util.ArrayList;

public class Octree
{
	private Vector3f origin;
	private Vector3f halfDimension;
	
	private Octree children[];
	private GameObject data;
	
	public Octree()
	{
		this(new Vector3f(0,0,0), new Vector3f(1000000000,1000000000,1000000000));
	}
	
	public Octree(Vector3f origin, Vector3f halfDimension)
	{
		this.origin = origin;
		this.halfDimension = halfDimension;
		
		data = null;
		children = new Octree[8];
	}
	
	public Octree(Octree copy)
	{
		this.origin = copy.origin;
		this.halfDimension = copy.halfDimension;
		
		this.data = copy.data;
	}
	
	public int getOctantContainingPoint(Vector3f point)
	{
		int oct = 0;
		if(point.getX() >= origin.getX()) oct += 4;
		if(point.getY() >= origin.getY()) oct += 2;
		if(point.getZ() >= origin.getZ()) oct += 1;
		return oct;
	}
	
	public boolean isLeafNode()
	{
		return children[0] == null;
	}
	
	
	public void insert(GameObject object)
	{
		if(isLeafNode())
		{
			if(data == null)
			{
				data = object;
				return;
			}
			else
			{
				GameObject oldPoint = data;
				data = null;
				
				for(int i = 0; i<8; i++)
				{
					Vector3f newOrigin = new Vector3f(origin);
					newOrigin.setX(newOrigin.getX() + halfDimension.getX() * ((i&4)==4 ? .5f : -.5f)); 
					newOrigin.setY(newOrigin.getY() + halfDimension.getY() * ((i&2)==2 ? .5f : -.5f));
					newOrigin.setZ(newOrigin.getZ() + halfDimension.getZ() * ((i&1)==1 ? .5f : -.5f));
					children[i] = new Octree(newOrigin, halfDimension.mul(.5f));
				}
				
				children[getOctantContainingPoint(oldPoint.getPosition())].insert(oldPoint);
				children[getOctantContainingPoint(object.getPosition())].insert(object);
			}
		}
		else
		{
			int octant = getOctantContainingPoint(object.getPosition());
			children[octant].insert(object);
		}
	}
	
	public void getPointsInsideBox(Vector3f bmin, Vector3f bmax, ArrayList<GameObject> results)
	{
		if(isLeafNode())
		{
			if(data!=null)
			{
				Vector3f p = data.getPosition();
				
				if(p.getX()>bmax.getX() || p.getY()>bmax.getY() || p.getZ()>bmax.getZ()) return;
				if(p.getX()<bmin.getX() || p.getY()<bmin.getY() || p.getZ()<bmin.getZ()) return;
				
				results.add(data);
			}
		}
		else
		{
			for(int i = 0; i<8; i++)
			{
				Vector3f cmax = children[i].origin.add(children[i].halfDimension);
				Vector3f cmin = children[i].origin.sub(children[i].halfDimension);
				
				if(cmax.getX()<bmin.getX() || cmax.getY()<bmin.getY() || cmax.getZ()<bmin.getZ()) continue;
				if(cmin.getX()>bmax.getX() || cmin.getY()>bmax.getY() || cmin.getZ()>bmax.getZ()) continue;
				
				children[i].getPointsInsideBox(bmin, bmax, results);
			}
		}
	}
	
	
}
