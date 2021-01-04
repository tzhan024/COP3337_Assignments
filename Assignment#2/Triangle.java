/*=======================================================================
|   Source code:  Triangle.java
|
|              Class: [Triangle] 
|
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Assignment #2 - Triangle
|  
|            Course:  COP 3337 (Intermediate Programming)
|           Section:  U09
|        Instructor:  William Feild  
|        Due Date:  20 September, 2018, by the beginning of class 
|
|	I hereby certify that this collective work is my own
|	and none of it is the work of any other person or entity.
|	______________________________________ [Signature]
|  
|        Language:  Java
|  Compile/Run: 
| 	javac TriangleTester.java
|	java TriangleTester
|
|        Purpose:  [This class contains the methods that used to calculate the
|	sides, angles, perimeter, area, and determine the type of the triangle.]
|
|			Formula used: Side formula: a^2 + b^2 = c^2
|					  
|						 Angle formula: cosA=(b^2 + c^2 - a^2) / (2 * b * c)
|					  
|						 Area formula: S = a * b * sin(C) / 2
|					  
|
|  Inherits From:  [None]
|
|     Interfaces:  [None]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [Name all public class constants, and provide a very
|                   brief (but useful!) description of each.]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [Triangle (aX, aY, bX, bY, cX, cY)]
|
|  Class Methods:  [List the names, arguments, and return types of all
|                   private class methods.]
|
|  Instance Methods:  [double getSideAB(), double getSideBC(), double getSideCA(),
|	double getAngleA(), double getAngleB(), double getAngleC(), double getPerimeter(),
|	double getArea(), boolean isTriangle(), boolean isEquilateral(), boolean isRightAngled()]
|
|  *===========================================================================*/
import java.awt.geom.Point2D;
public class Triangle
{
	private Point2D.Double a = new Point2D.Double();
	private Point2D.Double b = new Point2D.Double();
	private Point2D.Double c = new Point2D.Double();
	
	//Constructor that used to express the values from the main.
	public Triangle(double aX, double aY, double bX, double bY, double cX, double cY)
	{
		a.x = aX;
		a.y = aY;
		b.x = bX;
		b.y = bY;
		c.x = cX;
		c.y = cY;
	}
	
	/**
		This method is used to compute the side 1, which is the side between point a and point b.
		Magic number 2 is coming from the formula.
	*/
	public double getSideAB()
	{
		return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
	}
	
	//This method is used to compute side 2 (side BC).
	public double getSideBC()
	{
		return Math.sqrt(Math.pow(b.x - c.x,2) + Math.pow(b.y - c.y,2));
	}
	
	//This method is used to compute side 3 (side CA).
	public double getSideCA()
	{
		return Math.sqrt(Math.pow(c.x - a.x,2) + Math.pow(c.y - a.y,2));
	}
	
	/**
		This method is used to compute the angle at point A.
		Magic number 2 is coming from the formula.
	*/
	public double getAngleA()
	{
		return Math.toDegrees(Math.acos((getSideAB() * getSideAB() + getSideCA() * getSideCA() - getSideBC() * getSideBC()) / (2 * getSideAB() * getSideCA())));
	}
	
	//This method is used to compute the angle at point B.
	public double getAngleB()
	{
		return Math.toDegrees(Math.acos((getSideAB() * getSideAB() + getSideBC() * getSideBC() - getSideCA() * getSideCA()) / (2 * getSideAB() * getSideBC())));
	}
	
	//This method is used to compute the angle at point C.
	public double getAngleC()
	{
		return Math.toDegrees(Math.acos((getSideCA() * getSideCA() + getSideBC() * getSideBC() - getSideAB() * getSideAB()) / (2 * getSideBC() * getSideCA())));
	}
	
	//This method is used to calcute the perimater of the triangle.
	public double getPerimeter()
	{
		return getSideAB() + getSideBC() + getSideCA();
	}
	
	/**
		This method is used to calcute the area of the triangle.
		The magic number 2 is coming from the formula.
	*/
	public double getArea()
	{
		return getSideAB() * getSideCA() * Math.sin(Math.toRadians(getAngleA())) / 2;
	}
	
	//This method is used to determine if the three points can form a triangle.
	public boolean isTriangle()
	{
		if (getSideAB() + getSideBC() > getSideCA() && getSideCA() + getSideBC() > getSideAB() && getSideAB() + getSideCA() > getSideBC())
			return true;
		else
			return false;
	}
	
	//This method is used to determine if the triangle is a equilateral triangle.
	public boolean isEquilateral()
	{
		if (Math.rint(getAngleA()) == Math.rint(getAngleB()) && Math.rint(getAngleB()) == Math.rint(getAngleC()) && Math.rint(getAngleA()) == Math.rint(getAngleC()))
			return true;
		else
			return false;
	}
	
	//This method is used to determine if the triangle is a right-angled triangle.
	public boolean isRightAngled()
	{
		final double RIGHT_ANGLE = 90.0;
		if (Math.rint(getAngleA()) == RIGHT_ANGLE || Math.rint(getAngleB()) == RIGHT_ANGLE || Math.rint(getAngleC()) == RIGHT_ANGLE)
			return true;
		else
			return false;
	}
}