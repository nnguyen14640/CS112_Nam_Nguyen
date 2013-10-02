// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberBooleanLab4 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		String response;
		int actual = randomizer.nextInt(10) + 1;
		int guess = 0;
		boolean finish = false;
		boolean end = false;
		
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
			}
			else if (smaller)
			{
				System.out.println("Sorry! Number too small.");
			}
			
			if (greater || smaller)
			{
				System.out.print("Do you wish to continue? (Y/N) ");
				response = input.next();
				
				if (response.equals("Y") || response.equals("y"))
				{
					System.out.print("Please try again. Enter a number between 1 and 10. ");
				}
				else
				{
					System.out.println("You declined to continue.");
					end = true;
				}
				
				if (end == true)
				{
					break;
				}
			}
		}
		while (finish == false);
		
		if (finish == false)
		{
			System.out.println("Game over! My number is " + actual + ".");
		}
		else
		{
			System.out.println("You guessed my number! Great Job!");
		}

		input.close();
	}
}
