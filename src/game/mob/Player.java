package game.mob;

import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.BoundingSphere;
import com.base.engine.physics.Collider;

import game.Inventory;
import game.Table;

public class Player extends Mob
{
//<<<<<<< HEAD
	
	
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
		setTexture("player1Rotate.png");
		setMesh("man002.obj");
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
