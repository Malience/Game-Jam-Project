package game.objects.food;

public class Oranges extends Food
{
	public Oranges(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.1f);
		setTexture("orange.png");	
		setMesh("orange.obj");	
	}
}
