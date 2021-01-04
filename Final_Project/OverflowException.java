/*=======================================================================
|   Source code:  OverflowException.java
|
|              Class: [OverflowException] 
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
| 	javac OverflowException.java
|	
|
|        Purpose:  [The OverflowException class is user defined exception which used
|			to handle the int value overflow exception.]
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
|   Constructors:  [OverflowException(), OverflowException(message)]
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
	Class name: OverflowException
	This class inherits from RuntimeException.
	This class is used to handle integer overflow exception.
*/
public class OverflowException extends RuntimeException
{
	/**
		This constructor is used for user to throw with no
		custom error message.
	*/
	public OverflowException(){}
	
	/**
		This constructor is used for user to throw when they need
		custom error message.
		@param - message is used to get message and pass it to the 
		super constructor.
	*/
	public OverflowException(String message)
	{
		super(message);
	}
}