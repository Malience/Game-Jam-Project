package game;

public class Mob {

	public Mob(char rank)
	{
		// Create worker || student
		if (rank == 'w')
		{
			Worker w = new Worker();
		}
		else if (rank == 's')
		{
			Student s = new Student();
		}
	}
	
}
