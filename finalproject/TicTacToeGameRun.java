// Nam Nguyen
// Cmpr 112

// This is the console version of the Tic-Tac-Toe game.

package finalproject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGameRun 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Random randomizer = new Random();
		ArrayList<Object> gameboardvisuals = new ArrayList<Object>();
		GridlineInterface layout = new GridlineInterface();
		AcceptableWins criteria = new AcceptableWins();
		Availability openspaces = new Availability();
		RowCompletion rowcheck = new RowCompletion();
		Markers gamemarkers = new Markers();
		final int[] firstplayerfirst = {1, 2, 1, 2, 1, 2, 1, 2, 1};
		final int[] secondplayerfirst = {2, 1, 2, 1, 2, 1, 2, 1, 2};
		final String[] cointoss = {"H", "T"};
		String player1marker = null;
		String player2marker = null;
		String verify = null;
		String guess = null;
		String coin = null;
		String priority = null;
		String answer = null;
		String viewhistory = null;
		String gamecontinuation = null;
		boolean gameprogram = true;
		
		System.out.println("Welcome to the Tic-Tac-Toe Game - A classic game suitable for all ages.");
		
		// This program loop controls the entire program and gameplay, therefore ensuring possible
		// repetition of the game if the user decides to start a brand new game.
		do
		{
			int player1wins = 0;
			int player2wins = 0;
			int gameties = 0;
			int games = 0;
			int currentgame = 1;
			int numbertoss = 0;
			boolean valid = false;
			boolean exist = false;
			boolean rowcompletion = false;
			boolean winningpair = false;
			boolean allfull = false;
			boolean settings = false;
			boolean gameplay = true;
			
			System.out.println("Let's set this game up so you can start playing this classic game!");
			
			// This loop contains the settings for setting up the Tic-Tac-Toe game. This involves
			// entering the number of games to play and choosing a game marker. At the end, it will
			// allow the user to verify the choices and allows the user to start over if needed.
			do
			{
				// This loop prompts the user to enter a number of games to play. If the user enters
				// no games, the program will exit. If a negative value is entered, the user will
				// re-prompt to enter a new value. If a non-number value is entered, InputMismatchException
				// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
				// value is entered, the loop will not exit until it does.
				do
				{
					try
					{
						System.out.print("How many games do you want to play? Please enter a number: ");
						games = input.nextInt();
						
						if (games == 0)
						{
							System.out.println("No games will be played. Game will now exit.");
							System.exit(0);
						}
						else if (games < 0)
						{
							System.out.println("Entry invalid. Must enter a positive number.");
						}
						else
						{
							valid = true;
						}
					}
					catch (InputMismatchException e)
					{
						System.out.println("Entry invalid. This input only allows numbers.");
					}
					
					input.nextLine();
				}
				while(games <= 0 && valid == false);
				
				// This loop prompts the user to choose a game marker either X or O. If an invalid
				// entry is entered, it will re-prompt the user to enter either X or O. Once the
				// user chooses a marker, it will will set that marker to that player.
				do
				{
						System.out.print("Choose a marker you want to play as (X or O): ");
						verify = input.next();
						
						if (verify.equals("X") || verify.equals("O"))
						{
							player1marker = gamemarkers.setplayer1marker(verify);
						}
						else
						{
							System.out.println("Invalid entry. Must be X or O.");
						}
				}
				while(!verify.equals("X") && !verify.equals("O"));
				
				// This assigns player 2 to the other marker that player 1 did not choose.
				if(player1marker.equals("X"))
				{
					player2marker = gamemarkers.setplayer2marker();
				}
				else if (player1marker.equals("O"))
				{
					player2marker = gamemarkers.setplayer2marker();
				}
				
				// Summary information printed out
				System.out.println("\nSummary");
				System.out.println("Number of games to play: " + games);
				System.out.println("Player 1 will play as " + player1marker +
						". Player 2 will play as " + player2marker + ".");
				
				// This loop then allows the user to verify that it is correct. If Yes, settings
				// are set and the setting loop ends. If No, setting loop does not end and will loop
				// back to the beginning and allows the user to start over. An invalid response will
				// re-prompt the user.
				do
				{
					System.out.print("Is this correct (Y/N)? ");
					answer = input.next();
					
					if (answer.equals("Y"))
					{
						settings = true;
					}
					else if (answer.equals("N"))
					{
						System.out.println("Let's start over.");
						valid = false;
						games = -1;
					}
					else
					{
						System.out.println("Invalid entry.");
					}
				}
				while(!answer.equals("Y") && !answer.equals("N"));
			}
			while (settings == false);
			
			// This sets the coin toss portion of the game in determining who goes first.
			numbertoss = randomizer.nextInt(2);
			
			if (numbertoss == 0)
			{
				coin = cointoss[0];
			}
			else if (numbertoss == 1)
			{
				coin = cointoss[1];
			}
			
			System.out.println("\nBefore we begin, we need to know who will go first.");
			System.out.println("So let's flip a coin. Will it be heads or tails (H/T)?");
			
			// This loop prompts the user to enter Heads or Tails to determine if player 1 or 2 would
			// go first. If the user answers the coin toss correctly, player 1 will go first. If not,
			// then player 2 goes first. An invalid entry will re-prompt the user.
			do
			{
				System.out.print("Please enter H for heads or T for tails. You only get one chance: ");
				guess = input.next();
				
				if (guess.equals(coin))
				{
					System.out.println("You guessed correctly, so you go first.");
					priority = "1";
				}
				else if (!guess.equals(coin))
				{
					if (guess.equals("H") || guess.equals("T"))
					{
						System.out.println("You guessed wrong, so player 2 goes first.");
						priority = "2";
					}
					else
					{
						System.out.println("Invalid entry. Try again.");
					}
				}
				
			}
			while(!guess.equals("H") && !guess.equals("T"));
			
			System.out.println("Let the games begin!");
			
			// This gameplay loop houses the entire Tic-Tac-Toe game.
			while(gameplay == true)
			{
				System.out.println("\nGame " + currentgame);
				layout.setInterface();
				
				// This statement executes if player 1 went first (when user guesses coin game correctly)
				if(priority.equals("1"))
				{
					// This loop determines player order based on an array of numbers.
					// In this case, this loops according to player 1 being first.
					for (int i = 0; i < firstplayerfirst.length; i++)
					{
						int columnselect = -1;
						int rowselect = -1;
						boolean firstValidOne = false;
						boolean secondValidOne = false;
						boolean firstValidTwo = false;
						boolean secondValidTwo = false;
						
						System.out.println("\n" + layout.toString());
						
						// Moves corresponding to Player 1
						if(i % 2 == 0)
						{
							System.out.println("Player " + firstplayerfirst[i] + ", it is your move.");
							
							// This game loop controls all the actions and plays for Player 1
							do
							{
								// This loop prompts the user to enter a number for a column. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Please enter a number for a column.");
										System.out.print("Hint: 0 for left, 1 for middle, and 2 for right: ");
										columnselect = input.nextInt();
									
										if (columnselect != 0 && columnselect!= 1 && columnselect != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											firstValidOne = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(columnselect != 0 && columnselect != 1 && columnselect != 2 && firstValidOne == false);
								
								// This loop prompts the user to enter a number for a row. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Now please enter a number for a row.");
										System.out.print("Hint: 0 for top, 1 for middle, and 2 for bottom: ");
										rowselect = input.nextInt();
										
										if (rowselect != 0 && rowselect != 1 && rowselect != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											secondValidOne = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(rowselect != 0 && rowselect != 1 && rowselect != 2 && secondValidOne == false);
								
								// This checks the gameboard to see whether the space you enter does not have a marker
								// present at that location. If it does, it will ask the user to enter new numbers
								// for rows and columns. Otherwise if it returns false, it will set the game piece
								// to that particular location.
								exist = openspaces.checkAvailability(columnselect, rowselect);
								
								if (exist == true)
								{
									System.out.println("The location you entered has a marker occupied"
											+ " there. Please enter another location.");
									firstValidOne = false;
									secondValidOne = false;
									columnselect = -1;
									rowselect = -1;
								}
								else
								{
									layout.setGamepieces(columnselect, rowselect, player1marker);
								}
							}
							while (exist == true);
							
							// This checks the cells based on whether or not there are rows of vertical, horizontal
							// or diagonal of markers present in that sequence. If there are such completed rows
							// it will then check the cells again for markers that are the same type in a row of
							// vertical, horizontal or diagonal sequence. If there is such type, then there is a
							// winning pair so the game ends and player 1 wins. Board data is gathered and stored
							// into a list, the Tic-Tac-Toe board then clears its contents and the current game ends.
							rowcompletion = rowcheck.checkRowCompletion();
							
							if (rowcompletion == true)
							{
								winningpair = criteria.winningPairs();
								
								if (winningpair == true)
								{
									System.out.println("A winner has been decided. Player " + firstplayerfirst[i] + " wins!");
									System.out.println("\n" + layout.toString());
									player1wins++;
									gameboardvisuals.add(layout.toString());
									layout.boardClear();
									break;
								}
							}
							
							// If there are no winning pairs or completed rows, it will then check to see if the
							// board is full of markers. If so, it will most likely declare the game as a tie. Board
							// data is gathered and stored into a list, the Tic-Tac-Toe board then clears its contents
							// and the current game ends.
							allfull = layout.boardFull();
							
							if (allfull == true)
							{
								System.out.println("There are no available spaces remaining on the board.");
								System.out.println("This game is a tie. There are no valid wins in this game.");
								System.out.println("\n" + layout.toString());
								gameties++;
								gameboardvisuals.add(layout.toString());
								layout.boardClear();
								break;
							}
						}
						// Moves corresponding to player 2
						else
						{
							System.out.println("Player " + firstplayerfirst[i] + ", it is your move.");
							
							// This game loop controls all the actions and plays for Player 2
							do
							{
								// This loop prompts the user to enter a number for a column. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Please enter a number for a column.");
										System.out.print("Hint: 0 for left, 1 for middle, and 2 for right: ");
										columnselect = input.nextInt();
									
										if (columnselect != 0 && columnselect!= 1 && columnselect != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											firstValidTwo = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(columnselect != 0 && columnselect != 1 && columnselect != 2 && firstValidTwo == false);
								
								// This loop prompts the user to enter a number for a row. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Now please enter a number for a row.");
										System.out.print("Hint: 0 for top, 1 for middle, and 2 for bottom: ");
										rowselect = input.nextInt();
										
										if (rowselect != 0 && rowselect != 1 && rowselect != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											secondValidTwo = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(rowselect != 0 && rowselect != 1 && rowselect != 2 && secondValidTwo == false);
								
								// This checks the gameboard to see whether the space you enter does not have a marker
								// present at that location. If it does, it will ask the user to enter new numbers
								// for rows and columns. Otherwise if it returns false, it will set the game piece
								// to that particular location.
								exist = openspaces.checkAvailability(columnselect, rowselect);
								
								if (exist == true)
								{
									System.out.println("The location you entered has a marker occupied"
											+ " there. Please enter another location.");
									firstValidTwo = false;
									secondValidTwo = false;
									columnselect = -1;
									rowselect = -1;
								}
								else
								{
									layout.setGamepieces(columnselect, rowselect, player2marker);
								}
							}
							while (exist == true);
							
							// This checks the cells based on whether or not there are rows of vertical, horizontal
							// or diagonal of markers present in that sequence. If there are such completed rows
							// it will then check the cells again for markers that are the same type in a row of
							// vertical, horizontal or diagonal sequence. If there is such type, then there is a
							// winning pair so the game ends and player 2 wins. Board data is gathered and stored
							// into a list, the Tic-Tac-Toe board then clears its contents and the current game ends.
							rowcompletion = rowcheck.checkRowCompletion();
							
							if (rowcompletion == true)
							{
								winningpair = criteria.winningPairs();
								
								if (winningpair == true)
								{
									System.out.println("A winner has been decided. Player " + firstplayerfirst[i] + " wins!");
									System.out.println("\n" + layout.toString());
									player2wins++;
									gameboardvisuals.add(layout.toString());
									layout.boardClear();
									break;
								}
							}
							
							// If there are no winning pairs or completed rows, it will then check to see if the
							// board is full of markers. If so, it will most likely declare the game as a tie. Board
							// data is gathered and stored into a list, the Tic-Tac-Toe board then clears its contents
							// and the current game ends.
							allfull = layout.boardFull();
							
							if (allfull == true)
							{
								System.out.println("There are no available spaces remaining on the board.");
								System.out.println("This game is a tie. There are no valid wins in this game.");
								System.out.println("\n" + layout.toString());
								gameties++;
								gameboardvisuals.add(layout.toString());
								layout.boardClear();
								break;
							}
						}
					}
				}
				
				// This statement executes when player 2 goes first (when user guesses coin game incorrectly)
				if (priority.equals("2"))
				{
					// This loop determines player order based on an array of numbers.
					// In this case, this loops according to player 2 being first.
					for (int j = 0; j < secondplayerfirst.length; j++)
					{
						int selectcolumn = -1;
						int selectrow = -1;
						boolean validFirstOne = false;
						boolean validSecondOne = false;
						boolean validFirstTwo = false;
						boolean validSecondTwo = false;
						
						System.out.println("\n" + layout.toString());
						
						// Moves corresponding to player 2
						if (j % 2 == 0)
						{
							System.out.println("Player " + secondplayerfirst[j] + ", it is your move.");
							
							// This game loop controls all the actions and plays for Player 2
							do
							{
								// This loop prompts the user to enter a number for a column. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Please enter a number for a column.");
										System.out.print("Hint: 0 for left, 1 for middle, and 2 for right: ");
										selectcolumn = input.nextInt();
									
										if (selectcolumn != 0 && selectcolumn!= 1 && selectcolumn != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											validFirstOne = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(selectcolumn != 0 && selectcolumn != 1 && selectcolumn != 2 && validFirstOne == false);
								
								// This loop prompts the user to enter a number for a row. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Now please enter a number for a row.");
										System.out.print("Hint: 0 for top, 1 for middle, and 2 for bottom: ");
										selectrow = input.nextInt();
										
										if (selectrow != 0 && selectrow != 1 && selectrow != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											validSecondOne = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(selectrow != 0 && selectrow != 1 && selectrow != 2 && validSecondOne == false);
								
								// This checks the gameboard to see whether the space you enter does not have a marker
								// present at that location. If it does, it will ask the user to enter new numbers
								// for rows and columns. Otherwise if it returns false, it will set the game piece
								// to that particular location.
								exist = openspaces.checkAvailability(selectcolumn, selectrow);
								
								if (exist == true)
								{
									System.out.println("The location you entered has a marker occupied"
											+ " there. Please enter another location.");
									validFirstOne = false;
									validSecondOne = false;
									selectcolumn = -1;
									selectrow = -1;
								}
								else
								{
									layout.setGamepieces(selectcolumn, selectrow, player2marker);
								}
							}
							while (exist == true);
							
							// This checks the cells based on whether or not there are rows of vertical, horizontal
							// or diagonal of markers present in that sequence. If there are such completed rows
							// it will then check the cells again for markers that are the same type in a row of
							// vertical, horizontal or diagonal sequence. If there is such type, then there is a
							// winning pair so the game ends and player 2 wins. Board data is gathered and stored
							// into a list, the Tic-Tac-Toe board then clears its contents and the current game ends.
							rowcompletion = rowcheck.checkRowCompletion();
							
							if (rowcompletion == true)
							{
								winningpair = criteria.winningPairs();
								
								if (winningpair == true)
								{
									System.out.println("A winner has been decided. Player " + secondplayerfirst[j] + " wins!");
									System.out.println("\n" + layout.toString());
									player2wins++;
									gameboardvisuals.add(layout.toString());
									layout.boardClear();
									break;
								}
							}
							
							// If there are no winning pairs or completed rows, it will then check to see if the
							// board is full of markers. If so, it will most likely declare the game as a tie. Board
							// data is gathered and stored into a list, the Tic-Tac-Toe board then clears its contents
							// and the current game ends.
							allfull = layout.boardFull();
							
							if (allfull == true)
							{
								System.out.println("There are no available spaces remaining on the board.");
								System.out.println("This game is a tie. There are no valid wins in this game.");
								System.out.println("\n" + layout.toString());
								gameties++;
								gameboardvisuals.add(layout.toString());
								layout.boardClear();
								break;
							}
						}
						// Moves corresponding to player 1
						else
						{
							System.out.println("Player " + secondplayerfirst[j] + ", it is your move.");
							
							// This game loop controls all the actions and plays for Player 1
							do
							{
								// This loop prompts the user to enter a number for a column. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Please enter a number for a column.");
										System.out.print("Hint: 0 for left, 1 for middle, and 2 for right: ");
										selectcolumn = input.nextInt();
									
										if (selectcolumn != 0 && selectcolumn != 1 && selectcolumn != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											validFirstTwo = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(selectcolumn != 0 && selectcolumn != 1 && selectcolumn != 2 && validFirstTwo == false);
								
								// This loop prompts the user to enter a number for a row. If the user enters
								// a value that is not 0, 1, or 2, it will re-prompt the user to enter a valid
								// value. If a non-number value is entered, InputMismatchException
								// will be thrown and caught, allowing a re-prompt to enter a new value. Until a valid
								// value is entered, the loop will not exit until it does.
								do
								{
									try
									{
										System.out.println("Now please enter a number for a row.");
										System.out.print("Hint: 0 for top, 1 for middle, and 2 for bottom: ");
										selectrow = input.nextInt();
										
										if (selectrow != 0 && selectrow != 1 && selectrow != 2)
										{
											System.out.println("Invalid entry. Please try again.");
										}
										else
										{
											validSecondTwo = true;
										}
									}
									catch (InputMismatchException e)
									{
										System.out.println("Invalid entry. This input only allows numbers.");
									}
									
									input.nextLine();
								}
								while(selectrow != 0 && selectrow != 1 && selectrow != 2 && validSecondTwo == false);
								
								// This checks the gameboard to see whether the space you enter does not have a marker
								// present at that location. If it does, it will ask the user to enter new numbers
								// for rows and columns. Otherwise if it returns false, it will set the game piece
								// to that particular location.
								exist = openspaces.checkAvailability(selectcolumn, selectrow);
								
								if (exist == true)
								{
									System.out.println("The location you entered has a marker occupied"
											+ " there. Please enter another location.");
									validFirstTwo = false;
									validSecondTwo = false;
									selectcolumn = -1;
									selectrow = -1;
								}
								else
								{
									layout.setGamepieces(selectcolumn, selectrow, player1marker);
								}
							}
							while (exist == true);
							
							// This checks the cells based on whether or not there are rows of vertical, horizontal
							// or diagonal of markers present in that sequence. If there are such completed rows
							// it will then check the cells again for markers that are the same type in a row of
							// vertical, horizontal or diagonal sequence. If there is such type, then there is a
							// winning pair so the game ends and player 2 wins. Board data is gathered and stored
							// into a list, the Tic-Tac-Toe board then clears its contents and the current game ends.
							rowcompletion = rowcheck.checkRowCompletion();
							
							if (rowcompletion == true)
							{
								winningpair = criteria.winningPairs();
								
								if (winningpair == true)
								{
									System.out.println("A winner has been decided. Player " + secondplayerfirst[j] + " wins!");
									System.out.println("\n" + layout.toString());
									player1wins++;
									gameboardvisuals.add(layout.toString());
									layout.boardClear();
									break;
								}
							}
							
							// If there are no winning pairs or completed rows, it will then check to see if the
							// board is full of markers. If so, it will most likely declare the game as a tie. Board
							// data is gathered and stored into a list, the Tic-Tac-Toe board then clears its contents
							// and the current game ends.
							allfull = layout.boardFull();
							
							if (allfull == true)
							{
								System.out.println("There are no available spaces remaining on the board.");
								System.out.println("This game is a tie. There are no valid wins in this game.");
								System.out.println("\n" + layout.toString());
								gameties++;
								gameboardvisuals.add(layout.toString());
								layout.boardClear();
								break;
							}
						}
					}
				}
				currentgame++;
				
				// Current game details the current game played while games contains the total number of games to play
				// After every game completion whether a tie or a win, current game increments by one. If it does not
				// exceed total games, then it will prepare the next game. Otherwise it will prompt that all games
				// have been played and it will end the gameplay loop.
				if (currentgame > games)
				{
					gameplay = false;
					System.out.println("That is all the games.");
				}
				else
				{
					System.out.println("Get ready for the next game...");
				}
			}
			
			// This loop asks the user if he or she wants to view the game history for all the games played in this
			// session. If Yes, it will print out the game board visualization starting from the first game to
			// the very last one. It will then print out statistical information, including games played, player 1
			// and 2 winnings, game ties and knowing who got the most wins. Entering No skips the history
			// compilation and an invalid entry re-prompts the user.
			do
			{
				System.out.print("Do you want to view your game history? (Y/N) ");
				viewhistory = input.next();
				
				if (viewhistory.equals("Y"))
				{
					System.out.println("Compiling records...");
					System.out.println("\nGame board visualizations ordered from the first to last game played: ");
					
					for (int k = 0; k < gameboardvisuals.size(); k++)
					{
						System.out.println(gameboardvisuals.get(k) + "   ");
					}
					System.out.println("\n\nRecords");
					System.out.println("-------");
					
					System.out.println("Games played: " + games);
					System.out.println("Player 1 Wins: " + player1wins);
					System.out.println("Player 2 Wins: " + player2wins);
					System.out.println("Ties: " + gameties);
					
					if (player1wins > player2wins)
					{
						System.out.println("Player 1 Wins the most games with " + player1wins + ".");
					}
					else if (player1wins < player2wins)
					{
						System.out.println("Player 2 Wins the most games with " + player2wins + ".");
					}
					else
					{
						System.out.println("No one has the most wins. Both have a total of " + player1wins + ".");
					}
				}
				else if (viewhistory.equals("N"))
				{
					System.out.println("You declined to view records.");
				}
				else
				{
					System.out.println("Invalid entry.");
				}
			}
			while (!viewhistory.equals("Y") && !viewhistory.equals("N"));
			
			// This loop asks the user if he or she would like to start a new game session and play the Tic-Tac-Toe
			// game again. If Yes, the game will reset by clearing the game board visuals and all statistics for
			// this game session. If No, the game will say farewell to the user and ends the game program loop,
			// therefore exiting the program. An invalid entry will re-prompt the user.
			do
			{
				System.out.print("Would you like to start a new round of games? (Y/N) ");
				gamecontinuation = input.next();
				
				if (gamecontinuation.equals("Y"))
				{
					System.out.println("Thank you. We will now restart this game..." + "\n\n");
					gameboardvisuals.clear();
				}
				else if (gamecontinuation.equals("N"))
				{
					System.out.println("Thank you for playing. We hope you had fun!");
					gameprogram = false;
				}
				else
				{
					System.out.println("Invalid entry.");
				}
			}
			while (!gamecontinuation.equals("Y") && !gamecontinuation.equals("N"));
		}
		while(gameprogram == true);
		
		input.close();
	}
}