package game.objects.food;

public class IceCream extends Food
{
	public IceCream(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.06f);
		setTexture("IceCreamRotate.png");	
		setMesh("IceCream.obj");	
	}
}
