package game;

public class Mob {

	public Mob()
	{
		
	}
	
	public Mob(char rank)
	{
		// Create worker || student || player
		if (rank == 'w')
		{
			Worker w = new Worker();
		}
		else if (rank == 's')
		{
			Student s = new Student();
		}
		else if (rank == 'p')
		{
			Player p = new Player();
		}
	}
	
}
