package game.objects;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;

public class Counter extends Furnishing
{

	public Counter(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.01f);
		setTexture("bricks.jpg");
		setMesh("counterBase.obj");
		
		float width = .9f;
		float height = .9f;
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
	}



}
