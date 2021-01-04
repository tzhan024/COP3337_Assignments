/*=============================================================================  
|   Source code:  SequenceDemo.java
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program # - PrimeSequence
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
|	javac SequenceDemo.java
|	java SequenceDemo int int
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  Write algorithms and programs to create a class PrimeSequence that
| implements the Sequence interface - refer to P10.2 on page 508 in the text and 
| the next() method. This problem utilizes the Worked Example 10.1 (page 473 in the 
| text - go to wiley.com/go/javaexamples for sample downloads). Provide a Demo program
| that will produce an arbitrary sequence of n prime numbers in table format and will 
| perform an analysis of those n prime numbers.
|  
|  
|        Input:  Input will be provided on the command-line (see 11.3, pages 527-529 
| for details). Two input constants will be placed on the command-line upon execution.
|  For example: java SequenceDemo 2 25 ; where the prime sequence will start with the 
|  next prime after the first number (3), and the second number (n) is the number of 
|  prime numbers to be sequenced (25). Both numbers will be integers and both numbers 
|  must be 1 or greater. Command-line input will need to be validated. If either input 
|  fails validation, your program should display why the input failed, and it should 
|  gracefully terminate, using System.exit(1). Instructions for compilation/execution 
|  should include command-line input details and requirements, and document that the 
|  Sequence interface needs to be in the same directory with your source code.
|  
|       Output: Output will provide a table of n prime numbers. The table will be as 
| close to "square" as possible - i.e. same number of rows and columns - with at most 
| 10 entries per row. All entries will be right-aligned. Additionally, output will include
|  a "histogram" of the occurrences of the last digit [0-9] of each prime number. The 
|  histogram will be horizontal (not vertical) and will be scaled (as a percentage %), 
| with a legend at the bottom to explain the scale and display the total count of primes.
|  Each digit’s entry (a sequence of *’s) must fit on a single row, and it must be properly
|  labeled (actual count, scaled %). Scale will need to be flexible. Round up fraction percentages.
|  All output should be handled by the Demo class. A sample output is provided below. 
|  
|      Process: The user compile this program, input the first number and the number of
|	Primes on command-line and excute, then the program will display the primes and the
|	histogram.
|  
|   Required Features Not Included:  none 
|  
|   Known Bugs:  program cannot display prime number: 2. 
|	
|	command-line input details and requirements: The 2 numeber should be
|	positive integer. input the 2 numebers after your "java SequenceDemo",
|	separete by space.
|
|  *===========================================================================*/
/**
	class name: PrimeSequence.java
	This class is a tester to the class PrimeSequence.
*/
public class SequenceDemo
{
	public static void main (String[] args)
	{
		int startingNumber = 0;
		int primeAmount = 0;
		final int FIRST_DIGIT = 0;
		final int SECOND_LINE = 1;
		if(isInteger(args[FIRST_DIGIT]) && Integer.parseInt(args[FIRST_DIGIT]) > FIRST_DIGIT)
		{
			startingNumber = Integer.parseInt(args[FIRST_DIGIT]);
			if(isInteger(args[SECOND_LINE]) && Integer.parseInt(args[SECOND_LINE]) > FIRST_DIGIT)
				primeAmount = Integer.parseInt(args[SECOND_LINE]);
		}
		else
		{	
			System.out.println("Error: command-line input is not a positive integer.");
			System.exit(1); //Terminate the program.
		} //input validation for command-line input.
		int[] primeNumebrs = new int[primeAmount];
		PrimeSequence prime = new PrimeSequence(startingNumber);
		for(int sort = 0; sort < primeAmount; sort++)
		{
			primeNumebrs[sort] = prime.next(); //Store the primes numbers to an array.
		}
		System.out.println("Printing a sequence of " + primeAmount + " prime numbers: ");
		primeTable(primeNumebrs, primeAmount);
		System.out.println("\nLast Digit Histogram: ");
		histogram(primeNumebrs);
	}
	
	/**
		This method is used to print the prime table.
		~Algorithm: tableSize is the square root of the number of primes, 
		so we can make it looks like a square. The second nested for loop
		is for avoid rows become to long(Maximun 10 number per row.)
		@param - int[] primeNumebrs, and int primeAmount, used to get data
		from the main methos.
	*/
	public static void primeTable(int[] primeNumebrs, int primeAmount)
	{
		int tableSize = (int)Math.ceil(Math.sqrt((double)primeAmount));
		final int MAXIMUM_ROW = 10;
		int columnNumber = (int)Math.ceil((double)primeAmount / MAXIMUM_ROW);
		if (tableSize <= MAXIMUM_ROW)
		{
			for (int column = 0; column < tableSize; column++)
			{
				for (int row = 0; row < tableSize; row++)
				{
					if ((column * tableSize + row) < primeAmount)
						System.out.printf("%10d", primeNumebrs[column * tableSize + row]);
				}
				System.out.println();
			}
		}
		else
		{
			for (int column = 0; column < columnNumber; column++)
			{
				for (int row = 0; row < MAXIMUM_ROW; row++)
				{
					if ((column * MAXIMUM_ROW + row) < primeAmount)
						System.out.printf("%10d", primeNumebrs[column * MAXIMUM_ROW + row]);
				}
				System.out.println();
			}
		}
	}
	
	/**
		This method is used to print the histogram.
		~Algorithm: use remainder to know the last 
		digit, and get a total numeber for each.
		@param - int[] primeNumebrs, used to get data
		from the main method.
	*/
	public static void histogram(int[] primeNumebrs)
	{
		int[] digitAmount = new int[10];
		final int DIGIT_RANGE = 10;
		final double TO_PERCENTAGE = 100.0;
		int percent = 0;
		int totalPercent = 0;
		String chartLength = "";
		for (int digit = 0; digit < DIGIT_RANGE; digit++)
		{
			for (int sort = 0; sort < primeNumebrs.length; sort++)
			{
				if (primeNumebrs[sort] % DIGIT_RANGE == digit)
					digitAmount[digit]++;
			}
			percent = (int)Math.round(digitAmount[digit] / (double)primeNumebrs.length * TO_PERCENTAGE);
			for (int unit = 0; unit < percent; unit++)
			{
				chartLength += "*";
			}
			System.out.printf("[%d]", digit);
			System.out.print(String.format("%-40s", chartLength));
			System.out.println("(" + digitAmount[digit] + ", " + percent + "%)");
			chartLength = "";
			totalPercent += percent;
		}
		System.out.println("________________________________________________");
		System.out.print(String.format("%-43s", "Total(actual count, %)"));
		System.out.println("(" + primeNumebrs.length + ", " + totalPercent + "%)");
		System.out.println("Scaled as %, each * = 1%");
		System.out.println("Total count may vary slightly from 100% due to rounding");
	}
	
	/**
		This method is used to determine if the input is a integer.
		~Algorithm: check if each character of the String is a digit,
		if all chars are digit, then it is a integer.
		@param - String input, used to take the input and analyze.
		@return - boolean value, if input is integer, return true.
	*/
	public static boolean isInteger(String input)
	{
		for (int chars = 0; chars < input.length(); chars++)
		{
			if (!Character.isDigit(input.charAt(chars)))
				return false;
		}
		return true;
	}
}