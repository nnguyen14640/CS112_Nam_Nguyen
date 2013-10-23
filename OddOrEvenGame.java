// Nam Nguyen
// Cmpr 112

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class OddOrEvenGame
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int cpu_number;
		int remainder;
		int end_games = 0;
		double games = 1;
		double your_wins = 0;
		double accuracy;
		boolean valid = false;
		String[] classify = {"EVEN", "ODD"};
		String[] result = {"Win", "Lose"};
		int[] status = new int[2];
		String number_type;
		String your_answer = null;
		
		System.out.println("Welcome to the Odd or Even game!");
		System.out.print("How many games do you want to play? ");
		end_games = input.nextInt();
		
		if (end_games == 0)
		{
			System.exit(0);
		}
		
		System.out.println("Let the games begin!");
		String[] your_history = new String[end_games];
		int[] cpu_numbers = new int[end_games];
		String[] cpu_history = new String[end_games];
		String[] game_results = new String[end_games];
		
		for (int i = 0; i < end_games; i++) 
		{
			cpu_number = randomizer.nextInt(100) + 1;
			remainder = cpu_number % 2;
			valid = false;
			
			if (remainder == 0)
			{
				number_type = classify[0];
			}
			else
			{
				number_type = classify[1];
			}
			
			do
			{
				System.out.println("Game " + (int) games);
				System.out.print("The CPU has a number in mind. Is the number odd or even? Enter in all-caps. ");
				your_answer = input.next();
				your_history[i] = your_answer;
				cpu_history[i] = number_type;
				cpu_numbers[i] = cpu_number;
				
				if (your_answer.equals(null))
				{
					System.exit(0);
				}
				else if (your_answer.equals("EVEN") || your_answer.equals("ODD"))
				{
					valid = true;
				}
				else
				{
					System.out.println(your_answer + " is not a valid response. Please try again.");
				}
			}
			while (valid == false);
			
			System.out.println("The CPU picked the number " + cpu_number + ". The number is " + number_type);
			
			if (your_answer.equals(number_type))
			{
				System.out.println("Congratulations! You have correctly guessed the type." + "\n");
				status[0]++;
				your_wins++;
				games++;
				game_results[i] = result[0];
			}
			else
			{
				System.out.println("Sorry! Better luck next time." + "\n");
				status[1]++;
				games++;
				game_results[i] = result[1];
			}
		}
		
		System.out.println("Game over. Computing your Game History..." + "\n");
		System.out.println("Game History");
		System.out.println("------------");
		
		for (int i = 0; i < end_games ; i++)
		{
			System.out.println("Game " + i);
			System.out.println("You chose: " + your_history[i]);
			System.out.println("CPU chose: " + cpu_history[i]);
			System.out.println("Result: " + game_results[i] + "\n");
		}
		
		accuracy = (your_wins / games) * 100;
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Games played: " + (int) games);
		System.out.println("Your wins: " + (int) your_wins);
		System.out.printf("Accuracy: " + df.format(accuracy) + " percent" + "\n");
		
		if (accuracy == 100)
		{
			System.out.println("Luck is totally on your side today. A perfect match!");
		}
		else if (accuracy >= 75 && accuracy <= 99)
		{
			System.out.println("You have won most of the games. Nice job!");
		}
		else if (accuracy >= 50 && accuracy < 75)
		{
			System.out.println("Not too bad. Most of the win chances fall here if you played a lot.");
		}
		else if (accuracy < 50)
		{
			System.out.println("Luck was not on your side today. Better luck next time.");
		}
	}
}
