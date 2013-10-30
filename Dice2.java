// Nam Nguyen
// Cmpr 112

import java.util.Random;

public class Dice2 
{
	private int die_value;
	Random randomizer = new Random();
	
	public Dice()
	{
		die_value = randomizer.nextInt(6) + 1;
	}
	
	public void setCPUValue(int value)
	{
		die_value = value;
	}
	
	public int getCPUValue()
	{
		return die_value;
	}
}
