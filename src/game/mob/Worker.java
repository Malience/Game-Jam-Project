package game.mob;
import java.util.Random;

import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABB;
import com.base.engine.physics.Collider;

import game.GObject;
import game.RCObject;
import game.interfaces.Interface;
import game.interfaces.InterfaceTrigger;
import game.world.MainGame;
import game.world.Node;
import game.world.NodeTree;

public class Worker extends Mob
{
	int speed;
	GObject target;
	
	public Worker(float x, float y, float z)
	{
		super(x,y,z);
		float width = .3f;
		float height = .3f;
		setTexture("workerrotate.png");
		speed = 2;
		//setRotY(90);
		
		getChildren().add(new InterfaceTrigger(0,0,0,Interface.InteractE,this));
	}
	
	public Worker(float x, float y, float z, Collider c1, Collider c2)
	{
		super(x,y,z);
		float width = .3f;
		float height = .3f;
		setTexture("workerrotate.png");
		speed = 2;
		//setRotY(90);
		
		getChildren().add(new InterfaceTrigger(0,0,0,Interface.InteractE,this, c1, c2));
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
	
	public void setTarget(GObject target)
	{
		this.target = target;
	}
	
	//controls movement
	public void move(float delta)
	{
		if(MainGame.mainPlayer.suspicion())
			target = MainGame.mainPlayer;
		if(target!=null)
		{
			if(target instanceof Node)
			{
				getThis().getTransform().setPos((target.getPos().sub(getThis().getTransform().getPos()).mul(1/2f).normalized().mul(speed*delta)).add(getThis().getTransform().getPos()));
				float check = NodeTree.getDistance(this, (Node)target);
				//System.out.println(check);
				if(check<=.1f)
				{
					Node n = NodeTree.getRandomConnected((Node)target);
					if(n != null)
						target = n;
				}
			}
			else
			{
				getThis().getTransform().setPos((target.getThis().getTransform().getPos().sub(getThis().getTransform().getPos()).mul(1/2f).normalized().mul(speed*delta)).add(getThis().getTransform().getPos()));
			}
			
		}
//		boolean go = turn();
//		int dir = 0;
//		
//		//		0
//		// 270		90
//		//	   180
//		
//		if (go == false)
//		{
//			//forward
//		}
//		else //turn
//		{			
//			//turn right
//			dir = dir + 90;
//			if (dir > 270)
//			{
//				dir = 0;
//			}
//			//turn left
//			dir = dir - 90;
//			if (dir < 0)
//			{
//				dir = 270;
//			}
//			//turn around
//			if (dir >= 180)
//			{
//				dir -= 180;
//			}
//			else
//			{
//				dir += 180;
//			}
		
	}
}
