// Nam Nguyen
// Cmpr 112

// This class inherits the GridlineInterface class to inspect the ArrayList of the
// Tic-Tac-Toe board in accordance to finding complete rows in a horizontal, vertical
// or diagonal fashion. After a marker is successfully placed in a cell, this class
// is called to check for markers present in a horizontal, vertical or diagonal
// fashion in any row or column. This class is important to know whether or not that
// these row completions could possibly yield a winning to a specific player, which
// would then invoke on the AcceptableWins class.
package finalproject;
public class RowCompletion extends GridlineInterface
{	
	// After a marker is successfully placed in a cell, this class checks each cell in
	// the Tic-Tac-Toe board ArrayList for markers occupied. When a particular cell has
	// a marker occupied, it would then check to see if a cell adjacent to that occupied
	// cell also contains a marker. If one of the adjacent markers also have a marker,
	// then it checks the last cell at the far end of the cell first inspected, (For
	// example, if a the top left and the top middle cells of the Tic-Tac-Toe board has a
	// marker present in those cells, then it will check the top right cell if it has a
	// marker as well.) otherwise it will skip and look at other adjacent cells. When a
	// particular row, either horizontal, vertical or diagonal all contain markers, then
	// checkRowCompletion() returns true and informs the program that it is ready to check
	// the cell again to look for possible wins acceptable in the AcceptableWins class. If
	// there are not enough cells containing markers to make a row in a vertical,
	// horizontal or diagonal fashion, checkRowCompletion() returns false and informs the
	// program that there is no completed rows, therefore the game continues.
	public boolean checkRowCompletion()
	{	
		boolean threerowclose = false;			
		
		if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
		{
			if (interfacegrid.get(topcenter).contains("X") || interfacegrid.get(topcenter).contains("O"))
			{
				if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
				{
					threerowclose = true; // Top row horizontal
				}
			}
			else if (interfacegrid.get(midleft).contains("X") || interfacegrid.get(midleft).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
				{
					threerowclose = true; // Left row vertical
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
				{
					threerowclose = true; // Left diagonal
				}
			}
		}
		
		if (interfacegrid.get(topcenter).contains("X") || interfacegrid.get(topcenter).contains("O"))
		{
			if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
			{
				if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
				{
					threerowclose = true; // Top row horizontal
				}
			}
			else if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
				{
					threerowclose = true; // Top row horizontal
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(bottomcenter).contains("X") || interfacegrid.get(bottomcenter).contains("O"))
				{
					threerowclose = true; // Middle row vertical
				}
			}
		}
		
		if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
		{
			if (interfacegrid.get(topcenter).contains("X") || interfacegrid.get(topcenter).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
				{
					threerowclose = true; // Top row horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("X") || interfacegrid.get(midright).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
				{
					threerowclose = true; // Right row vertical
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
				{
					threerowclose = true; // Right diagonal
				}
			}
		}
		
		if (interfacegrid.get(midleft).contains("X") || interfacegrid.get(midleft).contains("O"))
		{
			if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
				{
					threerowclose = true; // Left row vertical
				}
			}
			else if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
				{
					threerowclose = true; // Left row vertical
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(midright).contains("X") || interfacegrid.get(midright).contains("O"))
				{
					threerowclose = true; // Middle row horizontal
				}
			}
		}
		
		if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
		{
			if (interfacegrid.get(topcenter).contains("X") || interfacegrid.get(topcenter).contains("O"))
			{
				if (interfacegrid.get(bottomcenter).contains("X") || interfacegrid.get(bottomcenter).contains("O"))
				{
					threerowclose = true; // Middle row vertical
				}
			}
			else if (interfacegrid.get(midleft).contains("X") || interfacegrid.get(midleft).contains("O"))
			{
				if (interfacegrid.get(midright).contains("X") || interfacegrid.get(midright).contains("O"))
				{
					threerowclose = true; // Middle row horizontal
				}
			}
			else if (interfacegrid.get(bottomcenter).contains("X") || interfacegrid.get(bottomcenter).contains("O"))
			{
				if (interfacegrid.get(topcenter).contains("X") || interfacegrid.get(topcenter).contains("O"))
				{
					threerowclose = true; // Middle row vertical
				}
			}
			else if (interfacegrid.get(midright).contains("X") || interfacegrid.get(midright).contains("O"))
			{
				if (interfacegrid.get(midleft).contains("X") || interfacegrid.get(midleft).contains("O"))
				{
					threerowclose = true; // Middle row horizontal
				}
			}
			else if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
				{
					threerowclose = true; // Left diagonal
				}
			}
			else if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
				{
					threerowclose = true; // Right diagonal
				}
			}
			else if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
			{
				if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
				{
					threerowclose = true; // Right diagonal
				}
			}
			else if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
				{
					threerowclose = true; // Left diagonal
				}
			}
		}
		
		if (interfacegrid.get(midright).contains("X") || interfacegrid.get(midright).contains("O"))
		{
			if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
				{
					threerowclose = true; // Right row vertical
				}
			}
			else if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
			{
				if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
				{
					threerowclose = true; // Right row vertical
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(midleft).contains("X") || interfacegrid.get(midleft).contains("O"))
				{
					threerowclose = true; // Middle row horizontal
				}
			}
		}
		
		if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
		{
			if (interfacegrid.get(midleft).contains("X") || interfacegrid.get(midleft).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
				{
					threerowclose = true; // Left row vertical
				}
			}
			else if (interfacegrid.get(bottomcenter).contains("X") || interfacegrid.get(bottomcenter).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
				{
					threerowclose = true; // Bottom row horizontal
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
				{
					threerowclose = true; // Right diagonal
				}
			}
		}
		
		if (interfacegrid.get(bottomcenter).contains("X") || interfacegrid.get(bottomcenter).contains("O"))
		{
			if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
			{
				if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
				{
					threerowclose = true; // Bottom row horizontal
				}
			}
			else if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
				{
					threerowclose = true; // Bottom row horizontal
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(topcenter).contains("X") || interfacegrid.get(topcenter).contains("O"))
				{
					threerowclose = true; // Middle row vertical
				}
			}
		}
		
		if (interfacegrid.get(bottomright).contains("X") || interfacegrid.get(bottomright).contains("O"))
		{
			if (interfacegrid.get(bottomcenter).contains("X") || interfacegrid.get(bottomcenter).contains("O"))
			{
				if (interfacegrid.get(bottomleft).contains("X") || interfacegrid.get(bottomleft).contains("O"))
				{
					threerowclose = true; // Bottom row horizontal
				}
			}
			else if (interfacegrid.get(midright).contains("X") || interfacegrid.get(midright).contains("O"))
			{
				if (interfacegrid.get(topright).contains("X") || interfacegrid.get(topright).contains("O"))
				{
					threerowclose = true; // Right row vertical
				}
			}
			else if (interfacegrid.get(center).contains("X") || interfacegrid.get(center).contains("O"))
			{
				if (interfacegrid.get(topleft).contains("X") || interfacegrid.get(topleft).contains("O"))
				{
					threerowclose = true; // Left diagonal
				}
			}
		}
		
		return threerowclose;
	}
}
