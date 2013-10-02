// Nam Nguyen
// Cmpr 112

import java.util.Random;
import java.util.Scanner;

public class GuessANumberBooleanLab1 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		int actual = randomizer.nextInt(10) + 1;
		int guess = 0;
		
		System.out.print("I am thinking of a number between 1 and 10. Can you guess what it is? ");
		
		guess = input.nextInt();
		boolean greater = (guess > actual);
		boolean smaller = (guess < actual);
		
		if (guess == actual)
		{
			System.out.println("You guessed my number! Great Job.");
		}
		else if (greater)
		{
			System.out.println("Sorry! Number too big. My number is " + actual + ".");
		}
		else if (smaller)
		{
			System.out.println("Sorry! Number too small. My number is " + actual + ".");
		}

		input.close();
	}
}
