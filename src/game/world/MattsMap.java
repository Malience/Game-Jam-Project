package game.world;

import game.mob.Worker;
import game.objects.Backpack;
import game.objects.Chair;
import game.objects.Counter;
import game.objects.DrinkMachine;
import game.objects.Oven;
import game.objects.ServingTable;
import game.objects.SpecialChair;
import game.objects.SpecialTable;
import game.objects.Wall;
import game.objects.food.Pizza;
import game.objects.food.PizzaPan;
import game.objects.food.PizzaSlice;

public class MattsMap extends subgame
{
	public MattsMap()
	{
		/*
		 * Create objects such as Walls by using their constructor
		 * Edit them however you'd like
		 * Then put them into the game with World.New(Object);
		 */
		new Pizza(0,0,3);
		World.New(new ServingTable(-4,0,0));
		World.New(new SpecialTable(-4,0,-3));
		World.New(new SpecialChair(-4,0,-4));
		World.New(new Backpack(-5,0,-4));
		
		Node n1 = NodeTree.setNode(3,0,0);
		Node n2 = NodeTree.setNode(-3,0,0);
		Node n3 = NodeTree.setNode(-3,0,-2);
		NodeTree.connect(n1, n2);
		NodeTree.connect(n1, n3);
		
		Worker w = new Worker(-3,0,0);
		w.setTarget(n1);
		World.New(w);
//		World.New(new PizzaSlice(0,0,3));
	}
}
