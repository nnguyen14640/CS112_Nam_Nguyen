// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class GuessANumberDiceGame 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int cpu_number;
		int your_number;
		String continuation = "Y";
		int correct = 0;
		int gameplays = 1;
		int[] cpu_numbers = new int[100];
		int[] your_numbers = new int[100];
		
		System.out.println("Welcome to the Guess the Dice Game - Variation of Guess A Number Game.");
		
		gameplay_loop:
		while (continuation.equals("Y"))
		{
			Dice die = new Dice();
			boolean valid = false;
			cpu_number = die.getCPUValue();
			System.out.print("The CPU has rolled a 6-sided die. Do you know what number is it? ");
			your_number = input.nextInt();
			cpu_numbers[gameplays - 1] = cpu_number;
			your_numbers[gameplays - 1] = your_number;
			System.out.println("The CPU rolled a " + cpu_number + ".");
			
			if (your_number == cpu_number)
			{
				System.out.println("Congratulations! That was the number.");
				correct++;
			}
			else
			{
				System.out.println("Sorry! You guessed wrong.");
				
				if (your_number > 6)
				{
					System.out.println("Number is greater than 6.");
				}
			}
			
			do
			{
				System.out.print("Would you like to play another game? (Y/N) ");
				continuation = input.next();
				
				if (continuation.equals("Y"))
				{
					System.out.println("Get ready for the next game.");
					valid = true;
					
					if (gameplays >= 100)
					{
						System.out.println("You have played too many games! I will stop playing.");
						break gameplay_loop;
					}
					
					gameplays++;
				}
				else if (continuation.equals("N"))
				{
					System.out.println("You declined to continue.");
					valid = true;
				}
				else
				{
					System.out.println("Invalid entry.");
				}
			}
			while (valid == false);	
		}
		
		System.out.println("Displaying game history..." + "\n");
		System.out.println("Game History");
		System.out.println("------------");
		System.out.println("Numbers you entered from the first to the last.");
	
		for (int i = 0; i < gameplays; i++)
		{
			System.out.print(your_numbers[i] + "  ");
		}
		
		System.out.println("\nNumbers CPU rolled from the first to the last.");
		
		for (int j = 0; j < gameplays; j++)
		{
			System.out.print(cpu_numbers[j] + "  ");
		}
		
		System.out.println("\nNumber of correct guesses: " + correct);
		System.out.println("Total games played: " + gameplays);
		input.close();
	}
}