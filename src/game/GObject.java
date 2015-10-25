package game;

import java.util.ArrayList;

import com.base.engine.components.MeshRenderer;
import com.base.engine.core.GameObject;
import com.base.engine.core.Transform;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Texture;

public abstract class GObject implements Renderable 
{
	private float x,y,z,scale,rotx,roty,rotz;
	private ArrayList<GObject> children;
	private String texture;
	private String mesh;
	
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
		setTexture("test.png");
		setMesh("monkey3.obj");
		children = null;
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
	
	@Override
	public String getTexture() {
		return texture;
	}

	@Override
	public String getMesh() {
		return mesh;
	}
	
	@Override
	public void setTexture(String texture) {
		this.texture = texture;
	}

	@Override
	public void setMesh(String mesh) {
		this.mesh = mesh;
	}
}
