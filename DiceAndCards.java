
public class DiceAndCards 
{
	public static void main(String[] args)
	{
		Dices die = new Dices(3);
		System.out.println("Recent Dice rolled: " + die.Generate());
		System.out.println("Dice rolled history: " + die.History());
		
		Cards card = new Cards(8);
		System.out.println("Recent Card picked: " + card.Generate());
		System.out.println("Cards picked history: " + card.History());
	}
}
