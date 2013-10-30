// Nam Nguyen
// Cmpr 112

import java.util.Random;

public class Dice 
{
	private int die_value;
	Random randomizer = new Random();
	
	// Constructs and initializes the die value
	public Dice()
	{
		die_value = randomizer.nextInt(6) + 1;
	}
	
	// Sets the value of the die
	public void Throw(int value)
	{
		die_value = value;
	}
	
	// Returns the value of the die
	public int Value()
	{
		return die_value;
	}
}
