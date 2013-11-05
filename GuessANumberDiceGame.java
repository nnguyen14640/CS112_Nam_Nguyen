// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class GuessANumberDiceGame 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Dice die = new Dice(); // Initialize the Dice class
		String[] statuses = {"Won", "Lost"};
		String status = null;
		int gamemode;
		int dices = 1;
		int trials = 0;
		int rolled_number = 0;
		int guess = 0;
		
		System.out.println("Welcome to the Dice Game.");
		System.out.println("Choose your game mode.");
		
		do
		{
			System.out.print("Enter 1 for single-roll play or 2 for normal play. ");
			gamemode = input.nextInt();
			
			if (gamemode == 1) // Prompts user to enter a number in a one-time dice roll
			{
				System.out.println("OK then. Let the games begin.");
				rolled_number = Dice.OneThrow(); // Calls OneThrow method from Dice class
				System.out.print("A 6-sided die is thrown. Do you know the number? ");
				guess = input.nextInt();
				System.out.println("The number rolled was a " + rolled_number + ".");
				
				if (guess == rolled_number)
				{
					System.out.println("Congratulations! That was the correct number.");
					status = statuses[0];
				}
				else
				{
					System.out.println("Sorry! That was the wrong guess.");
					status = statuses[1];
				}	
			}
			else if (gamemode == 2) // Prompts user to enter dices to roll and trials to execute
			{
				System.out.print("How many dices do you want to roll? ");
				dices = input.nextInt();
				
				System.out.print("How many trials do you want to execute? ");
				trials = input.nextInt();
				
				System.out.println("OK then. Let us roll the dices for you.");
			}
			else // For not entering 1 or 2
			{
				System.out.println("Invalid entry.");
			}
		}
		while(gamemode != 1 && gamemode != 2);
		
		System.out.println("\nAll trials are executed. Computing game history...");
		System.out.println("\nGame History");
		System.out.println("------------");
		
		if(gamemode == 1)
		{
			System.out.println("Actual guess: " + rolled_number);
			System.out.println("Your guess: " + guess);
			System.out.println("Result: " + status);
		}
		else if (gamemode == 2)
		{
			// Calls Throw() method of Dice class to roll the dices for the trials
			die.Throw(dices, trials); 
			
			// Calls Value() method of Dice class to retrieve the average value of the trials
			System.out.println("\nAverage: " + die.Value());
			System.out.println("Dices rolled: " + dices);
			System.out.println("Trials played: " + trials);
		}
		
		input.close();	
	}
}
