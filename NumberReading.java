// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class NumberReading 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n;
		int m = 1;
		int f = 1;
		boolean equality = false;
		
		System.out.print("Please enter a number: ");
		n = input.nextInt();
		
		while (equality == false)
		{
			f = f * m;
			
			if (m == n)
			{
				System.out.println("F is " + f);
				equality = true;
			}
			else
			{
				m = m + 1;
			}
		}
	}
}
