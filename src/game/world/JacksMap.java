package game.world;

import game.objects.Wall;

import com.base.engine.core.GameObject;

public class JacksMap extends subgame
{
	public JacksMap()
	{
		/*
		 * Create objects such as Walls by using their constructor
		 * Edit them however you'd like
		 * Then put them into the game with World.New(Object);
		 */
		
		//Top wall
		Wall lWall;
		for(double i = -9.5; i <= 30; i++)
		{
			lWall = new Wall((float)(i+0.1),(float)(0),(float)(29.9));
			World.New(lWall);
		}
		
		//right wall
		Wall tWall = new Wall((float)1.0,(float)0.0,(float)1.0);		
		for(double i = -10.0; i <= 30; i++)
		{
			tWall = new Wall((float)(30.0),(float)(0.0),(float)(i+0.1));
			tWall.setRotY((float)2.0015);
			World.New(tWall);
		}
	}
}
