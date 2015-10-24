package game.mob;

import game.GObject;
import game.Player;
import game.Student;

public class Mob extends GObject
{

	public Mob(float x, float y, float z) {
		super(x, y, z);
		setScale(.005f);
		setTexture("test.png");
		setMesh("man001.obj");
	}
//	public Mob(char rank)
//	{
//		// Create worker || student || player
//		if (rank == 'w')
//		{
//			Worker w = new Worker();
//		}
//		else if (rank == 's')
//		{
//			Student s = new Student();
//		}
//		else if (rank == 'p')
//		{
//			Player p = new Player();
//		}
//	}
}
