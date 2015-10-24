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
	public float x,y,z,scale;
	public ArrayList<GObject> children;
	public String texture = "test.png";
	public String mesh = "monkey3.obj";
	
	public GObject(float x, float y, float z, float s, String t, String m)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.scale = s;
		texture = t;
		mesh = m;
		children = null;
	}
	
	public Vector3f getPos()
	{
		return new Vector3f(x,y,z);
	}
	
	@Override
	public String getTexture() {
		return texture;
	}

	@Override
	public String getMesh() {
		return mesh;
	}
}
