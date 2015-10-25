package game.objects.food;

public class Fries extends Food
{

	public Fries(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.1f);
		setTexture("friesRotate.png");	
		setMesh("fries.obj");	
	}
}
