// Nam Nguyen
// Cmpr 112

import java.util.Scanner;

public class LunchProcess 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String breakfast;
		String thirsty;
		
		// Lunch Process
		System.out.println("You entered the lunch room.");
		System.out.println("You feel hungry.");
		System.out.println("You decide to get in line.");
		System.out.println("You buy yourself lunch.");
		// Breakfast input
		System.out.print("Did you have breakfast in the morning? (Y/N) ");
		breakfast = input.next();
		// Thirsty input
		System.out.print("Are you thirsty? (Y/N) ");
		thirsty = input.next();
		
		// Condition of Breakfast and Thirsty inputs
		if (breakfast.equals("Y") || breakfast.equals("y")) // When person had breakfast
		{
			System.out.println("You had breakfast this morning.");
			
			if (thirsty.equals("Y") || thirsty.equals("y")) // Had breakfast and thirsty
			{
				System.out.println("You are thirsty, therefore bought Diet Coke.");
			}
			else // Had breakfast but not thirsty
			{
				System.out.println("You are not thirsty, therefore bought water.");
			}
		}
		else // When person did not have breakfast
		{
			System.out.println("You did not have breakfast this morning.");
			
			if (thirsty.equals("Y") || thirsty.equals("y")) // Thirsty but did not have breakfast
			{
				System.out.println("You are thirsty, therefore bought Coke.");
			}
			else // Did not have breakfast and is not thirsty
			{
				System.out.println("You are not thirsty, therefore bought water.");
			}
		}
		
		System.out.println("You find a table and began eating lunch.");
		System.out.println("You finished lunch and therefore return the lunch tray.");
		System.out.println("You left the lunch room.");
		input.close();
	}
}
