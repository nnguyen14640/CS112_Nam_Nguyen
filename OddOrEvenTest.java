// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class OddOrEvenTest 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		OddOrEven decision = new OddOrEven(0);
		OddOrEven decision2 = new OddOrEven();
		int numbers;
		
		System.out.print("Please enter a number: ");
		numbers = input.nextInt();
		decision.setValue(numbers);
		
		System.out.println(decision.OddEven());
		
		System.out.println("Random number: " + decision2.getRValue() + " is " + decision2.OddsOrEvens());
	}
}
