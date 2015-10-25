package game.objects.food;

public class Cookie extends Food
{

	public Cookie(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.1f);
		setTexture("Cookie.png");
		//setMesh("Cookie.obj");	
		setMesh("Cookie2.obj");	
	}
	
}
