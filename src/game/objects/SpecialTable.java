package game.objects;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;
import game.interfaces.Interface;
import game.interfaces.InterfaceTrigger;

public class SpecialTable extends Furnishing
{
	float width = .3f;
	float height = .3f;
	
	
	public SpecialTable(float x, float y, float z) {
		super(x, y, z);
		setScale(0.003f);
		setTexture("brown.png");
		setMesh("table001.obj");
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
		
		InterfaceTrigger it = new InterfaceTrigger(0,0,1,Interface.InteractE,this);
		it.setPos(it.getPos().add(getPos()));
		getChildren().add(it);
	}
}
