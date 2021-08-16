package shapes;

public class Triangle extends Shape{
	private Point a, b, c;

	public Triangle(String color, Point a, Point b, Point c){
		super(color);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangle(Point a, Point b, Point c){
		this("black", a, b, c);
	}

	public Triangle(double xa, double ya, double xb, 
			double yb, double xc, double yc) {
		this(new Point(xa, ya), new Point(xb, yb), new Point(xc, yc));
	}
	@Override
	public double calculateArea() {
		double top =  a.getX()* (b.getY() - c.getY()) 
				+ b.getX()* (c.getY() - a.getY()) 
				+ c.getX()* (a.getY() - b.getY());
		double area = Math.abs(top/2);
		return area;
	}
}
