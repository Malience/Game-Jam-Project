package game.objects.food;

import game.world.World;

public class Pizza 
{
	public Pizza(float x, float y, float z)
	{
		PizzaPan pan = new PizzaPan(x,y,z);
		PizzaSlice[] slices = new PizzaSlice[8];
		float degrees = 0;
		for(int i = 0; i < 8; i++)
		{
			slices[i] = new PizzaSlice(x,y,z);
			slices[i].setRotY(degrees);
			World.New(slices[i]);
			degrees += 45;
		}
		World.New(pan);
	}
}
