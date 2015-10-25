package game.interfaces;

import com.base.engine.core.Input;
import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import static org.lwjgl.glfw.GLFW.*;

import game.Collides;
import game.GObject;
import game.objects.food.PizzaSlice;

public class InterfaceTrigger extends GObject implements Collides
{
	public Collider collider;
	public boolean density;
	public E e;
	public Vector3f base;
	
	
	public InterfaceTrigger(float x, float y, float z, E e)
	{	
		this.e = e;
		base = e.getPos();
		
		float width = 2f;
		float height = 2f;
		
		collider = new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2));
		density = false;
		
		getChildren().add(new PizzaSlice(0,0,0));
	}
	
	public void trigger()
	{
		e.o.getTransform().setPos(base);
		if(Input.getKey(GLFW_KEY_E))
		{
			System.out.println("We did it reddit!");
		}
	}
	
	public void detrigger()
	{
		e.o.getTransform().setPos(new Vector3f(0, 3, 0));
	}
	
	
	@Override
	public Collider getCollider() {
		// TODO Auto-generated method stub
		return collider;
	}

	@Override
	public boolean getDensity() {
		// TODO Auto-generated method stub
		return density;
	}

	@Override
	public void setCollider(Collider collider) {
		this.collider = collider;
		
	}

	@Override
	public void setDensity(boolean density) {
		this.density = density;
		
	}

}
