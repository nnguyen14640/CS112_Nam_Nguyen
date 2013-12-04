import java.util.ArrayList;
import java.util.Scanner;

public class DiceAndCards 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int gamemode;
		int games = 0;
		boolean valid = false;
		Dices diceplay = null;
		int dices = 0;
		int rolled_number;
		int diceguess;
		Cards cardplay = null;
		int cardpick = 0;
		int picked_card;
		int cardguess;
		ArrayList<Integer> your_inputs = null;
		ArrayList<Integer> your_inputs2 = null;
		ArrayList<Integer> attempts = null;
		
		System.out.println("Welcome to the Dice and Cards Game!");
		System.out.println("Please choose a game mode.");
		
		// Initial gamemode response
		do
		{
			System.out.print("Enter 1 for Dice game only, 2 for Card game only, or 3 for Dice and Card Game: ");
			gamemode = input.nextInt();
			
			if (gamemode == 1)
			{
				System.out.println("Dice it is. Let us prepare the game...");
				System.out.println("Before we begin, how many dices do you want to play? ");
				System.out.print("Enter a number or zero to exit: ");
				dices = input.nextInt();
				
				if (dices == 0)
				{
					System.out.println("No dices will be played. The game will now exit.");
					System.exit(0);
				}
			}
			else if (gamemode == 2)
			{
				System.out.println("Cards it is. Let us prepare the game...");
				System.out.println("Before we begin, how many cards do you want to pick out? ");
				System.out.print("Enter a number or zero to exit: ");
				cardpick = input.nextInt();
				
				if (cardpick == 0)
				{
					System.out.println("No cards will be picked. The game will now exit.");
					System.exit(0);
				}
			}
			else if (gamemode == 3)
			{	
				System.out.println("Dice and Cards it is. Let us prepare the game...");
				System.out.println("Before we begin, we need to know some information.");
				System.out.print("How many dices do you want to play? ");
				dices = input.nextInt();
				System.out.print("How many cards do you want to pick out? ");
				cardpick = input.nextInt();
				
				if (dices == 0 || cardpick == 0)
				{
					System.out.println("You have entered zero for either dices or cards.");
					System.out.println("The game will adjust according to this input.");
					
					if (dices == 0)
					{
						gamemode = 2;
					}
					else if (cardpick == 0)
					{
						gamemode = 1;
					}
				}
				else if (dices == 0 && cardpick == 0)
				{
					System.out.println("No plays will be conducted. The game will now exit.");
					System.exit(0);
				}
			}
			else
			{
				System.out.println("Invalid entry. Please try again.");
			}
		}
		while (gamemode != 1 && gamemode != 2 && gamemode != 3);
		
		// Game play according to the gamemode
		// Dice game only
		if (gamemode == 1)
		{
			while (valid == false)
			{
				try
				{
					String initial = "";
					
					do
					{
						System.out.print("How many games do you want to play? Please enter a number: ");
						initial = input.next();
						games = Integer.parseInt(initial);
						
						if (games == 0)
						{
							System.out.println("Must be a number greater than zero.");
						}
						else
						{
							valid = true;
						}
					}
					while(initial == "");
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid entry. Must be a number.");
				}
			}
			
			System.out.println("Let the games begin.");
			your_inputs = new ArrayList<Integer>();
			attempts = new ArrayList<Integer>();
			diceplay = new Dices(dices);
			
			for (int i = 0; i < games; i++)
			{
				boolean correct = false;
				int trials = 1;
				rolled_number = diceplay.Generate();
				
				System.out.println("\nThe CPU has rolled " + dices + " 6-sided die(s). Can you guess the sum of the numbers? ");
				
				while (correct == false)
				{
					System.out.print("Please enter a number: ");
					diceguess = input.nextInt();
					your_inputs.add(diceguess);
					
					if (diceguess == rolled_number)
					{
						System.out.println("Congratulations. You guessed the correct number.");
						System.out.println("Took you " + trials + " attempt(s).");
						attempts.add(trials);
						
						if ((i + 1) == games)
						{
							System.out.println("That is all the games.");
						}
						else
						{
							System.out.println("Get ready for the next game...");
						}
						
						correct = true;
					}
					else
					{
						System.out.println("Sorry! Not the right number. Try again.");
						trials++;
						
						if (diceguess > rolled_number)
						{
							System.out.println("Your number is too big.");
						}
						else if (diceguess < rolled_number)
						{
							System.out.println("Your number is too small.");
						}
					}
				}
			}
		}
		
		// Card Game only
		else if (gamemode == 2)
		{			
			while (valid == false)
			{
				try
				{
					String initial = "";
					
					do
					{
						System.out.print("How many games do you want to play? Please enter a number: ");
						initial = input.next();
						games = Integer.parseInt(initial);
						
						if (games == 0)
						{
							System.out.println("Must be a number greater than zero.");
						}
						else
						{
							valid = true;
						}
					}
					while(initial == "");
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid entry. Must be a number.");
				}
			}
			
			System.out.println("Let the games begin.");
			your_inputs = new ArrayList<Integer>();
			attempts = new ArrayList<Integer>();
			cardplay = new Cards(cardpick);
			
			for (int i = 0; i < games; i++)
			{
				boolean correct = false;
				int trials = 1;
				picked_card = cardplay.Generate();
				
				System.out.println("\nThe CPU has picked out " + cardpick + " card(s). Can you guess the sum of the cards? ");
				
				while (correct == false)
				{
					System.out.print("Please enter a number: ");
					cardguess = input.nextInt();
					your_inputs.add(cardguess);
					
					if (cardguess == picked_card)
					{
						System.out.println("Congratulations. You guessed the correct number.");
						System.out.println("Took you " + trials + " attempt(s).");
						attempts.add(trials);
						
						if ((i + 1) == games)
						{
							System.out.println("That is all the games.");
						}
						else
						{
							System.out.println("Get ready for the next game...");
						}
						
						correct = true;
					}
					else
					{
						System.out.println("Sorry! Not the right number. Try again.");
						trials++;
						
						if (cardguess > picked_card)
						{
							System.out.println("Your number is too big.");
						}
						else if (cardguess < picked_card)
						{
							System.out.println("Your number is too small.");
						}
					}
				}
			}
		}
		
		// Dice and Card Game
		else if (gamemode == 3)
		{
			while (valid == false)
			{
				try
				{
					String initial = "";
					
					do
					{
						System.out.print("How many games do you want to play? Please enter a number: ");
						initial = input.next();
						games = Integer.parseInt(initial);
						
						if (games == 0)
						{
							System.out.println("Must be a number greater than zero.");
						}
						else
						{
							valid = true;
						}
					}
					while(initial == "");
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid entry. Must be a number.");
				}
			}
			
			System.out.println("Let the games begin.");
			your_inputs = new ArrayList<Integer>();
			your_inputs2 = new ArrayList<Integer>();
			attempts = new ArrayList<Integer>();
			diceplay = new Dices(dices);
			cardplay = new Cards(cardpick);
			
			for (int i = 0; i < games; i++)
			{
				boolean correct = false;
				int trials = 1;
				rolled_number = diceplay.Generate();
				picked_card = cardplay.Generate();
				
				System.out.println("\nThe CPU has rolled " + dices + " 6-sided die(s) and picked out " + cardpick + " card(s)."
						+ " Can you correctly guess the dice and card sums? ");
				
				while (correct == false)
				{
					System.out.print("Please enter your dice guess first: ");
					diceguess = input.nextInt();
					your_inputs.add(diceguess);
					
					System.out.print("Now enter your card guess: ");
					cardguess = input.nextInt();
					your_inputs2.add(cardguess);
					
					if ((diceguess == rolled_number) && (cardguess == picked_card))
					{
						System.out.println("Congratulations. You have guessed both of the numbers correctly!");
						System.out.println("Took you " + trials + " attempt(s).");
						attempts.add(trials);
						
						if ((i + 1) == games)
						{
							System.out.println("That is all the games.");
						}
						else
						{
							System.out.println("Get ready for the next game...");
						}
						
						correct = true;
					}
					else if ((diceguess == rolled_number) || (cardguess == picked_card))
					{
						if (diceguess == rolled_number)
						{
							System.out.println("You got the dice guess correct, but not your card guess.");
							
							if (cardguess > picked_card)
							{
								System.out.println("Your card guess is too big.");
							}
							else if (cardguess < picked_card)
							{
								System.out.println("Your card guess is too small.");
							}
						}
						else if (cardguess == picked_card)
						{
							System.out.println("You got the card guess correct, but not your dice guess.");
							
							if (diceguess > rolled_number)
							{
								System.out.println("Your dice guess is too big.");
							}
							else if (diceguess < rolled_number)
							{
								System.out.println("Your dice guess is too small.");
							}
						}
						
						trials++;
					}
					else
					{
						System.out.println("Sorry! None of your responses are correct. Try again.");
						
						if (diceguess > rolled_number)
						{
							if (cardguess > picked_card)
							{
								System.out.println("Your dice guess and your card guess is too big.");
							}
							else if (cardguess < picked_card)
							{
								System.out.println("Your dice guess is too big, but your card guess is too small.");
							}
						}
						else if (diceguess < rolled_number)
						{
							if (cardguess > picked_card)
							{
								System.out.println("Your dice guess is too small, but your card guess is too big.");
							}
							else if (cardguess < picked_card)
							{
								System.out.println("Your dice guess and your card guess is too small.");
							}
						}
						trials++;
					}
				}
			}	
		}
		
		System.out.println("Compiling Game History...");
		System.out.println("\nGAME HISTORY");
		System.out.println("------------");
		
		if (gamemode == 1)
		{
			System.out.println("\nCorrect dice sums generated in the game from first to last:");
			System.out.println(diceplay.History());
			
			System.out.println("\nAttempts it took to find the correct dice sums in each game from first to last:");
			
			for (int i = 1; i <= attempts.size(); i++)
			{
				System.out.print(attempts.get(i - 1) + "  ");
			}
			
			System.out.println("\n\nAll user-inputted numbers in the game from first to last:");
			
			for (int j = 1; j <= your_inputs.size(); j++)
			{
				System.out.print(your_inputs.get(j - 1) + "  ");
			}
			
			System.out.println("\n\nGames played: " + games);
			System.out.println("Dices played: " + dices);
		}
		else if (gamemode == 2)
		{
			System.out.println("\nCorrect card sums generated in the game from first to last:");
			System.out.println(cardplay.History());
			
			System.out.println("\nAttempts it took to find the correct card sums in each game from first to last:");
			
			for (int i = 1; i <= attempts.size(); i++)
			{
				System.out.print(attempts.get(i - 1) + "  ");
			}
			
			System.out.println("\n\nAll user-inputted numbers in the game from first to last:");
			
			for (int j = 1; j <= your_inputs.size(); j++)
			{
				System.out.print(your_inputs.get(j - 1) + "  ");
			}
			
			System.out.println("\n\nGames played: " + games);
			System.out.println("Cards played: " + cardpick);
		}
		else if (gamemode == 3)
		{
			System.out.println("\nCorrect dice sums generated in the game from first to last:");
			System.out.println(diceplay.History());
			
			System.out.println("\nCorrect card sums generated in the game from first to last:");
			System.out.println(cardplay.History());
			
			System.out.println("\nAttempts it took to find the correct dice and card sums in each game from first to last:");
			
			for (int i = 1; i <= attempts.size(); i++)
			{
				System.out.print(attempts.get(i - 1) + "  ");
			}
			
			System.out.println("\n\nAll user-inputted numbers for the dice sum portion from first to last:");
			
			for (int j = 1; j <= your_inputs.size(); j++)
			{
				System.out.print(your_inputs.get(j - 1) + "  ");
			}
			
			System.out.println("\n\nAll user-inputted numbers for the card sum portion from first to last:");
			
			for (int k = 1; k <= your_inputs2.size(); k++)
			{
				System.out.print(your_inputs2.get(k - 1) + "  ");
			}
			
			System.out.println("\n\nGames played: " + games);
			System.out.println("Dices played: " + dices);
			System.out.println("Cards played: " + cardpick);
		}
		
		input.close();
	}
}
