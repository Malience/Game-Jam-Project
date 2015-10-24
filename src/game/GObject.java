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
	public int x,y,z;
	public ArrayList<GObject> children;
	
	public GObject(int x, int y,int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		children = null;
	}
	
	public GameObject convert()
	{
		GameObject object = new GameObject();
		Transform t = object.getTransform();
		//t.setPos(new Vector3f(x,y,z));
		
		if(this instanceof Renderable)
		{
			Renderable o = (Renderable) this;
			Material material = new Material();
			material.addTexture("diffuse", new Texture(o.getTexture()));
			material.addFloat("specularIntensity", 1);
			material.addFloat("specularPower", 8);
			object.addComponent(new MeshRenderer(new Mesh(o.getMesh()), material));
		}
		
		
		
		return object;
	}
}
