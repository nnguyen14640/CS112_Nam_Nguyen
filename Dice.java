// Nam Nguyen
// Cmpr 112

import java.util.Random;

public class Dice 
{
	Random randomizer = new Random();
	private int average;
	private int n_bounces;
	private int n_dices;
	
	// Constructor to initialize dices and bounces
	public Dice(int dices, int bounces)
	{
		n_dices = dices;
		n_bounces = bounces;
	}
	public Dice()
	{
		n_bounces = 1;
		n_dices = 1;
	}
	
	// Static method to throw a dice only once
	public static int OneThrow()
	{
		return (int) (Math.random() * 6 + 1);
	}
	// Throw method to throw a certain number of dices for each trial
	public int Throw(int dices, int bounces)
	{
		n_dices = dices;
		n_bounces = bounces;
		
		int sums = 0;
		int value = 0;
		for (int i = 0; i < bounces; i++)
		{
			System.out.println("\nTrial " + (i + 1));
			int roll_value = 0;
			for (int j = 0; j < n_dices; j++)
			{
				System.out.println("\nDice " + (j + 1));
				value = randomizer.nextInt(6) + 1;
				roll_value += value;
				sums += value;
				System.out.println("Rolled a " + value);
			}
			System.out.println("\nRolled value: " + roll_value);
			System.out.println("Current value: " + sums);
		}
		average = sums / n_bounces;
		return average;
	}
	
	// Return the average value of numbers in Throw()
	public int Value()
	{
		return average;
	}
}