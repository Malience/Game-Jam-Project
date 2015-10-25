package game.world;

import game.GObject;
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
		float offX = 0.0f;
		float offZ = 0.0f;
		
		PhilsMap.addToWorldWithRotation(new Table(3,0,0), 0, 0, 0);
		PhilsMap.addToWorldWithRotation(new DrinkMachine(3,0.2f,-0.05f), 0, -180, 0);
		PhilsMap.addToWorldWithRotation(new Oven(0 + offX,0,0 + offZ), 0, 90, 0);
		PhilsMap.addToWorldWithRotation(new ServingTable(-0.4f+offX,0,-0.4f+offZ), 0, -90, 0);
		PhilsMap.addToWorldWithRotation(new ServingTable(0.4f+offX,0,-0.4f+offZ), 0, -90, 0);
		PhilsMap.addToWorldWithRotation(new Counter(0.0f+offX,0,-0.8f+offZ), 0, -90, 0);
	}
	
	public static void addToWorldWithRotation(GObject f, float pitch, float yaw, float roll)
	{
		f.setRotX(pitch);
		f.setRotY(yaw);
		f.setRotZ(roll);
		World.New(f);
	}
}
