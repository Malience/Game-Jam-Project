package game.world;

import game.TestObject;
import game.objects.Table;

public class SriksMap extends subgame
{
	public SriksMap()
	{
		/*
		 * Create objects such as Walls by using their constructor
		 * Edit them however you'd like
		 * Then put them into the game with World.New(Object);sa
		 */ 
		
		//World.New(new Table (1f, 0f, 1f));
		//World.New(new Table (2f, 0f, 2f));
		//World.New(new Table (3f, 0f, 3f));
		//World.New(new Table (-2f, 0f, 5f));
		//World.New(new Table (3f, 0f, -3f));
		//World.New(new Table (5f, 0f, -2f));
		TestObject t = new TestObject(0f, 0, 1f);
		t.setScale(.001f);
		World.New(t);
		World.New(new Table (-8f, 0f, 8f));
		World.New(new Table (-6f, 0f, 6f));
		World.New(new Table (-9f, 0f, 9f));
		World.New(new Table (5f, 0f, -3f));
		World.New(new Table (5f, 0f, -5f));
		World.New(new Table (3f, 0f, 3f));
		//World.New(new Table (1f, 0f, 1f));
		//World.New(new Table (1f, 0f, 1f));
		
	}
}
