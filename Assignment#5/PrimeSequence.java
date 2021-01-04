/*=======================================================================
|   Source code:  PrimeSequence.java
|
|              Class: [PrimeSequence] 
|
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program #4 - PrimeSequence
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U09
|        Instructor:  William Feild  
|        Due Date:  11/01/2018, by the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|  Compile/Run: 
| 	javac Sequence.java
|	javac PrimeSequence.java
|	
|
|        Purpose:  [The PrimeSequence class will implement the next() method,
|  an isPrime() method to determine if a number is prime, and any other 
| methods/instance variables required for the class. Note: the first prime 
| number is 2. Document the algorithm used in your prime search.]
|
|  Inherits From:  [None]
|
|     Interfaces:  [Sequence.java]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [public final int noRemainder = 0
|	This constant is used to determine if the number can exact divide divisor]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [PrimeSequence(startingNumber)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [next(), setIsPrime(), isPrime()]
|   
|
|		
|
|  *===========================================================================*/
/**
	Class name: PrimeSequence.java
	This class implements the interface sequence.
	This class provide one prime number per calling.
*/
public class PrimeSequence implements Sequence
{
	private int number = 0;
	private int prime = 0;
	private boolean exactDivision = true;
	final int noRemainder = 0;
	
	/**
		This constructor is used to initialize the variable number.
		@param - get value from the user input in the tester.
	*/
	public PrimeSequence(int startingNumber)
	{
		number = startingNumber;
	}
	
	/**
		This method is used to find a prime number.
		Loop terminate once find a prime.
		@return - int value, returns to a prime number.
	*/
	public int next()
	{
		do
		{
			number ++;
			setIsPrime();
			if (isPrime())
			{
				prime = number;
			}
		}while (! isPrime());
		return prime;
	}
	
	/**
		This method determine if a number is a prime.
		~Algorithm: By definition, primes cannot be exact divided by 
		all numbers except 1 and itself.
		Loop will terminated after it tried all divisors, or it find a 
		exact division.
	*/
	public void setIsPrime()
	{
		int divisor = 2;
		do
		{
			if (number % divisor == noRemainder)
			{
				exactDivision = true;
			}
			else
			{
				exactDivision = false;
			}
			divisor++;
		} while (divisor < number && exactDivision == false);
	}
	
	/**
		This method is used to get the result from the setIsPrime()
		method.
		@return - boolean value, if the number cannot be exact divided
		by other numbers, then it is a prime.
	*/
	public boolean isPrime()
	{
		return ! exactDivision;
	}
}