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
	private int[] foods = {0,0,0,0};
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
	
	public boolean suspicion()
	{
		//visit to fast
		//add to suspicion
		
		//caught
		//game over
		
		return suspected >= maxSus;
	}
		
	public void eat(int food)
	{
		if(table.getFood()[food]>0)
		{
			//eat item
			fullness += foodFill[food];
			//subtracts the item from the table
			table.rid(food);
			System.out.println("Om nom nom!");
			suspected-=10;
			if(suspected<0) suspected = 0;
			coma();
		}
		else
		{
			System.out.println("No food");
		}
			
	}
	
	public void get(int food)
	{
		System.out.println("Grabbed some food!");
		foods[food]++;
	}
	
	public void place(int food)
	{
		if(foods[food]>0)
		{
			System.out.println("Placed food!");
			foods[food]--;
			table.placeFood(food, 1);
		}
		else
			System.out.println("Out of food!");
	}
	
	
	public void bag(int food)
	{
		if(table.getFood()[food]>0)
		{
			//bag item
			inv.addFood(food);
			suspected+=10;
			if(suspected>maxSus) suspected = maxSus;
			System.out.println("Bagged food! Profit: ");
			System.out.println(inv.profit());
		}
		else
		{
			System.out.println("No food");
		}
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
