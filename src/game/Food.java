package game;
import java.util.Random;

public class Food {

	private Random rand;
	private int taken = 0;
	private int[] plate = {0,0,0,0}; //[s1,s2,s3,s4]
	private int[] weights = {0,0,0,0}; //[s1,s2,s3,s4]
	private int carryCap = 0;
	
	public Food()
	{

	}
	
	public void action(char act, int station, int took)
	{
		taken = took;
		
		if (station == 1)
		{
			station1(act);
		}
		else if (station == 2)
		{
			station2(act);
		}
		else if (station == 3)
		{
			station3(act);
		}
		else if (station == 4)
		{
			station4(act);
		}
	}
		
	private void station1(char act)
	{
		//first food station (pizza)
		char play = act;
		
		//num of pizza out (start)
		rand = new Random(25);
		//% for checking
		Random rndcheck = new Random(11);
		
		//gen for # brought out
		int out = rand.nextInt();
		int chance = 0;
		
		//taken
		if (play == 't')
		{
			if(validCap(weights[0]))
			{
				out -= taken;
				plate[0] += taken;
			}
			else
			{
				toMuch();
			}
		}
				
		//check (2 left)
		if (out <= 2)
		{
			chance = rndcheck.nextInt();
		
			if (chance >= 6)
			{
				if (chance <= 2)
				{
					out += 8;
				}
				else if (chance <= 4)
				{
					out += 16;
				}
				else if (chance <= 6)
				{
					out += 24;
				}
			}
		}
		
		//added (none left)
		if (out == 0)
		{
			out += 8;
		}
		
	} //end station 1
	
	private void station2(char act)
	{
		//second food station (cookies)
		char play = act;
		
		//num of cookies
		rand = new Random(5);
		int out = rand.nextInt() + 36;
		
		//taken
		if (play == 't')
		{
			//if npc
			//Random takes = new Random(4);
			//out -= takes.nextInt() + 1;
			
			//if player
			if(validCap(weights[1]))
			{
				out -= taken;
				plate[1] += taken;
			}
			else
			{
				toMuch();
			}
		}
		
		//added
		if (out == 0)
		{
			out += rand.nextInt() + 36;
		}
	} //end station 2
	
	private void station3(char act)
	{
		//third food station (orange)
		char play = act;
		//num of oranges		
		rand = new Random();
		int out = rand.nextInt(15) + 1;
		
		//taken
		if (play == 't')
		{
			if(validCap(weights[2]))
			{
				out -= taken;
				plate[2] += taken;
			}
			else
			{
				toMuch();
			}
		}
		
		//added
		if (out == 1)
		{
			out = 15;
		}
	} //end station 3
	
	private void station4(char act)
	{
		//fourth food station (fries)
		char play = act;
		
		//num of fries (pack)
		rand = new Random();
		int out = rand.nextInt(10) + 1;
		
		Random rndcheck = new Random(11);
		int chance = 0;
		
		//taken
		if (play == 't')
		{
			if(validCap(weights[3]))
			{
				out -= taken;
				plate[3] += taken;
			}
			else
			{
				toMuch();
			}
		}
		
		//check
		if (out <= 2)
		{
			chance = rndcheck.nextInt();
		
			if (chance >= 6)
			{
				if (chance <= 2)
				{
					out += 2;
				}
				else if (chance <= 4)
				{
					out += 4;
				}
				else if (chance <= 6)
				{
					out += 6;
				}
			} 
		} //end check if
	} //end station 4
	
	
	
	public void clearPlate()
	{
		for(int i = 0; i <= 3; i++)
		{
			plate[i] = 0;
		}
		
		carryCap = 0;
	}

	private boolean validCap(int weight)
	{
		if((carryCap + weight) > 100)
		{
			return false;
		}
		else
		{
			carryCap += weight;
			return true;
		}
	}
	
	private void toMuch()
	{
		//suspicion up
	}
}
