import java.util.Random;

public class Cards implements DiceCardInterface
{
	Random randomizer = new Random();
	private int cards;
	private int[] numbers;
	private String history = "";
	private int cardpick = 0;
	
	public Cards(int quantity)
	{
		cards = quantity;
		numbers = new int[quantity + 1];
	}
	
	public int Generate()
	{
		int cardnumber = 0;
		
		for (int i = 0; i < cards; i++)
		{
			cardnumber += randomizer.nextInt(52) + 1;
		}
		
		numbers[cardpick] = cardnumber;
		cardpick++;
		return cardnumber;
	}
	
	public String History()
	{
		for (int j = 0; j < cardpick; j++)
		{
			history = history + numbers[j] + "  ";
		}
		
		return history;
	}
}
