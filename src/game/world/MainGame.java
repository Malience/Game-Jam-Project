package game.world;

import com.base.engine.components.Camera;
import com.base.engine.components.Controller;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.FreeLook;
import com.base.engine.components.FreeMove;
import com.base.engine.components.MeshRenderer;
import com.base.engine.components.PhysicsComponent;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;
import com.base.engine.physics.PhysicsEngine;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Texture;
import com.base.engine.rendering.Vertex;
import com.base.engine.rendering.Window;

import game.Player;
import game.TestObject;
import game.objects.Table;
import game.objects.Wall;

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
		playerObject.getTransform().setScale(player.getScale());
		playerObject.addComponent(player.getRender());
		GameObject cam = new GameObject();
		Camera camera = new Camera((float)Math.toRadians(70.0f), (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f);
		//RenderingEngine.mainCamera = camera;
		
		PhysicsComponent pc = player.getComponent();
		PhysicsEngine.important = pc;
		playerObject.addComponent(pc);
		
		playerObject.addChild(cam);
		cam.addComponent(camera);
		camera.getTransform().setPos(new Vector3f(0,400.0f,-100));
		camera.getTransform().rotate(new Vector3f(1,0,0), 45f);
		//cam.addComponent(new FreeLook(2.0f));
		playerObject.addComponent(new FreeMove(3.0f));
		//playerObject.addComponent(new FreeLook(10.0f));
		
//		GameObject playerObject = new GameObject().addComponent(new FreeLook(0.5f)).addComponent(new FreeMove(10)).addComponent(new Camera((float)Math.toRadians(70.0f), (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f));
//		PhysicsEngine.important = new PhysicsComponent(new AABB(new Vector3f(1,0,0), 1.0f, 1.0f), false);
//		playerObject.addComponent(PhysicsEngine.important);
		
		
		addObject(directionalLightObject);
		addObject(playerObject);
		
		Table table = new Table(0,0,1);
		
		GameObject to = new GameObject();
		to.addComponent(table.getComponent());
		to.addComponent(table.getRender());
		to.getTransform().setPos(table.getPos());
		to.getTransform().setScale(table.getScale());
		
		
		addObject(to);
//		World.New(new TestObject(0,0,0));
//		World.New(new Wall(0,0,3));
//		World.New(new Wall(1f,0,3));
//		World.New(new Wall(2,0,3));
//		World.New(new Wall(3,0,3));
		//World.New(new Table(0,0,1));
		
		new MattsMap();
		new JacksMap();
		new SriksMap();
		new PhilsMap();
		new BrendMap();
		new JeremMap();
	}
}
