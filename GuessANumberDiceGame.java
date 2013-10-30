// Nam Nguyen
// Cmpr 112

public class GuessANumberDiceGame 
{
	public static void main(String[] args)
	{
		// Construct and use the Dice class in this class
		Dice die = new Dice();
		int cpu_value;
		
		// Retrieving the value from the Dice class
		cpu_value = die.Value();
		
		System.out.println("CPU Number: " + cpu_value);
	}
}
