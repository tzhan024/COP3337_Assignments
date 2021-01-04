/*=======================================================================
|   Source code:  BetterRectangle.java
|
|              Class: [BetterRectangle] 
|
|           Author:  Tinghui Zhang
|     Student ID:  6144880
|    Assignment:  Program #4 - BetterRectangle
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
|	
|
|        Purpose:  [BetterRectangle sub-class that extends the Rectangle
|  class of the standard Java library by adding methods to compute the area,
|  perimeter, slope and mid-point of the rectangle, as well as valid constructors 
|  for the new sub-class. ]
|
|  Inherits From:  [java.awt.Rectangle]
|
|     Interfaces:  [None]
|
|  +-----------------------------------------------------------------------
|
|      Constants:  [None]
|
| +-----------------------------------------------------------------------
|
|   Constructors:  [BetterRectangle(), BetterRectangle(width, height) ,
|   BetterRectangle (x, y, width, height), BetterRectangle (rectangle)]
|
|  Class Methods:  [None]
|
|  Instance Methods:  [getArea(), getPerimeter(), getSlope(), getMidPoint(), 
|  toString() (overrided), congruent(rectangle), equivalent(rectangle), 
|  similar(rectangle), concentric(rectangle), scaleBy(scale)]
|   
|
|		Formula used: area = width * height;
|		perimeter = (width + height) * 2;
|		slope = height / width
|		mid-point: ((x + width / 2.0), (y + height / 2.0))
|
|  *===========================================================================*/

// import Rectangle class, that used to inherits from it to make the new BetterRectangle class.
import java.awt.Rectangle;
// import Poing class, that used to get the mid-point of the rectangle.
import java.awt.Point;
public class BetterRectangle extends Rectangle
{
	final int ORIGIN = 0; // declare orgin coordinate.
	final int UNIT = 1; // declare the coordinate of(1, 1).
	final float FORMAT_TWO_DECIMAL = 100.0f;// used to format the slope in 2 decimal.
	//make a fixed rectangle start with (0, 0), and height = width = 1;
	public BetterRectangle ()
	{
		super.setLocation (ORIGIN, ORIGIN);
		super.setSize (UNIT, UNIT);
	}
	// make a rectangle start with (0, 0), user defined the height and width.
	public BetterRectangle (int width, int height)
	{
		super.setLocation (ORIGIN, ORIGIN);
		super.setSize (width, height);
	}
	// make a rectangle, user defined the starting point, height and width.
	public BetterRectangle (int x, int y, int width, int height)
	{
		super.setLocation (x, y);
		super.setSize (width, height);
	}
	// make a copy for the rectangle.
	public BetterRectangle (BetterRectangle rectangle)
	{
		this.x = rectangle.x;
		this.y = rectangle.y;
		this.width = rectangle.width;
		this.height = rectangle.height;
	}
	// get the area for the rectangle;
	public int getArea ()
	{
		return width * height;
	}
	//@override toString for area.
	public String toString(int area)
	{
		return "Area:	" + area;
	}
	// get the perimeter for the rectangle.
	// magic number coming from the formula in the heading.
	public int getPerimeter ()
	{
		return (width + height) * 2;
	}
	// get the slope for the rectangle.
	public float getSlope ()
	{
		float slope = ((float)height) / ((float)width);
		float formatSlope = Math.round(slope * FORMAT_TWO_DECIMAL) / FORMAT_TWO_DECIMAL;
		return formatSlope;
	}
	// get the mid-point for the rectangle.
	// magic number coming from the formula in the heading.
	public Point getMidPoint()
	{
		Point midPoint = new Point();
		midPoint.x = (int)(x + width / 2.0);
		midPoint.y = (int)(y + height / 2.0);
		return midPoint;
	}
	//@override the toString() method, for constructors.
	public String toString()
	{
		return getClass().getName() + "[x=" + x + ",y=" + y + ", width=" + width + ", height=" + height + ", area=" + getArea() + ", perimeter=" + getPerimeter() +", slope=" + getSlope() + ", mid-point=" + getMidPoint() + "]";
	}
	//Determine if both rectangles are confruent.
	public boolean congruent(BetterRectangle rectangle)
	{
		if (rectangle != null && (this.width + this.height) == (rectangle.width + rectangle.height))
			return true;
		else
			return false;
	}
	//Determine if both rectangles are equvalent.
	public boolean equivalent (BetterRectangle rectangle)
	{
		if (rectangle != null && getPerimeter() == rectangle.getPerimeter())
			return true;
		else
			return false;
	}
	//Determine if both rectangles are similar.
	public boolean similar(BetterRectangle rectangle)
	{
		if (rectangle != null && getArea() == rectangle.getArea())
			return true;
		else
			return false;
	}
	//Determine if both rectangles are concentric.
	public boolean concentric(BetterRectangle rectangle)
	{
		if (rectangle != null && getMidPoint() == rectangle.getMidPoint())
			return true;
		else
			return false;
	}
	// make the rectangle scale by the argument. 
	// needs to avoid negative number. 
	// returning a boolean value, fail to scale when returning false.
	public boolean scaleBy(int scale)
	{
		if (scale > ORIGIN)
		{
			this.width *= scale;
			this.height *= scale;
			return true;
		}
		else
			return false;
	}
}