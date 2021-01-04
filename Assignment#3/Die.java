/*=======================================================================
|   Source code:  Die.java
|
|              Class: [Die] 
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
| 	javac Die.java
|	java Die
|
|        Purpose:  [This class is used to build a die that need to roll in 
|   				game method. ]
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
|   Constructors:  [ Die() ]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [ rollDie(sides) ]
|
|  *===========================================================================*/

// This class is used to build a die.
import java.util.Random;
public class Die
{
	private Random sideNumber;
	private int dieSide;
	// Constructor that uses to initialize the instance variable.
	public Die()
	{
		sideNumber = new Random();
		dieSide = 0;
	}
	// This method is used to build a die.
	public int rollDie (int sides)
	{
		dieSide = sides;
		return sideNumber.nextInt(sides) + 1; // plus 1 to avoid 0 in random numbers.
	}
}