// Nam Nguyen
// Cmpr 112

public class TwoDiceMidterm extends OneDieMidterm
{
	private int numbers;
	private int dice_rolls;
	
	public TwoDiceMidterm(int dices)
	{
		super(2);
		dice_rolls = dices;
	}
	
	public int Throw()
	{
		for (int i = 0; i < dice_rolls; i++)
		{
			numbers += randomizer.nextInt(6) + 1;
		}
		return numbers;
	}
}
