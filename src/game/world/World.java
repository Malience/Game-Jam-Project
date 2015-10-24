package game.world;

import com.base.engine.core.Game;
import com.base.engine.core.GameObject;

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
		
		game.addObject(o);
	}
}
