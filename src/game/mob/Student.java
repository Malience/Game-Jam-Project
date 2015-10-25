package game.mob;

import java.util.Random;

import game.GObject;
import game.world.MainGame;
import game.world.Node;
import game.world.NodeTree;

public class Student extends Mob
{
	int speed;
	GObject target;
	
	public Student(float x, float y, float z)
	{
		super(x,y,z);
		float width = .3f;
		float height = .3f;
		setTexture("studentRotate.png");
		speed = 2;
		setRotY(90);
	}
	
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
	}
}
