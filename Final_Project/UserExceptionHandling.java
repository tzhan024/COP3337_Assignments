/*=======================================================================
|   Source code:  UserExceptionHandling.java
|
|              Class: [UserExceptionHandling] 
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
| 	javac UserExceptionHandling.java
|	
|
|        Purpose:  [The UserExceptionHandling class will handle the invalid input
|		and integer overflow exception.It also containing part of output for the 
|		Fibonacci table.]
|
|  Inherits From:  [None]
|
|     Interfaces:  [None]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [public final int MAXIMUM_INTEGER = 2147483647;
|		public final int MINIMUM_INPUT = 1;
|		public final int MAXIMUM_STARTING = 13;
|		public final int MAXIMUM_AMOUNT = 35;
|		MAXIMUM_INTEGER is the upper bound value of int type;
|		MINIMUM_INPUT, MAXIMUM_STARTING, MAXIMUM_AMOUNT are used for handle the 
|		range of the inputs in the file.]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [UserExceptionHandling(startingPlace, amount)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [invalidInput(), handleInvalidInput(), 
|	isOverflow(oneBeforeOverflow, twoBeforeOverflow), 
|	handleOverflow(oneBeforeOverflow, twoBeforeOverflow, fileOutput)]
|   
|
|		
|
|  *===========================================================================*/

//import I/O class for PrintWriter class in the argument.
import java.io.PrintWriter;
/**
	Class name: UserExceptionHandling
	This class will handle invalid input and integer overflow.
	This class used the user defined exceptions.
*/
public class UserExceptionHandling
{
	private int startingFibonacci = 0;
	private int fibonacciAmount = 0;
	private long value = 0;
	public final int MAXIMUM_INTEGER = 2147483647;
	public final int MINIMUM_INPUT = 1;
	public final int MAXIMUM_STARTING = 13;
	public final int MAXIMUM_AMOUNT = 35;
	
	/**
		This constructor is used to initialize the variable startingFibonacci,
		and fibonacciAmount.
		@param - get value from the user input in the input file.
	*/
	public UserExceptionHandling(int startingPlace, int amount)
	{
		startingFibonacci = startingPlace;
		fibonacciAmount = amount;
	}
	
	/**
		This method is used to throw out the exceptions that needed.
		~ Algorithm - by requirement, first number is 1 - 13, and second one is 
		1 - 45, throw exception if they are not in the range.
	*/
	public void invalidInput() throws InvalidInputException
	{
		if((startingFibonacci > MAXIMUM_STARTING || startingFibonacci < MINIMUM_INPUT) && (fibonacciAmount > MAXIMUM_AMOUNT || fibonacciAmount < MINIMUM_INPUT))
			throw new InvalidInputException("Exception: invalid number of arguments.");
		else
		{
			if(startingFibonacci > MAXIMUM_STARTING)
				throw new InvalidInputException("Exception: first input is great than maximum.");
			else if(startingFibonacci < MINIMUM_INPUT)
				throw new InvalidInputException("Exception: first input is zero or negative.");
			if(fibonacciAmount > MAXIMUM_AMOUNT)
				throw new InvalidInputException("Exception: second input is great than maximum.");
			else if(fibonacciAmount < MINIMUM_INPUT)
				throw new InvalidInputException("Exception: second input is zero or negative.");
		}
	}
	
	/**
		This method is used to handle the exceptions threw from invalidInput().
		~ Algorithm - when exception happened, display the error message and exit
		the system.
		@return - boolean value, return false if exception happened, so the program
		in main will not continued.
	*/
	public boolean handleInvalidInput()
	{
		try
		{
			invalidInput();
			return true;
		}
		catch(InvalidInputException exception)
		{
			System.out.println(exception.getMessage());
			return false;
		}
		
	}
	
	/**
		This method is used to determine if a Fibonacci is overflowed.
		~ Algorithm - when the value is larger than 2147483647(integer), it is 
		overflowed. To implement this, we need 2 values before the overflowed 
		value, and add them together with "long" type.
		@param - used to take the 2 values before the overflowed one. 
	*/
	public void isOverflow(int oneBeforeOverflow, int twoBeforeOverflow) throws OverflowException
	{
		value = (long)oneBeforeOverflow + (long)twoBeforeOverflow;
		if(value > MAXIMUM_INTEGER)
			throw new OverflowException("\nValue has been overflowed.");
	}
	
	/**
		This method is used to handle the overflow exception.
		This method contains part of the input of the Fibonacci 
		table.
		~ Algorithm - when find the overflowed value, turn it to 
		String type and get the length, and replace it with "*".
		@param - used to take the 2 values before the overflowed one
		, and need a PrintWriter to input to a file. 
	*/
	public void handleOverflow(int oneBeforeOverflow, int twoBeforeOverflow, PrintWriter fileOutput)
	{
		try
		{
			isOverflow(oneBeforeOverflow, twoBeforeOverflow);
			System.out.printf("%13d", value);
			fileOutput.printf("%13d", value);
		}
		catch(OverflowException exception)
		{
			String overflowedValue = String.valueOf(value);
			String coveringValue = "";
			for (int unit = 0; unit < overflowedValue.length(); unit++)
			{
				coveringValue += "*";
			}
			System.out.printf("%13s", coveringValue);
			fileOutput.printf("%13s", coveringValue);
		}
	}
	
}