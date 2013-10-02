// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		String your_hand;
		String cpu_hand = null;
		int setting;
		int statistic = 0;
		boolean responses = false;
		
		setting = randomizer.nextInt(3) + 1;
		
		if (setting == 1)
		{
			cpu_hand = "ROCK";
		}
		else if (setting == 2)
		{
			cpu_hand = "PAPER";
		}
		else if (setting == 3)
		{
			cpu_hand = "SCISSORS";
		}
		
		do
		{
			System.out.print("Please choose a hand (ROCK, PAPER, or SCISSORS) in all-caps. ");
			your_hand = input.next();
			
			if (your_hand.equals("ROCK") || your_hand.equals("PAPER") || your_hand.equals("SCISSORS"))
			{
				responses = true;
			}
			else
			{
				System.out.println(your_hand + " is not a valid response. Please try again.");
			}
		}
		while (responses == false);
			
		System.out.println("The CPU chose " + cpu_hand + ".");
		
		if (your_hand.equals("ROCK"))
		{
			if (cpu_hand.equals("ROCK"))
			{
				System.out.println("No winner");
			}
			else if (cpu_hand.equals("PAPER"))
			{
				System.out.println("Paper beats rock.");
				statistic = -1;
			}
			else if (cpu_hand.equals("SCISSORS"))
			{
				System.out.println("Rock beats scissors.");
				statistic = 1;
			}
		}
		else if (your_hand.equals("PAPER"))
		{
			if (cpu_hand.equals("ROCK"))
			{
				System.out.println("Paper beats rock.");
				statistic = 1;
			}
			else if (cpu_hand.equals("PAPER"))
			{
				System.out.println("No winner");
			}
			else if (cpu_hand.equals("SCISSORS"))
			{
				System.out.println("Scissors beat paper.");
				statistic = -1;
			}
		}
		else if (your_hand.equals("SCISSORS"))
		{
			if (cpu_hand.equals("ROCK"))
			{
				System.out.println("Rock beats scissors.");
				statistic = -1;
			}
			else if (cpu_hand.equals("PAPER"))
			{
				System.out.println("Scissors beat paper.");
				statistic = 1;
			}
			else if (cpu_hand.equals("SCISSORS"))
			{
				System.out.println("No winner.");
			}
		}
		
		if (statistic == -1)
		{
			System.out.println("CPU Wins!");
		}
		else if (statistic == 0)
		{
			System.out.println("It's a draw.");
		}
		else if (statistic == 1)
		{
			System.out.println("You win!");
		}
		
		input.close();
	}
}
