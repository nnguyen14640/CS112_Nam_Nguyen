// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberGame 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int actual = randomizer.nextInt(10) + 1;
		int guess = 0;
		boolean answer = false;
		int current_play = 1;
		int attempts = 1;
		int gameplays = 0;		
		
		System.out.println("Welcome to the Guess A Number Game!");
		System.out.print("How many games do you want to play? ");
		gameplays = input.nextInt();
		
		int[] cpu_input = new int[gameplays];
		int[] tries = new int[gameplays];
		
		System.out.println("Let the games begin." + "\n");
		
		for (int i = 0; i < gameplays; i++)
		{
			System.out.println("Game " + current_play);
			System.out.print("I am thinking of a number between 1 and 10. Can you guess what it is? ");
			cpu_input[i] = actual;
			attempts = 1;
			answer = false;
			
			do
			{
				guess = input.nextInt();
				
				if (guess == actual)
				{
					System.out.println("You guessed my number. Great Job!");
					current_play++;
					tries[i] = attempts;
					answer = true;
				}
				else if (guess > actual)
				{
					System.out.println("Sorry! The number you entered is too big.");
					
					if (guess > 10)
					{
						System.out.println(guess + " is a number outside the range." );
						attempts++;
					}
					else
					{
						attempts++;
					}
				}
				else if (guess < actual)
				{
					System.out.println("Sorry! The number you entered is too small.");
					attempts++;
				}
				
				if (answer == false)
				{
					System.out.print("Please try again. Enter a number between 1 and 10. ");
				}
				else
				{
					if (i == gameplays - 1)
					{
						System.out.println("That is all the games. Computing your Game History..." + "\n");
					}
					else
					{
						System.out.println("Get ready for the next game." + "\n");
						actual = randomizer.nextInt(10) + 1;
					}
				}
			}
			while(answer == false);	
		}		
		
		System.out.println("Game History");
		System.out.println("------------");
		
		for (int j = 1; j <= gameplays; j++)
		{
			System.out.println("Game " + j);
			System.out.println("CPU number for this game: " + cpu_input[j - 1]);
			System.out.println("Number of attempts for this game: " + tries[j - 1] + "\n");
		}
		
		input.close();
	}
}

//tries[i] = attempts; <--- You need to save the guess, Nam.
