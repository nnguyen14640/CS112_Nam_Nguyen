// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class OddOrEvenTest 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		OddOrEven decision = new OddOrEven(0);
		int numbers;
		
		System.out.print("Please enter a number: ");
		numbers = input.nextInt();
		decision.setValue(numbers);
		
		System.out.println(decision.OddEven());
	}
}
