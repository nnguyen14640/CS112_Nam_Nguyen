// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberLab7 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int actual;
		int guess;
		String decision;
		boolean resume = true;
		
		actual = randomizer.nextInt(10) + 1;
		
		System.out.print("I am thinking of a number between 1 and 10. Can you guess what it is? ");
		
		while (resume == true)
		{
			guess = input.nextInt();
			
			if (guess == actual)
			{
				System.out.println("You guess my number. Great Job!");
				break;
			}
			else if (guess < actual)
			{
				System.out.println("Sorry! The number you enter is too small.");
			}
			else if (guess > actual)
			{
				System.out.println("Sorry! The number you enter is too big.");
			}
			
			if (guess != actual)
			{
				System.out.print("Do you wish to continue? (Y/N) ");
				decision = input.next();
				
				if (decision.equals("Y") || decision.equals("y"))
				{
					System.out.print("Try again. Enter another number between 1 and 10. ");
				}
				else
				{
					System.out.println("You declined to continue.");
					resume = false;
				}
			}
		}
		
		if (resume == false)
		{
			System.out.println("Game over! My number is " + actual + ".");
		}
		input.close();
	}
}
