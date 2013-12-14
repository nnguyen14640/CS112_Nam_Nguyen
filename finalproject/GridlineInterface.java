// Nam Nguyen
// Cmpr 112

// This class contains the necessary components to construct and set the 3 x 3
// Tic-Tac-Toe board. It also includes functions to set game markers to its
// respective locations on the gameboard, checking if the gameboard is full of
// game markers and to clear all the markers on the gameboard. The toString()
// method contains information in printing the gameboard and upon every update.
package finalproject;
import java.util.ArrayList;

public class GridlineInterface 
{
	// Fields for this class. Note that the ArrayList is static to allow implicit
	// access for other classes such as AcceptableWins, Availability, and
	// RowCompletion classes. The fields are also protected to provide limited
	// access to the values of the variables and to gather the necessary info
	// based on the index location of the ArrayList.
	protected static ArrayList<String> interfacegrid;
	protected int topleft;
	protected int topcenter;
	protected int topright;
	protected int midleft;
	protected int center;
	protected int midright;
	protected int bottomleft;
	protected int bottomcenter;
	protected int bottomright;
	
	// This constructs a new ArrayList of Strings and assigns the protected variables
	// as numbers in accordance to the different index numbers from the ArrayList.
	public GridlineInterface()
	{
		interfacegrid = new ArrayList<String>();
		topleft = 0;
		topcenter = 1;
		topright = 2;
		midleft = 3;
		center = 4;
		midright = 5;
		bottomleft = 6;
		bottomcenter = 7;
		bottomright = 8;
	}
	
	// This sets the Tic-Tac-Toe board ArrayList to contain empty strings when the
	// gameboard is first initialized.
	public void setInterface()
	{
		String reserve = " ";
		for (int j = 0; j < 9; j++)
		{
			interfacegrid.add(j, reserve);
		}
	}
	
	// This sets the gamepieces to a paricular cell of the gameboard in accordance
	// to the user input of the column and row. It also adds the game marker in
	// accordance to the current turn.
	public void setGamepieces(int column, int row, String gamepiece)
	{
		if (column == 0 && row == 0)
		{
			interfacegrid.set(topleft, gamepiece);
		}
		else if (column == 0 && row == 1)
		{
			interfacegrid.set(midleft, gamepiece);
		}
		else if (column == 0 && row == 2)
		{
			interfacegrid.set(bottomleft, gamepiece);
		}
		else if (column == 1 && row == 0)
		{
			interfacegrid.set(topcenter, gamepiece);
		}
		else if (column == 1 && row == 1)
		{
			interfacegrid.set(center, gamepiece);
		}
		else if (column == 1 && row == 2)
		{
			interfacegrid.set(bottomcenter, gamepiece);
		}
		else if (column == 2 && row == 0)
		{
			interfacegrid.set(topright, gamepiece);
		}
		else if (column == 2 && row == 1)
		{
			interfacegrid.set(midright, gamepiece);
		}
		else if (column == 2 && row == 2)
		{
			interfacegrid.set(bottomright, gamepiece);
		}
	}
	
	// This checks to see if the Tic-Tac-Toe gameboard contains markers in 
	// every cell. When it does boardFull() returns true and informs that there
	// is no more gamepieces to place. As a result, the game usually ends in a tie.
	// If there are less than 9 cells occupied with markers, boardFull() returns
	// false and the game continues.
	public boolean boardFull()
	{
		boolean full = false;
		int tally = 0;
		
		for (int j = 0; j < interfacegrid.size(); j++)
		{
			if (interfacegrid.get(j).contains("X") || interfacegrid.get(j).contains("O"))
			{
				tally++;
			}
		}
		
		if (tally == 9)
		{
			full = true;
		}
		
		return full;
	}
	
	// Upon a particular game ending in tie or a win, this method basically
	// clears all the markers in the Tic-Tac-Toe gameboard.
	public void boardClear()
	{
		interfacegrid.clear();
	}
	
	// This method prints out the Tic-Tac-Toe gameboard in accordance to the
	// 3 x 3 layout with brackets as the cell boxes. This method also updates
	// and returns the gameboard in this format to include any markers present.
	@Override
	public String toString()
	{
		String layout = "";
		
		for (int k = 0; k < interfacegrid.size(); k++)
		{
			layout += "[ " + interfacegrid.get(k) + " ]";
			
			if (k == 2 || k == 5 || k == 8)
			{
				layout = layout + "\n";
			}
		}
		
		return layout;
	}
}

// Good
