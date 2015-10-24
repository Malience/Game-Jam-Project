package game;
import java.util.Random;


public class Student {

	public Student()
	{
		//create student
	}
	
	//turn or no turn
	private int action()
	{
		Random rand = new Random();
		int num = 0;
		
		num = rand.nextInt(3);
		
		return num;
	} //end turn
	
	//controls movement
	private void move()
	{
		int go = action();
		int dir = 0;
		
		//		0
		// 270		90
		//	   180
		
		if (go == 0)
		{
			//forward
		}
		else if (go == 1)
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
		else
		{
			//stop (food || table)
			
			//needs to be by food station || table
		}
	}
}
