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
	public float x,y,z,scale,rot;
	public ArrayList<GObject> children;
	public String texture;
	public String mesh;
	
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
	
	public void setRot(float r)
	{
		rot = r;
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
