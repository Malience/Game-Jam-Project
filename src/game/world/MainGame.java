package game.world;

import com.base.engine.components.Camera;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.FreeLook;
import com.base.engine.components.FreeMove;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Window;

import game.TestObject;

public class MainGame extends Game
{
	//The name of the program
	public static final String NAME = "Test";
	
	//Screen's resolution
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	//public static final 
	
	public void init()
	{
		World.game = this;
		GameObject directionalLightObject = new GameObject();
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0,0,1), 0.4f);
//		RenderingEngine.dlight = directionalLight;

		directionalLightObject.addComponent(directionalLight);
		
		
		addObject(new GameObject().addComponent(new FreeLook(0.5f)).addComponent(new FreeMove(10)).addComponent(new Camera((float)Math.toRadians(70.0f), (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f)));
		addObject(directionalLightObject);
		
		World.New(new TestObject(0,0,0));
	}
}
