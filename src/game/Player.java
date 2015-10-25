package game;

import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.BoundingSphere;
import com.base.engine.physics.Collider;

import game.mob.Mob;

public class Player extends Mob implements Collides
{
//<<<<<<< HEAD
	
	float width = .3f;
	float height = .3f;
	
//=======
	private int[] foodFill = {0,0,0,0};
//>>>>>>> 9544138af48da768eeae62e4a8f1e83069687750
	private int fullness = 0;
	private int suspected = 0;
	private int maxSus = 100;
	private Table table = new Table();
	private Inventory inv = new Inventory();
	
	
	public Player(float x, float y, float z)
	{
		super(x,y,z);
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
	}
	
	private void suspicion()
	{
		//visit to fast
		//add to suspicion
		
		//caught
		//game over
		
		if (suspected >= maxSus)
		{
			//game over
		}
	}
		
	public void eat(int food)
	{
		//eat item
		fullness += foodFill[food];
		//subtracts the item from the table
		table.rid(food);
		coma();
	}
	
	public void bag(int food)
	{
		//bag item
		inv.addFood(food);
	}
	
	private void coma()
	{
		if(fullness > 100)
		{
			//player stops for short time
			fullness = 90;
		}
	}
}
