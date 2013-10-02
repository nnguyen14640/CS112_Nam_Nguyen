// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberLab6 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int actual;
		int guess;
		int chances = 0;
		
		actual = randomizer.nextInt(10) + 1;
		
		System.out.print("I am thinking of a number between 1 and 10. Can you guess what it is? ");
		
		do
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
				chances++;
			}
			else if (guess > actual)
			{
				System.out.println("Sorry! The number you enter is too big.");
				chances++;
			}
			
			if (guess != actual && chances != 3)
			{
				System.out.print("Try again. Enter another number between 1 and 10. ");
			}
		}
		while (chances != 3);

		if (chances == 3)
		{
			System.out.println("Game over! You exhausted all attempts. My number is " + actual + ".");
		}
		
		input.close();
	}
}
