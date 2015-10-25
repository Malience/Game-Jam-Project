package game.world;

import game.objects.*;

public class PhilsMap extends subgame
{
	public PhilsMap()
	{
		/*
		 * Create objects such as Walls by using their constructor
		 * Edit them however you'd like
		 * Then put them into the game with World.New(Object);
		 */
		World.New(new Table(3,0,0));
		DrinkMachine dm = new DrinkMachine(3,0.2f,-0.05f);
		dm.setRotY(-180);
		
		World.New(dm);
	}
}
