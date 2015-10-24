package game;

public class Table {

	private int[] onTable = {0,0,0,0}; //[s1,s2,s3,s4]
	private int[] weights = {0,0,0,0}; //[s1,s2,s3,s4]
	Food stuff = new Food();
	private int tableCap = 0;
	
	public Table()
	{
		
	}
	
	public void setDown(int[] food)
	{
		for(int i = 0; i <= 3; i++)
		{
			onTable[i] += food[i];
		}
		
		stuff.clearPlate();
		capTaken();
	}
	
	public int[] getFood()
	{
		return onTable;
	}
	
	private void capTaken()
	{
		int newCap = 0;
		
		for(int i = 0; i <= 3; i++)
		{
			newCap += (onTable[i]*weights[i]);
		}
		
		tableCap += newCap;
		
		if(tableCap > 100)
		{
			//up suspicion
		}
	}
	
}
