package game;
import java.util.Random;

public class Worker
{
	int speed;
	
	public Worker()
	{
		//creates worker
	}
	
	//turn or no turn
	private boolean turn()
	{
		Random rand = new Random();
		int num = 0;
		
		num = rand.nextInt(2);
		
		if (num == 0)
		{
			return true; //turns
		}
		else
			return false; //no turn
	} //end turn
	
	//controls movement
	private void move()
	{
		boolean go = turn();
		int dir = 0;
		
		//		0
		// 270		90
		//	   180
		
		if (go == false)
		{
			//forward
		}
		else //turn
		{			
			//turn right
			dir = dir + 90;
			if (dir > 270)
			{
				dir = 0;
			}
			//turn left
			dir = dir - 90;
			if (dir < 0)
			{
				dir = 270;
			}
			//turn around
			if (dir >= 180)
			{
				dir -= 180;
			}
			else
			{
				dir += 180;
			}
		}
	}
}
