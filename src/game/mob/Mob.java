package game.mob;

import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;
import game.RCObject;
import game.RObject;
import game.Student;

public class Mob extends RCObject
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
//		else if (rank == 's') //hi
//		{
//			Student s = new Student();
//		}
//		else if (rank == 'p')
//		{
//			Player p = new Player();
//		}
//	}
}
