package game.mob;
import java.util.Random;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;

import game.RCObject;

public class Worker extends RCObject
{
	int speed;
	
	public Worker(float x, float y, float z)
	{
		super(x,y,z);
		float width = .3f;
		float height = .3f;
		
		setCollider(new AABB(new Vector3f(x - width/2, y - height/2, z - width/2), new Vector3f(x + width/2, y + height/2, z + width/2)));
		setDensity(true);
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
