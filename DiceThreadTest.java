
public class DiceThreadTest 
{
	public static void main(String[] args)
	{
		System.out.println("Begin Single Die rolls");
		
		for (int i = 0; i <= 25; i++)
		{
			Runnable threadrun = new DiceThreadRun(String.valueOf(i));
			Thread threads = new Thread(threadrun);
			threads.start();
		}
		
		System.out.println("Single roll complete");
	}
}
