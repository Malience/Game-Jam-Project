package game.world;

import com.base.engine.components.Camera;
import com.base.engine.components.Controller;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.FreeLook;
import com.base.engine.components.FreeMove;
import com.base.engine.components.MeshRenderer;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Texture;
import com.base.engine.rendering.Vertex;
import com.base.engine.rendering.Window;

import game.Player;
import game.TestObject;
import game.objects.Table;

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
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(1,1,1), 1.0f);
//		RenderingEngine.dlight = directionalLight;

		directionalLightObject.addComponent(directionalLight);
		directionalLightObject.getTransform().rotate(new Vector3f(1,0,0), 180f);
		
		float fieldDepth = 10.0f;
		float fieldWidth = 10.0f;
		
		Vertex[] vertices = new Vertex[] { 	new Vertex( new Vector3f(-fieldWidth, 0.0f, -fieldDepth), new Vector2f(0.0f, 0.0f)),
				new Vertex( new Vector3f(-fieldWidth, 0.0f, fieldDepth * 3), new Vector2f(0.0f, 1.0f)),
				new Vertex( new Vector3f(fieldWidth * 3, 0.0f, -fieldDepth), new Vector2f(1.0f, 0.0f)),
				new Vertex( new Vector3f(fieldWidth * 3, 0.0f, fieldDepth * 3), new Vector2f(1.0f, 1.0f))};

		int indices[] = { 0, 1, 2,
				2, 1, 3};

		Mesh mesh = new Mesh(vertices, indices, true);
		Material material = new Material();//new Texture("test.png"), new Vector3f(1,1,1), 1, 8);
		material.addTexture("diffuse", new Texture("test.png"));
		material.addFloat("specularIntensity", 1);
		material.addFloat("specularPower", 8);
		
		MeshRenderer plane = new MeshRenderer(mesh, material);
		addObject(new GameObject().addComponent(plane));
		
		Player player = new Player(1,0,0);
		GameObject playerObject = new GameObject();/*.addComponent(new FreeLook(0.5f)).addComponent(new FreeMove(10))*/
		playerObject.getTransform().setPos(player.getPos());
		playerObject.getTransform().setScale(player.scale);
		playerObject.addComponent(player.getRender());
		GameObject cam = new GameObject();
		Camera camera = new Camera((float)Math.toRadians(70.0f), (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f);
		//RenderingEngine.mainCamera = camera;
		
		playerObject.addChild(cam);
		cam.addComponent(camera);
		camera.getTransform().setPos(new Vector3f(0,400.0f,-100));
		camera.getTransform().rotate(new Vector3f(1,0,0), 45f);
		playerObject.addComponent(new FreeMove(5.0f));
		//playerObject.addComponent(new FreeLook(10.0f));
		
		addObject(directionalLightObject);
		addObject(playerObject);
		
		World.New(new TestObject(0,0,0));
		World.New(new Table(0,0,1));
	}
}
