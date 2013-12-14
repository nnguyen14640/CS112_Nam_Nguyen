// Nam Nguyen
// Cmpr 112

// This class inherits the GridlineInterface class to inspect the ArrayList of the
// Tic-Tac-Toe board in accordance to finding game markers.
// This class after checking for row completion in the RowCompletion class
// this allows it to check each of the cells of the Tic-Tac-Toe ArrayList to
// find any possible winnings to see if there is a winner or not.
package finalproject;
public class AcceptableWins extends GridlineInterface
{
	// If there is no winning pair, winningpairs() returns false and concludes that
	// there is no wins so far and the game continues. If there is a winning pair
	// winningpairs() returns true and concludes there is a winner. This will end
	// the current game and declare the winner.
	public boolean winningPairs()
	{
		boolean winningpair = false;
		
		// For X's only
		if (interfacegrid.get(topleft).contains("X"))
		{
			if (interfacegrid.get(topcenter).contains("X"))
			{
				if (interfacegrid.get(topright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(midleft).contains("X"))
			{
				if (interfacegrid.get(bottomleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on left vertical
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(bottomright).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper left corner
				}
			}
		}
		
		if (interfacegrid.get(topcenter).contains("X"))
		{
			if (interfacegrid.get(topleft).contains("X"))
			{
				if (interfacegrid.get(topright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(topright).contains("X"))
			{
				if (interfacegrid.get(topleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(bottomcenter).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center vertical
				}
			}
		}
		
		if (interfacegrid.get(topright).contains("X"))
		{
			if (interfacegrid.get(topcenter).contains("X"))
			{
				if (interfacegrid.get(topleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("X"))
			{
				if (interfacegrid.get(bottomright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on right vertical
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(bottomleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper right corner
				}
			}
		}
		
		if (interfacegrid.get(midleft).contains("X"))
		{
			if (interfacegrid.get(topleft).contains("X"))
			{
				if (interfacegrid.get(bottomleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on left vertical
				}
			}
			else if (interfacegrid.get(bottomleft).contains("X"))
			{
				if (interfacegrid.get(topleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on left vertical
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(midright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center horizontal
				}
			}
		}
		
		if (interfacegrid.get(center).contains("X"))
		{
			if (interfacegrid.get(topleft).contains("X"))
			{
				if (interfacegrid.get(bottomright).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper left corner
				}
			}
			else if (interfacegrid.get(topcenter).contains("X"))
			{
				if (interfacegrid.get(bottomcenter).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center vertical
				}
			}
			else if (interfacegrid.get(topright).contains("X"))
			{
				if (interfacegrid.get(bottomleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper right corner
				}
			}
			else if (interfacegrid.get(midleft).contains("X"))
			{
				if (interfacegrid.get(midright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("X"))
			{
				if (interfacegrid.get(midleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center horizontal
				}
			}
			else if (interfacegrid.get(bottomleft).contains("X"))
			{
				if (interfacegrid.get(topright).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper right corner
				}
			}
			else if (interfacegrid.get(bottomcenter).contains("X"))
			{
				if (interfacegrid.get(topcenter).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center vertical
				}
			}
			else if (interfacegrid.get(bottomright).contains("X"))
			{
				if (interfacegrid.get(topleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper left corner
				}
			}
		}
		
		if (interfacegrid.get(midright).contains("X"))
		{
			if (interfacegrid.get(topright).contains("X"))
			{
				if (interfacegrid.get(bottomright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on right vertical
				}
			}
			else if (interfacegrid.get(bottomright).contains("X"))
			{
				if (interfacegrid.get(topright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on right vertical
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(midleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center horizontal
				}
			}
		}
		
		if (interfacegrid.get(bottomleft).contains("X"))
		{
			if (interfacegrid.get(midleft).contains("X"))
			{
				if (interfacegrid.get(topleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on left vertical
				}
			}
			else if (interfacegrid.get(bottomcenter).contains("X"))
			{
				if (interfacegrid.get(bottomright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(topright).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper right corner
				}
			}
		}
		
		if (interfacegrid.get(bottomcenter).contains("X"))
		{
			if (interfacegrid.get(bottomleft).contains("X"))
			{
				if (interfacegrid.get(bottomright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(bottomright).contains("X"))
			{
				if (interfacegrid.get(bottomleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(topcenter).contains("X"))
				{
					winningpair = true; // 3 X's in a row on center vertical
				}
			}
		}
		
		if (interfacegrid.get(bottomright).contains("X"))
		{
			if (interfacegrid.get(bottomcenter).contains("X"))
			{
				if (interfacegrid.get(bottomleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("X"))
			{
				if (interfacegrid.get(topright).contains("X"))
				{
					winningpair = true; // 3 X's in a row on right vertical
				}
			}
			else if (interfacegrid.get(center).contains("X"))
			{
				if (interfacegrid.get(topleft).contains("X"))
				{
					winningpair = true; // 3 X's in a row diagonally on upper left corner
				}
			}
		}
		
	// For O's only
		if (interfacegrid.get(topleft).contains("O"))
		{
			if (interfacegrid.get(topcenter).contains("O"))
			{
				if (interfacegrid.get(topright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(midleft).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on left vertical
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper left corner
				}
			}
		}
		
		if (interfacegrid.get(topcenter).contains("O"))
		{
			if (interfacegrid.get(topleft).contains("O"))
			{
				if (interfacegrid.get(topright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(topright).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(bottomcenter).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center vertical
				}
			}
		}
		
		if (interfacegrid.get(topright).contains("O"))
		{
			if (interfacegrid.get(topcenter).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on top horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on right vertical
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper right corner
				}
			}
		}
		
		if (interfacegrid.get(midleft).contains("O"))
		{
			if (interfacegrid.get(topleft).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on left vertical
				}
			}
			else if (interfacegrid.get(bottomleft).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on left vertical
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(midright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center horizontal
				}
			}
		}
		
		if (interfacegrid.get(center).contains("O"))
		{
			if (interfacegrid.get(topleft).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper left corner
				}
			}
			else if (interfacegrid.get(topcenter).contains("O"))
			{
				if (interfacegrid.get(bottomcenter).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center vertical
				}
			}
			else if (interfacegrid.get(topright).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper right corner
				}
			}
			else if (interfacegrid.get(midleft).contains("O"))
			{
				if (interfacegrid.get(midright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("O"))
			{
				if (interfacegrid.get(midleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center horizontal
				}
			}
			else if (interfacegrid.get(bottomleft).contains("O"))
			{
				if (interfacegrid.get(topright).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper right corner
				}
			}
			else if (interfacegrid.get(bottomcenter).contains("O"))
			{
				if (interfacegrid.get(topcenter).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center vertical
				}
			}
			else if (interfacegrid.get(bottomright).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper left corner
				}
			}
		}
		
		if (interfacegrid.get(midright).contains("O"))
		{
			if (interfacegrid.get(topright).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on right vertical
				}
			}
			else if (interfacegrid.get(bottomright).contains("O"))
			{
				if (interfacegrid.get(topright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on right vertical
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(midleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center horizontal
				}
			}
		}
		
		if (interfacegrid.get(bottomleft).contains("O"))
		{
			if (interfacegrid.get(midleft).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on left vertical
				}
			}
			else if (interfacegrid.get(bottomcenter).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(topright).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper right corner
				}
			}
		}
		
		if (interfacegrid.get(bottomcenter).contains("O"))
		{
			if (interfacegrid.get(bottomleft).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(bottomright).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(topcenter).contains("O"))
				{
					winningpair = true; // 3 O's in a row on center vertical
				}
			}
		}
		
		if (interfacegrid.get(bottomright).contains("O"))
		{
			if (interfacegrid.get(bottomcenter).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row on bottom horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("O"))
			{
				if (interfacegrid.get(topright).contains("O"))
				{
					winningpair = true; // 3 O's in a row on right vertical
				}
			}
			else if (interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("O"))
				{
					winningpair = true; // 3 O's in a row diagonally on upper left corner
				}
			}
		}
		
		return winningpair;
	}
}