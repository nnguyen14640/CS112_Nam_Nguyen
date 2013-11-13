// Nam Nguyen
// Cmpr 112

import java.util.Random;

public class OneDieMidterm extends DiceMidterm
{
	Random randomizer = new Random();
	private int numbers;
	private int dice_rolls;
	
	public OneDieMidterm(int dices)
	{
		super(1);
		dice_rolls = dices;
	}
	
	public int Throw()
	{
		for (int i = 0; i < dice_rolls; i++)
		{
			numbers = randomizer.nextInt(6) + 1;
		}
		return numbers;
	}
}
