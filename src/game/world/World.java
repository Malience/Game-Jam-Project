package game.world;

import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;

import game.Collides;
import game.GObject;

public class World 
{
	public static Game game;
	
	public static void New(GObject object)
	{
		GameObject o = new GameObject();
		o.addComponent(object.getRender());
		
		
		o.getTransform().setPos(object.getPos());
		
		o.getTransform().setScale(object.scale);
		
		o.getTransform().rotate(new Vector3f(1,0,0), object.getRotX());
		o.getTransform().rotate(new Vector3f(0,1,0), object.getRotY());
		o.getTransform().rotate(new Vector3f(0,0,1), object.getRotZ());
		
		if(o.getClass().isInstance(Collides.class))
		{
			Collides c = (Collides) o;
			o.addComponent(c.getComponent());
		}
		
		game.addObject(o);
	}
}
