package game;

public class Player extends Mob
{
	private int fullness = 0;
	private int maxFull;
	int suspected = 0;
	int maxSus = 100;
	
	public Player()
	{
		
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
}
