package game.world;

import java.util.ArrayList;

import game.objects.Table;
import game.objects.Chair;
import game.objects.Wall;

import com.base.engine.core.GameObject;

public class JacksMap extends subgame
{
	public JacksMap()
	{
		/*
		 * Create objects such as Walls by using their constructor
		 * Edit them however you'd like
		 * Then put them into the game with World.New(Object);
		 */
		
		//Top wall
		Wall tWall;
		for(double i = -9.5; i <= 30; i++)
		{
			tWall = new Wall((float)(i+0.1),(float)(0),(float)(29.9));
			World.New(tWall);
		}
		
		//right wall
		Wall rWall = new Wall((float)1.0,(float)0.0,(float)1.0);		
		for(double i = -10.0; i <= 30; i++)
		{
			rWall = new Wall((float)(30.0),(float)(0.0),(float)(i+0.1));
			rWall.setRotY((float)2.0015);
			World.New(rWall);
		}
		
		//bottom wall
		Wall bWall;
		for(double i = -9.5; i <= 30; i++)
		{
			bWall = new Wall((float)(i+0.1),(float)(0),(float)(-10.0));
			World.New(bWall);
		}
		
		//left wall
		Wall lWall = new Wall((float)1.0,(float)0.0,(float)1.0);		
		for(double i = -10.0; i <= 30; i++)
		{
			lWall = new Wall((float)(-10.0),(float)(0.0),(float)(i+0.1));
			lWall.setRotY((float)2.0015);
			World.New(lWall);
		}
		
		//table set up w/ 2 chairs 
		Chair y;
		Table t;
				
		//loop chair sets
		int sets = 4;
		
		float[][] cPos = new float[sets][2];
		cPos[0][0] = 2f;	cPos[0][1] = -4.5f;
		cPos[1][0] = 0f;	cPos[1][1] = -4f;
		cPos[2][0] = 4f;	cPos[2][1] = -5f;
		cPos[3][0] = 3f;	cPos[3][1] = -3f;
		
		for(int i = 0; i < sets; i++)
		{
			t = new Table(cPos[i][0],0f,cPos[i][1]);
			World.New(t);
			
			y = new Chair(cPos[i][0]-0.3f,0f,cPos[i][1]);
			y.setRotY(270f);
			World.New(y);
			
			y = new Chair(cPos[i][0]+0.3f,0f,cPos[i][1]);
			y.setRotY(90f);
			World.New(y);
		}
	}
}
