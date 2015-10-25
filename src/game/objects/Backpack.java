package game.objects;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;
import game.interfaces.Interface;
import game.interfaces.InterfaceTrigger;

public class Backpack extends Furnishing
{

	public Backpack(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.002f);
		setTexture("backpack001rotate.png");
		setMesh("backpack001.obj");
		
		float width = .9f;
		float height = .9f;
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(false);
		
		InterfaceTrigger it = new InterfaceTrigger(0,0,0,Interface.InteractE);
		it.setPos(it.getPos().add(getPos()));
		getChildren().add(it);
	}



}
