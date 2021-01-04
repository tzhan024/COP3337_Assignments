/*=============================================================================  
|   Source code:  BRectTester.java
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program # - BetterRectangle
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U09
|        Instructor:  William Feild  
|        Due Date:  10/18/2018, by the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|  Compile/Run: 
| 	javac BetterRectangle.java
|	javac BRectTester.java
|	java BRectTester
| 
|  +-----------------------------------------------------------------------------  
|  
|  Description:  Provide a BetterRectangle sub-class that extends the Rectangle class
| of the standard Java library by adding methods to compute the area, perimeter, slope
| and mid-point of the rectangle, as well as valid constructors for the new sub-class.
| Provide a Tester program that will execute and validate the BetterRectangle sub-class. 
|  
|  
|        Input:   No user input required. No graphical interface permitted. Rectangles 
|	will be "hard-coded" into your Tester class. Specifics for the required rectangles 
|	will be provided later. Develop your own test cases until then...
|  
|       Output: Output will provide validation that all new features in the sub-class 
|	are functioning properly - presented in a clearly labeled, readable and attractive
|	 manner. See sample output below. Display "before" and "after" to feature the mutator
|	 method, expected values for the utility methods. All output should be handled by the
|	 Tester class, not the super or sub-class. Use the toString() method to display the 
|	characteristics of each rectangle. 
|  
|      Process: The user compile this program, and the program will display the 4
|		rectangles.
|  
|   Required Features Not Included:  Not all characteristic of rect used toString() method. 
|  
|   Known Bugs:  Didn't find any bug so far. 
|
|
|  *===========================================================================*/

// Point class that used for the mid-point of the rectangle
import java.awt.Point;
public class BRectTester
{
	public static void main(String[] args)
	{
		final int RECT_A_WIDTH = 3;
		final int RECT_A_HEIGHT = 4;
		final int RECT_C_X = 1;
		final int RECT_C_Y = 1;
		final int RECT_C_WIDTH = 4;
		final int RECT_C_HEIGHT = 3;
		// 3 and 4 are hard-coded height and weight.
		BetterRectangle bRectA = new BetterRectangle(RECT_A_WIDTH, RECT_A_HEIGHT);
		BetterRectangle bRectB = new BetterRectangle(bRectA);
		// 1, 1, 4, 3 are hard-coded elements of the rectangle.
		BetterRectangle bRectC = new BetterRectangle(RECT_C_X, RECT_C_Y, RECT_C_WIDTH, RECT_C_HEIGHT);
		BetterRectangle bRectD = new BetterRectangle();
		
		System.out.println ("A: " + bRectA.toString());
		System.out.println ("B: " + bRectB.toString());
		System.out.println ("C: " + bRectC.toString());
		System.out.println ("D: " + bRectD.toString() + "\n");
		displayAccessor(bRectA);
		displayUtility(bRectB, bRectC);
		displayMutator(bRectD);
	}
	// This method is used to display the accessor methods tests.
	public static void displayAccessor(BetterRectangle bRectA)
	{
		int area = bRectA.getArea();
		int perimeter = bRectA.getPerimeter();
		float slope = bRectA.getSlope();
		Point midPoint = bRectA.getMidPoint();
		System.out.println("Accessor methods being executed for Rectangle A...");
		System.out.println ("A: " + bRectA.toString());
		System.out.println(bRectA.toString(area));
		System.out.println("Perimeter:	" + perimeter);
		System.out.println("Slope:	" + slope);
		System.out.println("MidPoint:	(" + midPoint.x + ", " + midPoint.y + ")");
	}
	// This method is used to display the utility methods tests.
	public static void displayUtility(BetterRectangle bRectB, BetterRectangle bRectC)
	{
		boolean isEquals = bRectB.equals(bRectC);
		boolean isCongruent = bRectB.congruent(bRectC);
		boolean isEquivalent = bRectB.equivalent(bRectC);
		boolean isSimilar = bRectB.similar(bRectC);
		boolean isConcentric = bRectB.concentric(bRectC);
		System.out.println("\nUtility methods being executed for Rectangle B and C...");
		System.out.println ("B: " + bRectB.toString());
		System.out.println ("C: " + bRectC.toString());
		System.out.println("Equals? 	" + isEquals + "		Expected: false");
		System.out.println("Congruent? 	" + isCongruent + "		Expected: true");
		System.out.println("Equivalent? 	" + isEquivalent + "		Expected: true");
		System.out.println("Similar? 	" + isSimilar + "		Expected: true");
		System.out.println("Concentric? 	" + isConcentric + "		Expected: false");
	}
	// This method is used to display the mutator methods tests.
	public static void displayMutator(BetterRectangle bRectD)
	{
		System.out.println("\nMutuator methods being executed for Rectangle D...");
		System.out.println ("D: " + bRectD.toString());
		final int SCALE_BY_POSITIVE = 4;
		final int SCALE_BY_NEGATIVE = -4;
		System.out.println("scale by: " + SCALE_BY_POSITIVE + "? " + bRectD.scaleBy(SCALE_BY_POSITIVE));
		System.out.println("scale by: " + SCALE_BY_NEGATIVE + "? " + bRectD.scaleBy(SCALE_BY_NEGATIVE));
		System.out.println ("D: " + bRectD.toString());
	}
}