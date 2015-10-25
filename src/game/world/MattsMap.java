package game.world;

import game.objects.Chair;
import game.objects.Counter;
import game.objects.Oven;
import game.objects.ServingTable;
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
		
		World.New(new Chair(0,0,3));
	}
}
