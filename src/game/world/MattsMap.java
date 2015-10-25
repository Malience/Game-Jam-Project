package game.world;

import game.objects.Oven;
import game.objects.Wall;

public class MattsMap extends subgame
{
	public MattsMap()
	{
		/*
		 * Create objects such as Walls by using their constructor
		 * Edit them however you'd like
		 * Then put them into the game with World.New(Object);
		 */
		
		World.New(new Oven(0,0,3));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
		World.New(new Wall(0,0,5));
	}
}
