// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissorsGameLab1 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int hand;
		String cpu_hand = null;
		String your_hand;
		int games = 0;
		int your_winnings = 0;
		int cpu_winnings = 0;
		int current_game = 0;
		boolean continuation = true;
		
		System.out.print("Welcome to the Rock, Paper, Scissors Game. How many games do you want to play? ");
		games = input.nextInt();
		
		if (games == 0)
		{
			System.exit(0);
		}
		
		int mean = games / 2;
		System.out.println("Let the games begin.");
		
		while (continuation == true)
		{
			hand = randomizer.nextInt(3) + 1;
			boolean responses = false;
			
			if (hand == 1)
			{
				cpu_hand = "ROCK";
			}
			else if (hand == 2)
			{
				cpu_hand = "PAPER";
			}
			else if (hand == 3)
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
					System.out.println("Paper beats rock. CPU wins this round.");
					cpu_winnings++;
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					System.out.println("Rock beats scissors. You win this round.");
					your_winnings++;
				}
			}
			else if (your_hand.equals("PAPER"))
			{
				if (cpu_hand.equals("ROCK"))
				{
					System.out.println("Paper beats rock. You win this round.");
					your_winnings++;
				}
				else if (cpu_hand.equals("PAPER"))
				{
					System.out.println("No winner");
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					System.out.println("Scissors beat paper. CPU wins this round.");
					cpu_winnings++;
				}
			}
			else if (your_hand.equals("SCISSORS"))
			{
				if (cpu_hand.equals("ROCK"))
				{
					System.out.println("Rock beats scissors. CPU wins this round.");
					cpu_winnings++;
				}
				else if (cpu_hand.equals("PAPER"))
				{
					System.out.println("Scissors beat paper. You win this round.");
					your_winnings++;
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					System.out.println("No winner.");
				}
			}
			
			current_game++;
			
			if (cpu_winnings > mean || your_winnings > mean)
			{
				System.out.println("A winner has been determined. No further plays required.");
				continuation = false;
			}
			
			if (current_game == games)
			{
				System.out.println("That is all the games. Calculating results...");
				continuation = false;
			}
		}
		
		System.out.println("RESULTS:");
		System.out.println("--------");
		System.out.println("Your wins: " + your_winnings);
		System.out.println("CPU wins: " + cpu_winnings);
		
		if (your_winnings > cpu_winnings)
		{
			System.out.println("You are the winner!");
		}
		else if (your_winnings < cpu_winnings)
		{
			System.out.println("The CPU wins!");
		}
		else
		{
			System.out.println("Wow... It's a draw!");
		}
		input.close();
	}
}
