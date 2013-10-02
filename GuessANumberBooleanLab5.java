// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberBooleanLab5 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int response = 0;
		int actual = randomizer.nextInt(10) + 1;
		int guess = 0;
		boolean finish = false;
		
		System.out.print("I am thinking of a number between 1 and 10. Can you guess what it is? ");
		
		while (finish == false)
		{
			guess = input.nextInt();
			boolean greater = (guess > actual);
			boolean smaller = (guess < actual);
			boolean valid = false;
			
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
				while (valid == false)
				{
					System.out.print("Do you wish to continue? Enter 1 for Yes, 2 for No. ");
					response = input.nextInt();
					
					switch(response)
					{
					case (1):
					{
						System.out.print("Please try again. Enter a number between 1 and 10. ");
						break;
					}
					case (2):
					{
						System.out.println("You declined to continue.");
						break;
					}
					default:
					{
						System.out.println("Invalid response.");
					}
					}
					
					if (response == 1 || response == 2)
					{
						valid = true;
					}
				}
			}
			
			if (response == 2)
			{
				break;
			}
		}
		
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
