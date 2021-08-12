package shapes;

public class Circle extends Shape implements Drawable {

	private Point center;
	private double radius;
	
	public Circle(String color, Point center, double radius) {
		super(color);
		this.center = center;
		this.radius = radius;
	}

	public Circle(String color, double x, double y, double r) {
		this(color, new Point(x,y), r);
		
	}
	
	public Circle(String color, double r) {
		this(color, new Point(0,0), r);
		
	}

	@Override
	public double calculateArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
	
	public double calculateCircumference() {
		return 2 * Math.PI * radius;
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
	public String toString() {
		return color + " Circle at " + center + " with r = " + radius;
	}

	@Override
	public void drawInAcsii() {
		System.out.println("o");		
	}

	@Override
	public void draw() {
		System.out.println("🔵"); 
		
	}
}
