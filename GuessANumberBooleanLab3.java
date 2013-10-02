// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberBooleanLab3 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int actual = randomizer.nextInt(10) + 1;
		int guess = 0;
		int chances = 0;
		boolean finish = false;
		
		System.out.print("I am thinking of a number between 1 and 10. Can you guess what it is? ");
		
		do
		{
			guess = input.nextInt();
			boolean greater = (guess > actual);
			boolean smaller = (guess < actual);
			
			if (guess == actual)
			{
				finish = true;
			}
			else if (greater)
			{
				System.out.println("Sorry! Number too big.");
				chances++;
				
				if (chances != 3)
				{
					System.out.print("Try again. Enter a number between 1 to 10. ");
				}
			}
			else if (smaller)
			{
				System.out.println("Sorry! Number too small.");
				chances++;
				
				if (chances != 3)
				{
					System.out.print("Try again. Enter a number between 1 to 10. ");
				}
			}
			
			if (chances == 3)
			{
				break;
			}
		}
		while (finish == false);
		
		if (finish == false)
		{
			System.out.println("Game over! You exhausted all attempts. My number is " + actual + ".");
		}
		else
		{
			System.out.println("You guessed my number! Great Job!");
		}

		input.close();
	}
}
