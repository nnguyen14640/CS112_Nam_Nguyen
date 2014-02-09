// Nam Nguyen
// Cmpr 112

// This class inherits the GridlineInterface class to inspect the ArrayList of the
// Tic-Tac-Toe board in accordance to finding markers present on the board.
// When a user enters the correct numbers for columns and rows, this class is called
// to inspect the ArrayList of the Tic-Tac-Toe board to find any markers present on
// that list so markers cannot get replaced.
package finalproject;
public class Availability extends GridlineInterface
{
	// If a particular space according to user input does not contain any marker in
	// that cell, then checkAvailability() returns false and allows the program to
	// place the marker in that cell based on the user input. If there is a marker
	// present in a particular cell, then checkAvailability() returns true and
	// allows the program to realize that a marker exists on the cell from the user
	// input. This in turn will tell the user to enter another location.
	public boolean checkAvailability(int columns, int rows)
	{
		boolean existence = false;
		
		if (columns == 0 && rows == 0)
		{
			if (GridlineInterface.interfacegrid.get(topleft).contains("X")|| GridlineInterface.interfacegrid.get(topleft).contains("O"))
			{
				existence = true; // Top left box
			}
		}
		else if (columns == 0 && rows == 1)
		{
			if (GridlineInterface.interfacegrid.get(midleft).contains("X") || GridlineInterface.interfacegrid.get(midleft).contains("O"))
			{
				existence = true; // Top middle box
			}
		}
		else if (columns == 0 && rows == 2)
		{
			if (GridlineInterface.interfacegrid.get(bottomleft).contains("X") || GridlineInterface.interfacegrid.get(bottomleft).contains("O"))
			{
				existence = true; // Top right box
			}
		}
		else if (columns == 1 && rows == 0)
		{
			if (GridlineInterface.interfacegrid.get(topcenter).contains("X") || GridlineInterface.interfacegrid.get(topcenter).contains("O"))
			{
				existence = true; // Middle left box
			}
		}
		else if (columns == 1 && rows == 1)
		{
			if (GridlineInterface.interfacegrid.get(center).contains("X") || GridlineInterface.interfacegrid.get(center).contains("O"))
			{
				existence = true; // Center box
			}
		}
		else if (columns == 1 && rows == 2)
		{
			if (GridlineInterface.interfacegrid.get(bottomcenter).contains("X") || GridlineInterface.interfacegrid.get(bottomcenter).contains("O"))
			{
				existence = true; // Middle right box
			}
		}
		else if (columns == 2 && rows == 0)
		{
			if (GridlineInterface.interfacegrid.get(topright).contains("X") || GridlineInterface.interfacegrid.get(topright).contains("O"))
			{
				existence = true; // Bottom left box
			}
		}
		else if (columns == 2 && rows == 1)
		{
			if (GridlineInterface.interfacegrid.get(midright).contains("X") || GridlineInterface.interfacegrid.get(midright).contains("O"))
			{
				existence = true; // Bottom middle box
			}
		}
		else if (columns == 2 && rows == 2)
		{
			if (GridlineInterface.interfacegrid.get(bottomright).contains("X") || GridlineInterface.interfacegrid.get(bottomright).contains("O"))
			{
				existence = true; // Bottom right box
			}
		}
		
		return existence;
	}
}


// Good
