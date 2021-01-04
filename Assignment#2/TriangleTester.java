/*=============================================================================  
|   Source code:  [TriangleTester.java]
|           Author:  [Tinghui Zhang] 
|     Student ID:  [6144880]  
|    Assignment:  Assignment #[2] [Triangle]
|  
|            Course:  [COP3337 (programming 2)]  
|           Section:  [U09]  
|        Instructor:  William Feild  
|        Due Date:  [20 September, 2018], at the beginning of class
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  [Java] 
|  Compile/Run:  [compile the TriangleTester.java] 
| 	javac TriangleTester.java  Triangle.java
|	java TriangleTester
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  [Write algorithm(s) and program(s) to display certain properties 
|	of a given triangle, refer to P4.3 on page 172 in the text for the basics.]  
|                  
|        Input:  [Program will prompt a user to provide x- and y-coordinates for the 
|	three Points of a triangle. User input must be validated. User prompts must clearly 
|	indicate how to enter values for each Point (which is: a pair of x- and y-coordinates, 
|	separated by a <return>). A coordinate is a floating-point value and can be positive, negative or zero.]  
|  
|       Output:  [Output will include all three Points, the lengths of all three sides, 
|	the three angles at the corners, the perimeter and the area of the triangle, and whether 
|	the triangle is Equilateral or Right-angled or neither, all in a nicely formatted layout, 
|	as directed. Values displayed will be labeled and designated in the appropriate "units", 
|	angles will be displayed in "degrees". All printed values will be rounded and formatted to 
|	four decimal-point accuracy, degrees rounded to the nearest degree. ]  
|  
|     Process:  [This program is a test for the class Triangle, all the method and algorithms 
|	are coming from the class.]  
|  
|   Required Features Not Included:  
|                [If the assignment specifies a feature that you were  
|                 unable to include in the program, mention that omission  
|                 here.  Otherwise, state that you were able to include  
|                 all of the required features in your program.
|  	  Being honest here may save you some points.]  
|  
|   Known Bugs:  [If you know of any problems with the code, provide  
|                details here; otherwise, clearly state that you know  
|                of no logic errors. Being honest here may save you some points.]  
|  *===========================================================================*/
import java.util.Scanner;
public class TriangleTester
{
	public static void main (String[] args)
	{
		double xOfA;
		double yOfA;
		double xOfB;
		double yOfB;
		double xOfC;
		double yOfC;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the x,y coordinates of three points in this order (x1,y1) (x2,y2) (x3,y3)\nSeparate each coordinate with an <Enter>: ");
		xOfA = in.nextDouble();
		yOfA = in.nextDouble();
		xOfB = in.nextDouble();
		yOfB = in.nextDouble();
		xOfC = in.nextDouble();
		yOfC = in.nextDouble();
		Triangle tri = new Triangle(xOfA,yOfA,xOfB,yOfB,xOfC,yOfC);
		if (tri.isTriangle())
		{
			System.out.printf ("Point 1 coordinates(%.4f, %.4f)\n", xOfA, yOfA);
			System.out.printf ("Point 2 coordinates(%.4f, %.4f)\n", xOfB, yOfB);
			System.out.printf ("Point 3 coordinates(%.4f, %.4f)\n\n\n", xOfC, yOfC);
			System.out.printf ("side 1 length: %.4f units\n", tri.getSideAB());
			System.out.printf ("side 2 length: %.4f units\n", tri.getSideBC());
			System.out.printf ("side 3 length: %.4f units\n\n\n", tri.getSideCA());
			System.out.printf ("Angle 1: %.0f degrees\n", tri.getAngleA());
			System.out.printf ("Angle 2: %.0f degrees\n", tri.getAngleB());
			System.out.printf ("Angle 3: %.0f degrees\n\n\n", tri.getAngleC());
			System.out.printf ("The perimeter of the triangle is: %.4f units\n", tri.getPerimeter());
			System.out.printf ("The area of the triangle is: %.4f square units\n", tri.getArea());
			System.out.println ("The triangle is Equilateral?: " + tri.isEquilateral());
			System.out.println ("The triangle is Right-angled?: " + tri.isRightAngled());
		}
		else
			System.out.println ("This is not a triangle.");
	}
}