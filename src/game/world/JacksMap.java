package game.world;

import java.util.ArrayList;

import game.objects.Backpack;
import game.objects.Counter;
import game.objects.DrinkMachine;
import game.objects.SpecialChair;
import game.objects.SpecialTable;
import game.objects.Table;
import game.objects.Chair;
import game.objects.Wall;
import game.objects.food.Cookie;
import game.objects.food.Fries;
import game.objects.food.IceCream;

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
		
		createWalls();
		createTableSets();
		createSpecials();
		createDrinkExp();
		createFryStation();
		createIceCreamStation();
		
		
	}

	public void createWalls()
	{
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
	} //end walls

	public void createTableSets()
	{
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
	} //end table sets

	public void createSpecials()
	{
		//player's table,chair, and backpack
		SpecialChair sc = new SpecialChair(0.7f,0f,-6f);
		sc.setRotY(270);
		World.New(sc);
		
		sc = new SpecialChair(1.3f,0f,-6f);
		sc.setRotY(90);
		World.New(sc);
		
		SpecialTable st = new SpecialTable(1f,0f,-6f);
		World.New(st);
		
		Backpack bp = new Backpack(1f,0f,-6.2f);
		World.New(bp);	
	} //end specials

	public void createDrinkExp()
	{
		Table t;
		
		//inc length for drink area
		t = new Table(3.25f,0f,0f);
		World.New(t);		
		t = new Table(3.50f,0f,0f);
		World.New(t);
		t = new Table(3.75f,0f,0f);
		World.New(t);
		t = new Table(4f,0f,0f);
		World.New(t);
		
		DrinkMachine dm = new DrinkMachine(4,0.2f,-0.05f);
		dm.setRotY(180);
		World.New(dm);
	} //end drink expansion

	public void createFryStation()
	{
		Counter ctr;
		Fries fs;
		
		//counters
		ctr = new Counter(-5f,0f,2f);
		ctr.setRotY(225f);
		World.New(ctr);
		
		ctr = new Counter(-4.8f,0f,2.2f);
		ctr.setRotY(225f);
		World.New(ctr);
		
		ctr = new Counter(-4.6f,0f,2.4f);
		ctr.setRotY(225f);
		World.New(ctr);
		
		//fries
		fs = new Fries(-4.95f,0.2f,2.05f);
		fs.setRotY(45);
		World.New(fs);
		
		fs = new Fries(-4.75f,0.2f,2.25f);
		fs.setRotY(45);
		World.New(fs);
		
		fs = new Fries(-4.55f,0.2f,2.45f);
		fs.setRotY(45);
		World.New(fs);
	}

	public void createIceCreamStation()
	{
		Counter ctr;
		IceCream ic;
		
		//counters
		ctr = new Counter(5f,0f,2f);
		ctr.setRotY(315f);
		World.New(ctr);
				
		ctr = new Counter(4.8f,0f,2.2f);
		ctr.setRotY(315f);
		World.New(ctr);
				
		ctr = new Counter(4.6f,0f,2.4f);
		ctr.setRotY(315f);
		World.New(ctr);
				
		//Ice cream
		ic = new IceCream(4.95f,0.2f,2.05f);
		ic.setRotY(225);
		World.New(ic);
		
		ic = new IceCream(4.75f,0.2f,2.25f);
		ic.setRotY(225);
		World.New(ic);
		
		ic = new IceCream(4.55f,0.2f,2.45f);
		ic.setRotY(225);
		World.New(ic);
	} // create Ice cream station
}
