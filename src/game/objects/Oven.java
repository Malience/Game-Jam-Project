package game.objects;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;

public class Oven extends Furnishing
{

	public Oven(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.01f);
		setRotY(-90);
		setTexture("bricks2.jpg");
		setMesh("oven001.obj");		
		
<<<<<<< HEAD
		float width = 1.0f;
		float height = 1.0f;
		
		collider = new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2));
		
		density = true;
=======
		float width = .9f;
		float height = .9f;
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
>>>>>>> f841ac7abff8d7eed2680eb1b2bbe61a303dacff
	}



}
