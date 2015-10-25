package game.objects;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;
import game.objects.food.Pizza;

public class ServingTable extends Furnishing
{
	Pizza pizza;
	public ServingTable(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.002f);
		setTexture("bricks2.jpg");
		setMesh("ServingTable001.obj");
		
		float width = .9f;
		float height = .3f;
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
		
		pizza = new Pizza(x,y + height,z);
	}



}
