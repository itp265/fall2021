package shapes;

public abstract  class Shape implements Comparable<Shape>{
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
	
	@Override
	public final int compareTo(Shape other) {
		// shapes: natural ordering is smallest area to largest area
		// same area.... then compare color
		//type of the shape (based on the shape's class type.... 
		if (this.equals(other)) return 0;
		
		
		double diff = this.calculateArea() - other.calculateArea(); 
		if(diff > 0) {
			return 1; 
		}
		else if (diff < 0) {
			return -1;
		}
		else {
			// SAME AREA, then look at color
			int num = this.color.compareToIgnoreCase(other.color);
			if(num == 0) { //area and color is the same
				String myType = this.getClass().getSimpleName();
				String otherType = other.getClass().getSimpleName();
				num = myType.compareTo(otherType);
			}
			return num;
		}
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//if(obj instanceof Student) { // Student and a StudentTA  can be the same
		// if(obj instanceof Shape) // doesn't make sense because a Circle and a Rectangle will never be equal	
		
		if (getClass() != obj.getClass()) // only if the objects are the SAME actual class are they equal
			return false;
		Shape other = (Shape) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
	
}
