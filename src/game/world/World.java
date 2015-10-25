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
		
		o.getTransform().rotate(new Vector3f(1,0,0), (float)Math.toDegrees(object.getRotX()));
		o.getTransform().rotate(new Vector3f(0,1,0), (float)Math.toDegrees(object.getRotY()));
		o.getTransform().rotate(new Vector3f(0,0,1), (float)Math.toDegrees(object.getRotZ()));
		
		if(object instanceof Collides)
		{
			Collides c = (Collides) object;
			o.addComponent(c.getComponent());
		}
		
		game.addObject(o);
	}
}
