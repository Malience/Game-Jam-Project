package game;

public class RObject extends GObject implements Renderable
{
	private String texture;
	private String mesh;
	
	public RObject(float x, float y, float z)
	{
		super(x,y,z);
		setTexture("test.png");
		setMesh("monkey3.obj");
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
