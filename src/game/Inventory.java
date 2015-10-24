package game;

public class Inventory {
	//bagged items

	private int countS1; //from station 1
	private int countS2; //from station 2
	private int countS3; //from station 3
	private int countS4; //from station 4
	
	public Inventory()
	{
		countS1 = 0;
		countS2 = 0;
		countS3 = 0;
		countS4 = 0;
	}
	
	private void addS1(int num)
	{
		countS1 += num;
	}
	
	private void addS2(int num)
	{
		countS2 += num;
	}
	
	private void addS3(int num)
	{
		countS3 += num;
	}
	
	private void addS4(int num)
	{
		countS4 += num;
	}
	
	private double profit() //totals food in bag
	{
		double money = 0;
		
		money += (countS1 /* *costS1 */ );
		money += (countS2 /* *costS2 */ );
		money += (countS3 /* *costS3 */ );
		money += (countS4 /* *costS4 */ );
		
		return money;
	}
}
