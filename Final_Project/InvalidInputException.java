/*=======================================================================
|   Source code:  InvalidInputException.java
|
|              Class: [InvalidInputException] 
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
| 	javac InvalidInputException.java
|	
|
|        Purpose:  [The InvalidInputException class is user defined exception which used
|			to handle the invalid input in the input file.]
|
|  Inherits From:  [RuntimeException]
|
|     Interfaces:  [None]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [None]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [InvalidInputException(), InvalidInputException(message)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [None]
|   
|
|
|  *===========================================================================*/

//Used for inheritance, so we can make a user defined Exception.
import java.lang.RuntimeException;

/**
	Class name: InvalidInputException
	This class inherits from RuntimeException.
	This class is used to handle invalid input exception.
*/
public class InvalidInputException extends RuntimeException
{
	/**
		This constructor is used for user to throw with no
		custom error message.
	*/
	public InvalidInputException(){}
	
	/**
		This constructor is used for user to throw when they need
		custom error message.
		@param - message is used to get message and pass it to the 
		super constructor.
	*/
	public InvalidInputException(String message)
	{
		super(message);
	}
}