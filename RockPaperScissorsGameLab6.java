// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGameLab6 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int hand;
		String cpu_hand = null;
		String your_hand;
		int games;
		int your_winnings = 0;
		int cpu_winnings = 0;
		
		System.out.print("Welcome to the Rock, Paper, Scissors Game. How many games do you want to play? ");
		games = input.nextInt();
				
		for (int i = 1; i <= games; i++)
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
		}
		
		System.out.println("That is all the games. Calculating results...");
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

// If the user decides to play 3 games, and the computer wins the first 2, you made him play the 3rd game...see if you can improve the game
