import java.util.Random;

public class Dices implements DiceCardInterface
{
	Random randomizer = new Random();
	private int dices;
	private int[] numbers;
	private String history = "";
	private int throwcount = 0;
	
	public Dices(int quantity)
	{
		dices = quantity;
		numbers = new int[dices + 1];
	}
	
	public int Generate()
	{
		int dicevalue = 0;
		
		for (int i = 0; i < dices; i++)
		{
			dicevalue += randomizer.nextInt(6) + 1;
		}
		
		numbers[throwcount] = dicevalue;
		throwcount++;
		return dicevalue;
	}
	
	public String History()
	{		
		for (int j = 0; j < throwcount; j++)
		{
			history = history + numbers[j] + "  ";
		}

		return history;
	}
}
