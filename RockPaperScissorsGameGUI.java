// Nam Nguyen
// Cmpr 112

import java.util.Random;
import javax.swing.JOptionPane;

public class RockPaperScissorsGameGUI 
{
	public static void main(String[] args)
	{
		Random randomizer = new Random();
		String cpu_hand = null;
		String your_hand = "";
		int setting;
		boolean response = false;
		String end_result = null;
		
		setting = randomizer.nextInt(3) + 1;
		
		if (setting == 1)
		{
			cpu_hand = "ROCK";
		}
		else if (setting == 2)
		{
			cpu_hand = "PAPER";
		}
		else if (setting == 3)
		{
			cpu_hand = "SCISSORS";
		}
		
		do
		{
			your_hand = JOptionPane.showInputDialog("Please choose a hand (ROCK, PAPER, or SCISSORS) in all-caps.");
			
			if (your_hand == null)
			{
				System.exit(0);
			}
			else if (your_hand.equals("ROCK") || your_hand.equals("PAPER") || your_hand.equals("SCISSORS"))
			{
				response = true;
			}
			else if (your_hand.equals(""))
			{
				JOptionPane.showMessageDialog(null, "The entry is blank. Please try again.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, your_hand + " is an invalid entry. Please try again.");
			}
		}
		while (response == false);
		
		if (response == true)
		{
			if (your_hand.equals("ROCK"))
			{
				if (cpu_hand.equals("ROCK"))
				{
					end_result = "No winner.";
				}
				else if (cpu_hand.equals("PAPER"))
				{
					end_result = "Paper beats rock. CPU wins!";
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					end_result = "Rock beats scissors. You win!";
				}
			}
			else if (your_hand.equals("PAPER"))
			{
				if (cpu_hand.equals("ROCK"))
				{
					end_result = "Paper beats rock. You win!";
				}
				else if (cpu_hand.equals("PAPER"))
				{
					end_result = "No winner.";
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					end_result = "Scissors beat paper. CPU wins!";
				}
			}
			else if (your_hand.equals("SCISSORS"))
			{
				if (cpu_hand.equals("ROCK"))
				{
					end_result = "Rock beats scissors. CPU wins!";
				}
				else if (cpu_hand.equals("PAPER"))
				{
					end_result = "Scissors beat paper. You win!";
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					end_result = "No winner.";
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "The CPU chose " + cpu_hand + ". " + end_result);
	}
}
