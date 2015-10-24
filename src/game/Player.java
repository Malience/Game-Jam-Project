package game;

import game.mob.Mob;

public class Player extends Mob
{
	private int[] foodFill = {0,0,0,0};
	private int fullness = 0;
	private int suspected = 0;
	private int maxSus = 100;
	private Table table = new Table();
	private Inventory inv = new Inventory();
	
	
	public Player(float x, float y, float z)
	{
		super(x,y,z);
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
