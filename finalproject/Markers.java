// Nam Nguyen
// Cmpr 112

package finalproject;
// This class assigns game markers of either X or O to player 1 and 2.
public class Markers 
{
	private final String[] markers = {"X", "O"};
	private String player1marker;
	private String player2marker;
	
	// This sets the game marker for player 1
	public String setplayer1marker(String gamepiece)
	{
		player1marker = gamepiece;
		return player1marker;
	}
	
	// This sets the game marker for player 2
	public String setplayer2marker()
	{
		if (player1marker.equals("X"))
		{
			player2marker = markers[1];
		}
		else
		{
			player2marker = markers[0];
		}
		
		return player2marker;
	}
}

// Not sure why this is necessary
