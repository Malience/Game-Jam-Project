package game.mob;

import com.base.engine.physics.Collider;

import game.Collides;
import game.GObject;
import game.Player;
import game.Student;

public class Mob extends GObject implements Collides
{
	Collider collider;
	boolean density;
	
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

	@Override
	public Collider getCollider() {
		return collider;
	}

	@Override
	public boolean getDensity() {
		return density;
	}
	
	@Override
	public void setCollider(Collider collider) {
		this.collider = collider;
	}

	@Override
	public void setDensity(boolean density) {
		this.density = density;
	}
}
