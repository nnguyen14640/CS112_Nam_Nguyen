import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiceExecutionTest 
{
	public static void main(String[] args)
	{
		System.out.println("Begin execution of Single Die rolls");
		
		ExecutorService execution = Executors.newCachedThreadPool();
		
		for (int i = 0; i <= 25; i++)
		{
			DiceThreadRun threadrun = new DiceThreadRun(String.valueOf(i));
			execution.execute(threadrun);
		}
		
		execution.shutdown();
		System.out.println("Single roll execution complete");
	}
}
