package game;

import java.util.ArrayList;

import com.base.engine.components.MeshRenderer;
import com.base.engine.core.GameObject;
import com.base.engine.core.Transform;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Texture;

public abstract class GObject
{
	private float x,y,z,scale,rotx,roty,rotz;
	private ArrayList<GObject> children;
	private GameObject This;
	
	public GObject()
	{
		this(0,0,0);
	}
	
	public GObject(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		setScale(1.0f);
		children = new ArrayList<GObject>();
	}
	
	public ArrayList<GObject> getChildren()
	{
		return children;
	}
	
	public GameObject getThis()
	{
		return This;
	}
	
	public void setThis(GameObject o)
	{
		This = o;
	}
	
	public float getScale()
	{
		return scale;
	}
	
	public Vector3f getPos()
	{
		return new Vector3f(x,y,z);
	}
	
	public void setScale(float s)
	{
		scale = s;
	}
	
	public void setPos(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void setPos(Vector3f v)
	{
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}
	
	public void setRotX(float r)
	{
		rotx = r;
	}
	
	public void setRotY(float r)
	{
		roty = r;
	}
	
	public void setRotZ(float r)
	{
		rotz = r;
	}
	
	public float getRotX()
	{
		return rotx;
	}
	
	public float getRotY()
	{
		return roty;
	}
	
	public float getRotZ()
	{
		return rotz;
	}
	
	public static float getDistance(GObject object1, GObject object2)
	{
		Vector3f v = object1.getThis().getTransform().getPos().sub(object2.getThis().getTransform().getPos());
		v = v.mul(v);
		return (float)Math.sqrt(v.length());
	}
	
	public float getDistance(GObject object)
	{
		Vector3f v = getThis().getTransform().getPos().sub(object.getThis().getTransform().getPos());
		v = v.mul(v);
		return (float)Math.sqrt(v.length());
	}
}
