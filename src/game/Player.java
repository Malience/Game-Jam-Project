package game;

import com.base.engine.core.Vector2f;
import com.base.engine.physics.BoundingCircle;
import com.base.engine.physics.Collider;

import game.mob.Mob;

public class Player extends Mob implements Collides
{
	Collider collider;
	boolean density;
	
	private int fullness = 0;
	private int maxFull;
	int suspected = 0;
	int maxSus = 100;
	
	public Player(float x, float y, float z)
	{
		super(x,y,z);
		collider = new BoundingCircle(new Vector2f(0,0), 3f);
		density = true;
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
	
	//when at table
	private void holding()
	{
		//goes through items on plate
	}
	
	private void eat(Food ate)
	{
		//eat item
		//fullness += (food satisfaction)
	}
	
	private void bag(Food take)
	{
		//bag item
		//add to inventory
		//if (S1)
		//	inventory.addS1(); //ex
	}
	
	@Override
	public Collider getCollider() {
		return collider;
	}
	
	@Override
	public boolean getDensity() {
		return density;
	}
	
	
}
