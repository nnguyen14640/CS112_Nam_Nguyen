// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class DiceMidtermTest 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		DiceMidterm diceSet;
		int gamemode = 0;
		int guess = 0;
		int actual;
		int plays = 1;
		boolean correct = false;
		
		
		System.out.println("Welcome to the Guess a Number Dice Game!");
		System.out.println("Choose a game mode.");
		
		do
		{
			System.out.print("Enter 1 for one-die play, 2 for two-dice play or 3 for three-dice play. ");
			gamemode = input.nextInt();
			
			if (gamemode == 1)
			{
				System.out.println("One die it is. Let us prepare this game...");
			}
			else if (gamemode == 2)
			{
				System.out.println("Two dices it is. Let us prepare this game...");
			}
			else if (gamemode == 3)
			{
				System.out.println("Three dices it is. Let us prepare this game...");
			}
			else
			{
				System.out.println("Invalid response. Please try again.");
			}
		}
		while(gamemode != 1 && gamemode != 2 && gamemode != 3);
		
		if (gamemode == 1)
		{
			System.out.println("\nLet the games begin.");
			diceSet = new OneDieMidterm(gamemode);
			actual = diceSet.Throw();
			System.out.println("The CPU has rolled a 6-sided die. Do you know what number it is?");

			while(correct == false)
			{	
				System.out.print("Please enter a number from 1 to 6. ");
				guess = input.nextInt();
				
				if (guess == actual)
				{
					System.out.println("Congratulations! You guessed the correct number.");
					System.out.println("Took you " + plays + " attempt(s).");
					correct = true;
				}
				else
				{
					System.out.println("Sorry! Not the right number. Try again.");
					plays++;
				}
			}
		}
		else if (gamemode == 2)
		{
			System.out.println("\nLet the games begin.");
			diceSet = new TwoDiceMidterm(gamemode);
			actual = diceSet.Throw();
			System.out.println("The CPU has rolled two 6-sided dies. Do you know what number it is?");
			
			while(correct == false)
			{	
				System.out.print("Please enter a number from 2 to 12. ");
				guess = input.nextInt();
				
				if (guess == actual)
				{
					System.out.println("Congratulations! You guessed the correct number.");
					System.out.println("Took you " + plays + " attempt(s).");
					correct = true;
				}
				else
				{
					System.out.println("Sorry! Not the right number. Try again.");
					plays++;
				}
			}
		}
		else if (gamemode == 3)
		{
			System.out.println("\nLet the games begin.");
			diceSet = new ThreeDicesMidterm(gamemode);
			actual = diceSet.Throw();
			System.out.println("The CPU has rolled three 6-sided dies. Do you know what number it is?");
			
			while(correct == false)
			{	
				System.out.print("Please enter a number from 3 to 18. ");
				guess = input.nextInt();
				
				if (guess == actual)
				{
					System.out.println("Congratulations! You guessed the correct number.");
					System.out.println("Took you " + plays + " attempt(s).");
					correct = true;
				}
				else
				{
					System.out.println("Sorry! Not the right number. Try again.");
					plays++;
				}
			}
		}
	}
}

// Should use explicit @Override, Nam.
