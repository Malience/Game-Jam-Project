package game.objects.food;

public class PizzaSlice extends Food
{

	public PizzaSlice(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.1f);
		setTexture("slice.png");
		setMesh("slice.obj");	
	}

}
