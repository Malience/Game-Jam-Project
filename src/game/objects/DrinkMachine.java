package game.objects;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;

public class DrinkMachine extends Furnishing
{

	public DrinkMachine(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.02f);
		//setRotY(-180);
		setTexture("bricks2.jpg");
		setMesh("drinkmachine001.obj");		
		
		float width = 1.4f;
		float height = 1.4f;
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
	}



}
 
