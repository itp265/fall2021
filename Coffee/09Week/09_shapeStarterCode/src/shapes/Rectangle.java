package shapes;
public class Rectangle extends Shape {

	private Point upperLeft;
	private Point lowerRight;
	private double length;
	private double width;

	public Rectangle(String color, Point upper, Point lower) {
		super(color);
		this.upperLeft = upper;
		this.lowerRight = lower;
		setLengthAndWidth();
	}
	public Rectangle(String color, double x1, double y1, 
			double x2, double y2) {
		this(color, new Point(x1, y1), new Point (x2,y2));
	}

	private void setLengthAndWidth() {
		width = Math.abs(lowerRight.getX() - upperLeft.getX())	;
		length = Math.abs(lowerRight.getY() - upperLeft.getY())	;
	}

	@Override
	public double calculateArea() {
		return length*width;
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	@Override
	public String toString() {
		// protected instance variable can be accessed directly
		return this.color + " rectangle, l = " + length + " w = " + width;

	}


}
