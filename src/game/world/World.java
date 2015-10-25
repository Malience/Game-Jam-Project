package game.world;

import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;

import game.Collides;
import game.GObject;
import game.Renderable;

public class World 
{
	public static Game game;
	
	public static void New(GObject object)
	{
		GameObject o = new GameObject();
		
		
		o.getTransform().setPos(object.getPos());
		
		o.getTransform().setScale(object.getScale());
		
		o.getTransform().rotate(new Vector3f(1,0,0), (float)Math.toRadians(object.getRotX()));
		o.getTransform().rotate(new Vector3f(0,1,0), (float)Math.toRadians(object.getRotY()));
		o.getTransform().rotate(new Vector3f(0,0,1), (float)Math.toRadians(object.getRotZ()));
		
		if(object instanceof Renderable)
		{
			o.addComponent(object.getRender());
		}
		if(object instanceof Collides)
		{
			Collides c = (Collides) object;
			o.addComponent(c.getComponent());
		}
		
		game.addObject(o);
	}
}
