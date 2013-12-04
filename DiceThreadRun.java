
public class DiceThreadRun extends Dices implements Runnable
{
	String threads;
	
	public DiceThreadRun(String threadname)
	{
		super(1); // Run using only one dice
		threads = threadname;
	}
	
	@Override
	public void run()
	{
		System.out.printf("Thread %s thrown %d\n", threads, super.Generate());
	}	
}
