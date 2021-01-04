/*=======================================================================
|   Source code:  FibSequence.java
|
|              Class: [FibSequence] 
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
|	javac FibSequence.java
|	
|
|        Purpose:  [The FibSequence will implement next() from the interface,
|		the getFibonacci(numberOfFibonacci) method will get "numberOfFibonacci-th"
|		Fibonacci number from the sequence, and the next() will go to the next one of 
|		"numberOfFibonacci" and get the Fibonacci number.]
|
|  Inherits From:  [None]
|
|     Interfaces:  [Sequence.java]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [public final int STARTING_FIBONACCI = 1;
|					public final int STARTING_FIBONACCI_AMOUNT = 2;
|	These 2 constant are used to defined the first Fibonacci number, and the numbers
| 	of Fibonacci numbers which value equals 1]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [FibSequence(beginningFibonacci)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [next(), getFibonacci(numberOfFibonacci)]
|   
|
|		
|
|  *===========================================================================*/

/**
	Class name: FibSequence
	This class implements the interface sequence.
	This class use recursion to get Fibonacci number.
	This class provide one Fibonacci number per calling.
*/
public class FibSequence implements Sequence
{
	private int numberFibonacci = 0;
	public final int STARTING_FIBONACCI = 1;
	public final int STARTING_FIBONACCI_AMOUNT = 2;
	
	/**
		This constructor is used to initialize the variable numberFibonacci.
		@param - get value from the user input in the input file.
	*/
	public FibSequence(int beginningFibonacci)
	{
		numberFibonacci = beginningFibonacci - STARTING_FIBONACCI;
	}
	
	/**
		The next() method is used to get next Fibonacci number.
		~ Algorithm - numberFibonacci increase, get "numberFibonacci-th"
		Fibonacci number.
		@return - int value, return to a Fibonacci number.
	*/
	public int next()
	{
		numberFibonacci ++;
		return getFibonacci(numberFibonacci);
	}
	
	/**
		This method is used to calculate the Fibonacci number at "numberFibonacci-th".
		~ Algorithm - when numberOfFibonacci is 1 and 2, the method returns to 1,
		when it is larger than 2, the method returns to this method with an old
		argument plus this method with older argument.
		~ Citation sources - Big Java pg 598-599.
		@param - int numberOfFibonacci, used to get the place of the number in the
		Fibonacci sequence.
		@return - int value, This is a recursion method, returns to the sum of same
		method with old argument and older argument.
	*/
	public int getFibonacci(int numberOfFibonacci)
	{
		if (numberOfFibonacci <= STARTING_FIBONACCI_AMOUNT)
			return STARTING_FIBONACCI;
		else
			return getFibonacci(numberOfFibonacci - STARTING_FIBONACCI) + getFibonacci(numberOfFibonacci - STARTING_FIBONACCI_AMOUNT);
	}
}
