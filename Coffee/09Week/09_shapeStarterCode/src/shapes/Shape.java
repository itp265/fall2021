package shapes;

public abstract class Shape {
	protected String color;

	public Shape(String color) {
		this.color = color;
	}

	public abstract double calculateArea();


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		return this.color + " Shape";
	}
}
