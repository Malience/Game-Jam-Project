package game;

import com.base.engine.components.MeshRenderer;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Texture;

public interface Renderable 
{
	public String getTexture();
	public String getMesh();
	public default MeshRenderer getRender()
	{
		Material material = new Material();
		material.addTexture("diffuse", new Texture(getTexture()));
		material.addFloat("specularIntensity", 1);
		material.addFloat("specularPower", 8);
		return new MeshRenderer(new Mesh(getMesh()), material);
	}
}