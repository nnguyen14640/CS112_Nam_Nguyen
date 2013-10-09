// Nam Nguyen
// Cmpr 112

import java.util.Random;
import javax.swing.JOptionPane;

public class RockPaperScissorsGameLab2 
{
	public static void main(String[] args)
	{
		Random randomizer = new Random();
		int hand;
		String cpu_hand = null;
		String your_hand = null;
		int games = 0;
		int your_winnings = 0;
		int cpu_winnings = 0;
		int ties = 0;
		int current_game = 0;
		boolean continuation = true;
		String statistic = null;
		String final_statistic_you = null;
		String final_statistic_cpu = null;
		String final_statistic_ties = null;
		
		games = Integer.parseInt(JOptionPane.showInputDialog(null, 
				"Welcome to the Rock, Paper, Scissors Game. How many games do you want to play? "));
		
		if (games == 0)
		{
			System.exit(0);
		}
		
		int mean = games / 2;
		JOptionPane.showMessageDialog(null, "Let the games begin.");
		int [] your_moves = new int[3];
		int [] cpu_moves = new int[3];
		String[] moves = {"ROCK", "PAPER", "SCISSORS"};
		
		while (continuation == true)
		{
			hand = randomizer.nextInt(3);
			boolean responses = false;
	
			if (hand == 0)
			{
				cpu_hand = moves[0];
				cpu_moves[0]++;
			}
			else if (hand == 1)
			{
				cpu_hand = moves[1];
				cpu_moves[1]++;
			}
			else if (hand == 2)
			{
				cpu_hand = moves[2];
				cpu_moves[2]++;
			}
			
			do
			{
				your_hand = JOptionPane.showInputDialog(null, "Please choose a hand (ROCK, PAPER, or SCISSORS) in all-caps. ");
				
				if (your_hand == null)
				{
					JOptionPane.showMessageDialog(null, "You have exited the game. No results are recorded.");
					System.exit(0);
				}
				else if (your_hand.equals("ROCK") || your_hand.equals("PAPER") || your_hand.equals("SCISSORS"))
				{
					responses = true;
				}
				else if (your_hand.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Your entry is blank. Please try again.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, your_hand + " is not a valid response. Please try again.");
				}
			}
			while (responses == false);
			
			JOptionPane.showMessageDialog(null, "The CPU chose " + cpu_hand + ".");
			
			if (your_hand.equals("ROCK"))
			{
				your_moves[0]++;
				
				if (cpu_hand.equals("ROCK"))
				{
					statistic = "No winner";
					ties++;
				}
				else if (cpu_hand.equals("PAPER"))
				{
					statistic = "Paper beats rock. CPU wins this round.";
					cpu_winnings++;
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					statistic = "Rock beats scissors. You win this round.";
					your_winnings++;
				}
			}
			else if (your_hand.equals("PAPER"))
			{
				your_moves[1]++;
				
				if (cpu_hand.equals("ROCK"))
				{
					statistic = "Paper beats rock. You win this round.";
					your_winnings++;
				}
				else if (cpu_hand.equals("PAPER"))
				{
					statistic = "No winner";
					ties++;
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					statistic = "Scissors beat paper. CPU wins this round.";
					cpu_winnings++;
				}
			}
			else if (your_hand.equals("SCISSORS"))
			{
				your_moves[2]++;
				
				if (cpu_hand.equals("ROCK"))
				{
					statistic = "Rock beats scissors. CPU wins this round.";
					cpu_winnings++;
				}
				else if (cpu_hand.equals("PAPER"))
				{
					statistic = "Scissors beat paper. You win this round.";
					your_winnings++;
				}
				else if (cpu_hand.equals("SCISSORS"))
				{
					statistic = "No winner.";
					ties++;
				}
			}
			
			JOptionPane.showMessageDialog(null, statistic);
			current_game++;
			
			if (cpu_winnings > mean || your_winnings > mean)
			{
				JOptionPane.showMessageDialog(null, "A winner has been determined. No further plays required.");
				continuation = false;
			}
			
			if (current_game == games)
			{
				JOptionPane.showMessageDialog(null, "That is all the games. Calculating results...");
				continuation = false;
			}
		}
		
		final_statistic_you = "Rock: " + your_moves[0] + "\n" + "Paper: " + your_moves[1] + "\n" + "Scissors: " + your_moves[2];
		final_statistic_cpu = "Rock: " + cpu_moves[0] + "\n" + "Paper: " + cpu_moves[1] + "\n" + "Scissors: " + cpu_moves[2];
		JOptionPane.showMessageDialog(null, "Moves Used:" + "\n" + "-----------" + "\n" + "You" + "\n" +
				final_statistic_you + "\n" + "CPU" + "\n" + final_statistic_cpu);
		
		final_statistic_you = "Your wins: " + your_winnings;
		final_statistic_cpu = "CPU wins: " + cpu_winnings;
		final_statistic_ties = "Ties: " + ties;
		JOptionPane.showMessageDialog(null, "Results:" + "\n" + "--------" + "\n" + final_statistic_you +
				"\n" + final_statistic_cpu + "\n" + final_statistic_ties);

		if (your_winnings > cpu_winnings)
		{
			JOptionPane.showMessageDialog(null, "You are the winner!");
		}
		else if (your_winnings < cpu_winnings)
		{
			JOptionPane.showMessageDialog(null, "The CPU wins!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wow... It's a draw!");
		}
	}
}
