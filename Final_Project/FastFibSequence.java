/*=======================================================================
|   Source code:  FastFibSequence.java
|
|              Class: [FastFibSequence] 
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
|	javac FastFibSequence.java
|	
|
|        Purpose:  [The FastFibSequence will implement next() from the interface,
|		the getFibonacci(firstFibonacci, secondFibonacci, numberFibonacci) method
|		will get "numberFibonacci-th" Fibonacci number from the sequence, and
|		the next() will go to the next one of "numberFibonacci" and get the
|		Fibonacci number. firstFibonacci and secondFibonacci in getFibonacci()
|		will be constant in next()]
|
|  Inherits From:  [None]
|
|     Interfaces:  [Sequence.java]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [public final int STARTING_FIBONACCI = 1;
|					public final int STARTING_FIBONACCI_AMOUNT = 2;
|					public final int LARGER_FIBONACCI_LOCATION = 3;
|	The first 2 constant are used to defined the first Fibonacci number, and the numbers
| 	of Fibonacci numbers which value equals 1, and the third constant is the place where
|	the larger than 1 Fibonacci number started.]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [FastFibSequence(beginningFibonacci)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [next(), getFibonacci(firstFibonacci, secondFibonacci, numberFibonacci)]
|   
|
|		
|
|  *===========================================================================*/

/**
	Class name: FastFibSequence
	This class implements the interface sequence.
	This class use recursion with a loop algorithm to get a Fibonacci number.
	This class provide one Fibonacci number per calling.
*/
public class FastFibSequence implements Sequence
{
	private int numberOfFibonacci = 0;
	public final int STARTING_FIBONACCI = 1;
	public final int STARTING_FIBONACCI_AMOUNT = 2;
	public final int LARGER_FIBONACCI_LOCATION = 3;
	
	/**
		This constructor is used to initialize the variable numberOfFibonacci.
		@param - get value from the user input in the input file.
	*/
	public FastFibSequence(int beginningFibonacci)
	{
		numberOfFibonacci = beginningFibonacci - STARTING_FIBONACCI;
	}
	
	/**
		The next() method is used to get next Fibonacci number.
		~ Algorithm - numberFibonacci increase, get "numberFibonacci-th"
		Fibonacci number.
		@return - int value, return to a Fibonacci number.
	*/
	public int next()
	{
		numberOfFibonacci ++;
		return getFibonacci(STARTING_FIBONACCI, STARTING_FIBONACCI, numberOfFibonacci);
	}
	
	/**
		This method is used to calculate the Fibonacci number at "numberFibonacci-th".
		~ Algorithm - when numberOfFibonacci is 1 and 2, the method returns to 1,
		when it is 3, the method will  return to 1 + 1, which is first plus second.
		When numberFibonacci is larger than 3, the old one becomes older one, and new 
		number becomes old number, and get the sum.
		@param - int firstFibonacci, used to get the first number, or the older number
		in the sequence, which is 2 places before the new one.
		int secondFibonacci, get the value on place before the new value.
		int numberFibonacci, get the place of the Fibonacci number.
		@return - int value, This is a recursion method, returns to the sum of same
		method with old argument and older argument.
	*/
	public int getFibonacci(int firstFibonacci, int secondFibonacci, int numberFibonacci)
	{
		if (numberFibonacci <= STARTING_FIBONACCI_AMOUNT)
		{
			return STARTING_FIBONACCI;
		}
		else if (numberFibonacci == LARGER_FIBONACCI_LOCATION)
		{
			return firstFibonacci + secondFibonacci;
		}
		else
		{
			return getFibonacci(secondFibonacci, firstFibonacci + secondFibonacci, numberFibonacci - STARTING_FIBONACCI);
		}
	}
}