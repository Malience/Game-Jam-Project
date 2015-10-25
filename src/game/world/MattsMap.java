package game.world;

import game.objects.Chair;
import game.objects.Counter;
import game.objects.DrinkMachine;
import game.objects.Oven;
import game.objects.ServingTable;
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
//		World.New(new PizzaPan(0,0,3));
//		World.New(new PizzaSlice(0,0,3));
	}
}
