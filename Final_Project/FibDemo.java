/*=============================================================================  
|   Source code:  FibDemo.java
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program # - Fibonacci Sequence
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
|	javac FastFibSequence.java
|	javac LoopFibSequence.java
|	javac OverflowException.java
|	javac InvalidInputException.java
|	javac UserExceptionHandling.java
|	javac FibDemo.java
|	java FibDemo inFile outFile
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  Provide a FibDemo class that will produce the three tables of n Fibonacci
|	numbers, three classes  (FibSequence, FastFibSequence, and LoopFibSequence) that each
|	implements the next() method as provided in a Sequence interface - same as used in 
|	Assignment 5, and exception handling. The number of Fibonacci numbers to be provided 
|	in the tables (n) will be input from a file and the three tables themselves will be 
|	output to yet another file - both file names to be found on the command-line (refer
|	to section 11.3, pages 527-529) upon execution of the FibDemo class.
|  
|  
|        Input:  The name of the input file and the output file (no file extension is 
|	required) will be specified on the command-line. Input validation and exception 
|	handling are expected. All input will be handled by the Demo class. The first 
|	integer in the input file is where the Fibonacci sequence will start, beginning 
|	with that Fibonacci number. The second integer in the input file will be the number
|	of Fibonacci numbers to be displayed in the tables. The integer values in the input
|	file will be [1-13] & [1-35], respectively, and inclusive. A newline will separate 
|	the two integer values. 
|  
|       Output: The output file will contain one table of recursively-computed Fibonacci
|	integers; followed by a second table of "expected" values - using an iterative algorithm
|	like LoopFib; followed by a third table of 'fast' recursively-computed Fibonacci integers.
|	The output file name will be specified on the command-line.
|  
|      Process: The user compile this program, input the input file and output file on 
|	command-line and run, then the program will display three Fibonacci sequence, with 
|	the time they used to compute for each. In the input file, there has two numbers
|	in range 1-13, and 1-35. 
|  
|   Required Features Not Included:  none 
|  
|   Known Bugs:  the program can only handle one overflow value in the sequence,
|	which is the NO.48 Fibonacci number, the exception is gonna happen if the 
|	grader change the numbers' range in the program. 
|	
|	command-line: The user should input 2 file names on command-line, the first one
|	is input file which should contains 2 integer values with the valid range. 
|	second file is the output file. If your file contains file extension name, 
|	then it should be included. 
|
|  *===========================================================================*/

/**
	File and PrintWriter class are used to build a file and write into the file.
	The Scanner class is used to read the data in the input file.
	FileNotFoundException is used to handle the exception, if the searching file
	is not exist.
	NoSuchElementException is used to handle the exception, if the file is:
	empty, lack of element, and non-integer input.
	ArrayIndexOutOfBoundsException is used to handle, if the command-line has
	no elements or missing elements.
*/
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.ArrayIndexOutOfBoundsException;

/**
	class name: FibDemo
	This class is a tester to all the previous class.
*/
public class FibDemo
{
	public static void main(String[] args) throws FileNotFoundException
	{
		final int FIRST_LINE = 0;
		final int SECOND_LINE = 1;
		String inFile = "";
		String outFile = "";
		try
		{
			inFile = args[FIRST_LINE];
			outFile = args[SECOND_LINE];
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			System.out.println("Exception: lack of input on command-line");
			System.out.println("Exception place: " + exception.getMessage());
			return;
		}
		int startingFibonacci = 0;
		int fibonacciAmount = 0;
		startingFibonacci = handleException(inFile)[FIRST_LINE];
		fibonacciAmount = handleException(inFile)[SECOND_LINE];
		UserExceptionHandling exception = new UserExceptionHandling(startingFibonacci, fibonacciAmount);
		if(exception.handleInvalidInput())
			displayAllInformation(outFile, startingFibonacci, fibonacciAmount, exception);
		else
			return;
	}
	
	/**
		This method is used to handle the exception on input file, and if the values
		are integer. It also return a integer array for the 2 values in the file.
		~Algorithm - try to run the statements, catch when exception happened. If everything
		is fine, get the values.
		@param inFile, is used to get the file name from the command-line.
		@return - int[], containing 2 elements for the 2 values in the input file.
	*/
	public static int[] handleException(String inFile) throws FileNotFoundException
	{
		final int FIRST_LINE = 0;
		final int SECOND_LINE = 1;
		final int DATA_AMOUNT = 2;
		int[] input = new int[DATA_AMOUNT];
		try
		{
			File inputFile = new File(inFile);
			Scanner fileInput = new Scanner(inputFile);
			try
			{
				input = checkInput(fileInput);
			}
			finally
			{
				fileInput.close();
			}
		}
		catch(FileNotFoundException exception)
		{
			System.out.println(exception.getMessage());
			System.exit(1);
		}
		catch(NoSuchElementException exception)
		{
			
			System.out.println(exception.getMessage());
			System.out.println("\nThis is the stack trace of the exception:");
			exception.printStackTrace();
			System.exit(1);
		}
		return input;
	}
	
	/**
		This method is used to throw the exceptions that needed to be handled
		in previous method. 
		~Algorithm - check each value, check if they have at first, then check
		if it is a integer, throw exception when false with each error message.
		@param - Scanner, used to connect with the Scanner that built in the 
		previous method. 
		@return - int[], containing 2 elements for the 2 values in the input file.
	*/
	public static int[] checkInput(Scanner fileInput)
	{
		final int FIRST_LINE = 0;
		final int SECOND_LINE = 1;
		final int DATA_AMOUNT = 2;
		int[] input = new int[DATA_AMOUNT];
		if(! fileInput.hasNext())
			throw new NoSuchElementException("Exception: empty file.");
		else if(! fileInput.hasNextInt())
			throw new NoSuchElementException("Exception: non-integer input.");
		input[FIRST_LINE] = fileInput.nextInt();
		if(! fileInput.hasNext())
			throw new NoSuchElementException("Exception: the number of Fibonacci numbers needed.");
		else if(! fileInput.hasNextInt())
			throw new NoSuchElementException("Exception: non-integer input.");
		input[SECOND_LINE] = fileInput.nextInt();
		return input;
	}
	
	/**
		This method is used to store and display all information in the file
		and complier.
		~Algorithm - store the values and display them one by one.
		@param - String outFile, used to get the output file name and write in.
		int startingFibonacci, int fibonacciAmount, are the 2 values from the 
		input file. UserExceptionHandling exception, used to connect for the integer
		overflow exception. 
	*/
	public static void displayAllInformation(String outFile, int startingFibonacci, int fibonacciAmount, UserExceptionHandling exception) throws FileNotFoundException
	{
		System.out.println("Please wait, this process may take a few seconds.(no longer than 30)");
		int[] fibonacciNumbers = new int[fibonacciAmount]; 
		int[] loopFibonacciNumbers = new int[fibonacciAmount];
		int[] fastFibonacciNumbers = new int[fibonacciAmount]; 
		PrintWriter fileOutput = new PrintWriter(outFile);
		
		long fibSequenceTime = FibSequenceSpeed(startingFibonacci, fibonacciAmount, fibonacciNumbers);
		System.out.println("Normal Recursive");
		fileOutput.println("Normal Recursive");
		fibonacciTable(fibonacciNumbers, fileOutput, fibSequenceTime, exception);
		
		long loopFibSequenceTime = LoopFibSequenceSpeed(startingFibonacci, fibonacciAmount, loopFibonacciNumbers);
		System.out.println("Iterative - Expected");
		fileOutput.println("Iterative - Expected");
		fibonacciTable(loopFibonacciNumbers, fileOutput, loopFibSequenceTime, exception);

		long fastFibSequenceTime = FastFibSequenceSpeed(startingFibonacci, fibonacciAmount, fastFibonacciNumbers);
		System.out.println("Fast Recursive");
		fileOutput.println("Fast Recursive");
		fibonacciTable(fastFibonacciNumbers, fileOutput, fastFibSequenceTime, exception);
		fileOutput.close();
	}
	
	/**
		This method is used to store the sequence to an array and compute
		the time used.
		~Algorithm - start to count time, by the time the loop start to store,
		end when the loop finish.
		@param - the first 2 integer are the 2 values from the input file,
		the integer array is used to pass the array to the higher level class.
		@return - long value, which is the time used in nanoseconds.
	*/
	public static long FibSequenceSpeed(int startingFibonacci, int fibonacciAmount, int[] fibonacciNumbers)
	{
		FibSequence fibonacci = new FibSequence(startingFibonacci);
		long startTime = System.nanoTime();
		for(int sort = 0; sort < fibonacciNumbers.length; sort++)
		{
			fibonacciNumbers[sort] = fibonacci.next();
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	/**
		This method is used to store the sequence to an array and compute
		the time used.
		~Algorithm - start to count time, by the time the loop start to store,
		end when the loop finish.
		@param - the first 2 integer are the 2 values from the input file,
		the integer array is used to pass the array to the higher level class.
		@return - long value, which is the time used in nanoseconds.
	*/
	public static long LoopFibSequenceSpeed(int startingFibonacci, int fibonacciAmount, int[] loopFibonacciNumbers)
	{
		LoopFibSequence loopFibonacci = new LoopFibSequence(startingFibonacci);
		long startTime = System.nanoTime();
		for(int sort = 0; sort < loopFibonacciNumbers.length; sort++)
		{
			loopFibonacciNumbers[sort] = loopFibonacci.next();
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	/**
		This method is used to store the sequence to an array and compute
		the time used.
		~Algorithm - start to count time, by the time the loop start to store,
		end when the loop finish.
		@param - the first 2 integer are the 2 values from the input file,
		the integer array is used to pass the array to the higher level class.
		@return - long value, which is the time used in nanoseconds.
	*/
	public static long FastFibSequenceSpeed(int startingFibonacci, int fibonacciAmount, int[] fastFibonacciNumbers)
	{
		FastFibSequence fastFibonacci = new FastFibSequence(startingFibonacci);
		long startTime = System.nanoTime();
		for(int sort = 0; sort < fastFibonacciNumbers.length; sort++)
		{
			fastFibonacciNumbers[sort] = fastFibonacci.next();
		}
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	/**
		This method is used to produce a Fibonacci table, and other information
		each sequence class.
		~Algorithm - get the sqrt of the sequence amount so we can make a square
		table. This method also contains the handling of the overflow exception. 
		after the table, the method will display the compute time in nanoseconds,
		and in seconds. 
		@param - int[] sequence is used to pair with different sequence, 
		PrintWriter fileOutput is used to input to the output file. 
		long nanoSpeed takes the time returned in different sequence.
		UserExceptionHandling exception is used to connect for the integer overflow 
		exception.
	*/
	public static void fibonacciTable(int[] sequence, PrintWriter fileOutput, long nanoSpeed, UserExceptionHandling exception) throws FileNotFoundException
	{
		int tableSize = (int)Math.ceil(Math.sqrt((double)sequence.length));
		final int ONE_PLACE_BEFORE = 1;
		final int TWO_PLACE_BEFORE = 2;
		final int LARGER_FIBONACCI_LOCATION = 3;
		final double NANO_TO_NORMAL = 1E-9;
		double normalSpeed = nanoSpeed * NANO_TO_NORMAL;
		for (int column = 0; column < tableSize; column++)
		{
			for (int row = 0; row < tableSize; row++)
			{
				int tableCoordinate = column * tableSize + row;
				if ((tableCoordinate) < sequence.length)
				{
					if(tableCoordinate < LARGER_FIBONACCI_LOCATION)
					{
						System.out.printf("%13d", sequence[tableCoordinate]);
						fileOutput.printf("%13d", sequence[tableCoordinate]);
					}
					else
						exception.handleOverflow(sequence[tableCoordinate - ONE_PLACE_BEFORE], sequence[tableCoordinate - TWO_PLACE_BEFORE], fileOutput);
					
				}
			}
			System.out.println();
			fileOutput.println();
		}
		System.out.printf("Time to compute: %d nanoseconds, %.4f seconds\n\n", nanoSpeed, normalSpeed);
		fileOutput.printf("Time to compute: %d nanoseconds, %.4f seconds\n\n", nanoSpeed, normalSpeed);
		fileOutput.println();
	}
}