/*=======================================================================
|   Source code:  LoopFibSequence.java
|
|              Class: [LoopFibSequence] 
|
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program #6 - Fibonacci Sequence
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U09
|        Instructor:  William Feild  
|        Due Date:  11/29/2018, by the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|  Compile/Run: 
| 	javac Sequence.java
|	javac LoopFibSequence.java
|	
|
|        Purpose:  [The LoopFibSequence will implement next() from the interface,
|		and the next() will go to the next one of "numberOfFibonacci" and get the
|		Fibonacci number. ]
|
|  Inherits From:  [None]
|
|     Interfaces:  [Sequence.java]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [public final int STARTING_FIBONACCI = 1;
|			public final int STARTING_FIBONACCI_AMOUNT = 2;
|			public final int LARGER_FIBONACCI_LOCATION = 3;
|	The first 2 constant are used to defined the first Fibonacci number, and the numbers
| 	of Fibonacci numbers which value equals 1, and the third constant is the place where
|	the larger than 1 Fibonacci number started.]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [LoopFibSequence(beginningFibonacci)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [next()]
|   
|
|		
|
|  *===========================================================================*/

/**
	Class name: LoopFibSequence
	This class implements the interface sequence.
	This class use loop to get Fibonacci Number.
	This class provide one Fibonacci number per calling.
*/
public class LoopFibSequence implements Sequence
{
	private int numberOfFibonacci = 0;
	public final int STARTING_FIBONACCI = 1;
	public final int STARTING_FIBONACCI_AMOUNT = 2;
	public final int LARGER_FIBONACCI_LOCATION = 3;
	
	/**
		This constructor is used to initialize the variable numberOfFibonacci.
		@param - get value from the user input in the input file.
	*/
	public LoopFibSequence(int beginningFibonacci)
	{
		numberOfFibonacci = beginningFibonacci - STARTING_FIBONACCI;
	}
	
	/**
		This method is used to calculate the Fibonacci number at "numberFibonacci-th".
		~ Algorithm - when numberOfFibonacci is 1 and 2, the method returns to 1,
		when it is larger than 2, the method will provide a loop with iterating
		"numberOfFibonacci - 3" times, the loop will continue get sum until the
		"numberOfFibonacci" times.
		~ Citation sources - Big Java pg 601-602.
		@return - int value, returns to the Fibonacci number at "numberOfFibonacci-th"
		place in the sequence.
	*/
	public int next()
	{
		numberOfFibonacci ++;
		int olderFibonacci = STARTING_FIBONACCI;
		int oldFibonacci = STARTING_FIBONACCI;
		int newFibonacci = STARTING_FIBONACCI;
		if (numberOfFibonacci <= STARTING_FIBONACCI_AMOUNT)
			return STARTING_FIBONACCI;
		else
			for (int upcomingFibonacci = LARGER_FIBONACCI_LOCATION; upcomingFibonacci <= numberOfFibonacci; upcomingFibonacci++)
			{
				newFibonacci = oldFibonacci + olderFibonacci;
				olderFibonacci = oldFibonacci;
				oldFibonacci = newFibonacci;
			}
			return newFibonacci;
	}
}