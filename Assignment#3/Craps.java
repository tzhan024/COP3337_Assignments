/*=======================================================================
|   Source code:  Craps.java
|
|              Class: [Craps] 
|
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program #3 - Craps
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
| 	javac Craps.java
|	java Craps
|
|        Purpose:  [This class is used to process the game, and get the game
|       			Result and the rolled times that will used in Analyzer.]
|
|  Inherits From:  [None]
|
|     Interfaces:  [None]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [None]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [ Craps() ]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [setRollNumber(), getRollNumber(), playGame(), 
|					   getGameResult(), resetgame()]
|
|  *===========================================================================*/

// This class is used provide the process of the game, and some constants.
public class Craps
{
	private Die die;
	private int sum;
	private int rollNumber;
	private String gameResult;
	// Construstor that used to initialize the instance value.
	public Craps ()
	{
		die = new Die ();
		sum = 0;
		rollNumber = 0;
		gameResult = "unknown";
	}
	// A setter method used to update the rolled times.
	public void setRollNumber()
	{
		rollNumber++;
	}
	// A getter menhod to get the final rolled times for one game. 
	public int getRollNumber()
	{
		return rollNumber;
	}
	// This method contains the process of the game, play the game once when calling the method.
	public void playGame()
	{
		final int DIE_SIDES = 6;
		final int SNAKE_EYES = 2;
		final int ACE_DEUCE = 3;
		final int BOX_CARS = 12;
		final int NATURAL = 7;
		final int YO_LEVEN = 11;
		resetgame();
		sum = die.rollDie(DIE_SIDES) + die.rollDie(DIE_SIDES);
		setRollNumber();
		int point = sum;
		int value = 0;
		if (point == NATURAL || point == YO_LEVEN)
			gameResult = "won";
		else if (point != SNAKE_EYES && point != ACE_DEUCE && point != BOX_CARS)
		{
			do
			{
				sum = die.rollDie(DIE_SIDES) + die.rollDie(DIE_SIDES);
				setRollNumber();
				value = sum;
			} while (value != point && value != NATURAL);
			if (value == point)
				gameResult = "won";
			else
				gameResult = "lost";
		}
		else
			gameResult = "lost";
	}
	// This method is used to get the final game result.
	public String getGameResult()
	{
		return gameResult;
	}
	// This method is used to reset the game.
	public void resetgame ()
	{
		sum = 0;
		rollNumber = 0;
	}
}