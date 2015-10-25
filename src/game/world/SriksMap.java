package game.world;

import game.TestObject;
import game.objects.Counter;
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


		TestObject t = new TestObject(0f, 0, 1f);
		t.setScale(.001f);
		World.New(t);
		
		World.New(new Counter(0f, 0f, 5f));
		World.New(new Counter(.3f, 0f, 5f));
		
		World.New(new Table (-6f, 0f, 6f));

		
	}
}
