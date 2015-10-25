package game;

public class TestObject extends RObject
{
	
	public TestObject(float x, float y, float z) {
		super(x, y, z);
		setScale(0.01f);
		setTexture("fog2.png");
		setMesh("FOG.obj");
	}
	
}
