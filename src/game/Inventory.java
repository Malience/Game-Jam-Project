package game;

public class Inventory {
	//bagged items

	private int[] bagged = {0,0,0,0}; //[s1,s2,s3,s4]
	private double[] costs = {0.0, 0.0, 0.0, 0.0};
	
	public Inventory(int[] placed)
	{
		for(int i = 0; i <= 3; i++)
		{
			bagged[i] += placed[i];
		}
	}
	
	public double profit() //totals food in bag
	{
		double money = 0;
		
		money += (bagged[0] * costs[0]);
		money += (bagged[1] * costs[1]);
		money += (bagged[2] * costs[2]);
		money += (bagged[3] * costs[3]);
		
		return money;
	}
}
