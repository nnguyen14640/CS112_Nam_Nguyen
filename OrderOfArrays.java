// Nam Nguyen
// Cmpr 112

import java.util.Arrays;

public class OrderOfArrays 
{
	public static void main(String[] args)
	{
		int [] numbers = new int[6];
		int sums = 0;
		int average;
		numbers[0] = 123;
		numbers[1] = 456;
		numbers[2] = 479;
		numbers[3] = 135;
		numbers[4] = 246;
		numbers[5] = 135;
		
		Arrays.sort(numbers);
		
		System.out.println("Sorted numbers from lowest to highest: ");
		
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.println(numbers[i]);
			sums += numbers[i];
		}
		
		average = sums / numbers.length;
		
		System.out.println("\nAverage value of all numbers: " + average);
	}
}
