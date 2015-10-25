package game.world;

import com.base.engine.components.MovementComponent;
import com.base.engine.components.TriggerComponent;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;

import game.Collides;
import game.GObject;
import game.Renderable;
import game.interfaces.InterfaceTrigger;
import game.mob.Worker;

public class World 
{
	public static Game game;
	
	public static void New(GObject object)
	{
		GameObject main = construct(object);
		
		for(GObject child : object.getChildren())
		{
			addChild(main, child);
		}
		
		game.addObject(main);
	}
	
	private static GameObject construct(GObject object)
	{
		GameObject o = new GameObject();
		
		
		
		o.getTransform().setPos(object.getPos());
		
		o.getTransform().setScale(object.getScale());
		
		o.getTransform().rotate(new Vector3f(1,0,0), (float)Math.toRadians(object.getRotX()));
		o.getTransform().rotate(new Vector3f(0,1,0), (float)Math.toRadians(object.getRotY()));
		o.getTransform().rotate(new Vector3f(0,0,1), (float)Math.toRadians(object.getRotZ()));
		
		if(object instanceof Renderable)
		{
			Renderable r = (Renderable) object;
			o.addComponent(r.getRender());
		}
		if(object instanceof Collides)
		{
			Collides c = (Collides) object;
			o.addComponent(c.getComponent1());
			o.addComponent(c.getComponent2());
		}
		if(object instanceof InterfaceTrigger)
		{
			InterfaceTrigger c = (InterfaceTrigger) object;
			o.addComponent(new TriggerComponent(c));
		}
		if(object instanceof Worker)
		{
			Worker c = (Worker) object;
			o.addComponent(new MovementComponent(c));
		}
		
		object.setThis(o);
		
		return o;
	}
	
	private static void addChild(GameObject parent, GObject object)
	{
		GameObject o = construct(object);
		parent.addChild(o);
		for(GObject child : object.getChildren())
		{
			addChild(o, child);
		}
	}
}
