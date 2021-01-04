/*=============================================================================  
|   Source code:  Analyzer.java
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program # - Craps
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U09
|        Instructor:  William Feild  
|        Due Date:  10/09/2018, by the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|  Compile/Run: 
| 	javac Analyzer.java
|	java Analyzer
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  Craps is a game played with a pair of dice. In the game, the shooter
| (the player with the dice) rolls a pair of dice and the number of spots showing on 
|  the two upward faces are added up. Game roles @see the link: https://en.wikipedia.org/wiki/Craps
|  
|  
|        Input:   Input will involve prompting the user for the number of games to be 
|   analyzed, an integer between 1 and 1,000,000, inclusive. Input validation is expected.
|  
|       Output: (1) total number of games played,
|      (2) total number of rolls for all games played, 
|		(3) average length (in rolls) of the games played (total rolls/total games),
|		(4) longest game played (in rolls).
|		 (5) total number of games won,
|		(6) expected probability of winning overall, 
|		(7) outcome of winning overall (total wins/total games),
|		(8) total number of wins that occurred on the coming out roll,
|		(9) total number of games that ended on the opening (coming out) roll,
|		(10) expected probability of winning on the opening roll,
|		(11) outcome of winning on the coming out roll(coming out wins/coming out games),
|		(12) expected probability of the games ending on the coming out roll,
|		(13) outcome of games ending on the coming out roll (coming out games/total games),
|		(14) total number of games continuing after the coming out roll (wins & losses),
|		(15) expected probability of the games continuing after the coming out roll,
|		(16) outcome of games continuing after the coming out roll 
|       ((total games - coming out games)/total games),
|		(17) summary tally of the number of rolls for each game to finish (1 to 21+), 
|		* Coming out games = total number of games that ended on the opening (coming out) roll. 
|  
|      Process: The user should input a integer number as the game numbers, 
|			and then the program will run the number of games generate the output.
|  
|
|   Required Features Not Included:  None.
|  
|   Known Bugs:  None; the program operates correctly. 
|
|	Reference used: https://wizardofodds.com/ask-the-wizard/craps/probability/
| 	used for get the expected overall winning. 
|
|  *===========================================================================*/

import java.util.Scanner;
public class Analyzer
{
	public static void main (String[] args)
	{
		double totalGames = 0.0;
		double totalRolls = 0.0;
		double comingOutWins = 0.0;
		double wins = 0.0;
		int longestGame = 0;
		/* for the array, first element is the # of games ended with one roll,
		...... and the last element is the # of games ended with 21+ rolls
		so there are 21 elements in total in this array.**/
		int[] gamesPerRolls = new int[21];
		Craps play = new Craps();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the total games you want to play: ");
		if (in.hasNextInt()) // Input invalidation.
		{
			totalGames = in.nextDouble();
			for (int playedGames = 0; playedGames < totalGames; playedGames++)
			{
				play.playGame();
				if (play.getRollNumber() == 1) // when the dice rolled only one time, which means the coming out roll.
				{
					if (play.getGameResult() == "won")
					{
						comingOutWins++;
						gamesPerRolls[0]++; // this array is used to record the number of coming out games.
					}
					else {gamesPerRolls[0]++;}
				}
				// record how many games rolled 2 times
				else if (play.getRollNumber() == 2) {gamesPerRolls[1]++;}
				else if (play.getRollNumber() == 3) {gamesPerRolls[2]++;} // same to the above.
				else if (play.getRollNumber() == 4) {gamesPerRolls[3]++;} 
				else if (play.getRollNumber() == 5) {gamesPerRolls[4]++;}
				else if (play.getRollNumber() == 6) {gamesPerRolls[5]++;}
				else if (play.getRollNumber() == 7) {gamesPerRolls[6]++;}
				else if (play.getRollNumber() == 8) {gamesPerRolls[7]++;}
				else if (play.getRollNumber() == 9) {gamesPerRolls[8]++;}
				else if (play.getRollNumber() == 10) {gamesPerRolls[9]++;}
				else if (play.getRollNumber() == 11) {gamesPerRolls[10]++;}
				else if (play.getRollNumber() == 12) {gamesPerRolls[11]++;}
				else if (play.getRollNumber() == 13) {gamesPerRolls[12]++;}
				else if (play.getRollNumber() == 14) {gamesPerRolls[13]++;}
				else if (play.getRollNumber() == 15) {gamesPerRolls[14]++;}
				else if (play.getRollNumber() == 16) {gamesPerRolls[15]++;}
				else if (play.getRollNumber() == 17) {gamesPerRolls[16]++;}
				else if (play.getRollNumber() == 18) {gamesPerRolls[17]++;}
				else if (play.getRollNumber() == 19) {gamesPerRolls[18]++;}
				else if (play.getRollNumber() == 20) {gamesPerRolls[19]++;}
				else if (play.getRollNumber() >= 21) {gamesPerRolls[20]++;} // same to the above.
				totalRolls += play.getRollNumber();
				if (play.getRollNumber() > longestGame) {longestGame = play.getRollNumber();}
				if (play.getGameResult() == "won") {wins++;}
			}
			firstPartOutput(totalGames, totalRolls, comingOutWins, wins, longestGame, gamesPerRolls);
			secondPartOutput(totalGames, gamesPerRolls);
		}
		else
			System.out.println("Error: invaild input.");
	}
	// This method is used to display the first part of the output, which are the outputs from (1) to (16).
	public static void firstPartOutput (double totalGames, double totalRolls, double comingOutWins, double wins, int longestGame, int[] gamesPerRolls)
	{
		System.out.println("Summary of Game Statistics");
		System.out.println("+-----------------------------------------+");
		System.out.println("| (1) Total Games         " + Math.round(totalGames) + "         |");
		System.out.println("| (2) Total Rolls         " + Math.round(totalRolls) + "         |");
		System.out.println("| (3) Average Rolls       " + totalRolls / totalGames + "         |");
		System.out.println("| (4) Longest Game        " + longestGame + "         |\n");
		System.out.println("Summary of Win Statistics");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| Stat                Games               Outcome             Expected            |");
		System.out.println("+---------------------------------------------------------------------------------+");
		final double OVERALL_WIN = 0.22222 + 0.05556 + 0.088889 + 0.12626; // numbers are coming from the internet, @see templete.
		System.out.println("| Total Wins          " + Math.round(wins) + " (5)          " + (wins / totalGames) + " (7)          " + OVERALL_WIN + " (6)          |");
		// There are 36 cases in total for the 2 dice combination, 8 cases for opening win, 4 for opening lose.
		final double OPENING_WIN = 8.0 / (8.0 + 4.0);
		System.out.println("| Coming Out Wins     " + Math.round(comingOutWins) + " (8)          " + (comingOutWins / gamesPerRolls[0]) +" (11)         " + OPENING_WIN + " (10)         |");
		// Same to the above, 12 cases out of 36 cases to ended at the opening.
		final double OPENING_END = 12.0 / 36.0;
		System.out.println("| Coming Out Games    " + gamesPerRolls[0] + " (9) 		" +  (gamesPerRolls[0] / totalGames) + " (13)         " + OPENING_END + " (12)         |");
		System.out.println("+---------------------------------------------------------------------------------+\n");
		System.out.println("Summary of Ending Statistics");
		System.out.println("+---------------------------------------------------------------------------------+");
		System.out.println("| Stat                Games               Outcome             Expected            |");
		System.out.println("+---------------------------------------------------------------------------------+");
		// @see above, the one hundred percent (which is 1) minus the percent of the games ended in the opening, is the percent of the continued games.
		final double CONTINUED_GAMES = 1.0 - OPENING_END;
		System.out.println("| Continuing On Games " + Math.round((totalGames - gamesPerRolls[0])) + " (14)         " + (totalGames - gamesPerRolls[0]) / totalGames + " (16)         " + CONTINUED_GAMES + " (15)         |");
		System.out.println("+---------------------------------------------------------------------------------+\n");
	}
	// This method is used to display the second part of the output, which is the output (17).
	public static void secondPartOutput (double totalGames, int[] gamesPerRolls)
	{
		System.out.println("+-----------------------------------------+");
		System.out.println("| Rolls               # of Games          |");
		System.out.println("+-----------------------------------------+");
		System.out.println("|  1                   " + gamesPerRolls[0] + "             |");
		System.out.println("|  2                   " + gamesPerRolls[1] + "             |");
		System.out.println("|  3                   " + gamesPerRolls[2] + "             |");
		System.out.println("|  4                   " + gamesPerRolls[3] + "             |");
		System.out.println("|  5                   " + gamesPerRolls[4] + "             |");
		System.out.println("|  6                   " + gamesPerRolls[5] + "             |");
		System.out.println("|  7                   " + gamesPerRolls[6] + "             |");
		System.out.println("|  8                   " + gamesPerRolls[7] + "             |");
		System.out.println("|  9                   " + gamesPerRolls[8] + "             |");
		System.out.println("|  10                  " + gamesPerRolls[9] + "             |");
		System.out.println("|  11                  " + gamesPerRolls[10] + "             |");
		System.out.println("|  12                  " + gamesPerRolls[11] + "             |");
		System.out.println("|  13                  " + gamesPerRolls[12] + "             |");
		System.out.println("|  14                  " + gamesPerRolls[13] + "             |");
		System.out.println("|  15                  " + gamesPerRolls[14] + "             |");
		System.out.println("|  16                  " + gamesPerRolls[15] + "             |");
		System.out.println("|  17                  " + gamesPerRolls[16] + "             |");
		System.out.println("|  18                  " + gamesPerRolls[17] + "             |");
		System.out.println("|  19                  " + gamesPerRolls[18] + "             |");
		System.out.println("|  20                  " + gamesPerRolls[19] + "             |");
		System.out.println("|  21+                 " + gamesPerRolls[20] + "             |");
		System.out.println("| - - - - - - - - - - - - - - - - - - - - |");
		System.out.println("| Total               " + Math.round(totalGames) + "             |");
		System.out.println("+-----------------------------------------+");
	}
}