package game.objects;

import com.base.engine.components.TriggerComponent;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;
import game.interfaces.Interface;
import game.interfaces.InterfaceTrigger;
import game.objects.food.Pizza;
import game.objects.food.PizzaSlice;

public class ServingTable extends Furnishing
{
	Pizza pizza;
	public ServingTable(float x, float y, float z) {
		super(x, y, z);
		
		setScale(0.002f);
		setTexture("plywood.jpg");
		setMesh("ServingTable001.obj");
		
		float width = .9f;
		float height = .3f;
		
		float cwidth = 0.8f;
		float cheight = 0.9f;
		
		setCollider(new AABB(new Vector3f(x - cwidth, y - cheight/2, z - cwidth/2), new Vector3f(x + cwidth/2, y + cheight/2, z + cwidth/2)));
		//setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
		
		pizza = new Pizza(x,y + height,z);
		
		
		InterfaceTrigger it = new InterfaceTrigger(0,0,-1,Interface.InteractE);
		it.setPos(it.getPos().add(getPos()));
		getChildren().add(it);
	}



}
