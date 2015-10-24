package game;

public class Inventory {
	//bagged items

	private int[] bagged = {0,0,0,0,0,0}; //[s1,s2,s3,s4,s5,s6]
	private double[] costs = {1.25, 1.00, 0.25, 0.50, 2.00, 4.00};
	
	public Inventory()
	{
		
	}
	
	public void addFood(int food)
	{
		bagged[food]++;
	}
	
	public double profit() //totals food in bag
	{
		double money = 0;
		
		money += (bagged[0] * costs[0]);
		money += (bagged[1] * costs[1]);
		money += (bagged[2] * costs[2]);
		money += (bagged[3] * costs[3]);
		money += (bagged[4] * costs[4]);
		money += (bagged[5] * costs[5]);
		
		return money;
	}
}
