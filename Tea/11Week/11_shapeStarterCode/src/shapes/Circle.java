package shapes;

import helper.Drawable;

public class Circle extends Shape implements Drawable {
	private Point center;
	private double radius;
	
	public Circle(String color, Point center, double radius) {
		super(color); // every circle is a shape
		this.center = center;
		this.radius = radius;
	}

	public Circle(String color, double radius) {
		this(color, new Point(0,0), radius);
	}
	public Circle(String color, int x, int y, double radius) {
		this(color, new Point(x,y), radius);
	}

	/**
	 * @return the center
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * @param center the center to set
	 */
	public void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
	
	@Override
	public String toString() {
		return color + " Circle at " + center + " with radius = " + radius;
	}

	@Override  // yes -- provides method for a super type (the interface Drawable)
	public void drawInAscii() {
		System.out.println("o");
		
	}

	@Override
	public void draw() {
		System.out.println("o");
		
	}

}
