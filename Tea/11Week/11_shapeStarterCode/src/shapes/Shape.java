package shapes;

public abstract class Shape implements Comparable<Shape>{
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
		if(this.equals(other)) {
			return 0;
		}
		else {
			int answer = 0;
			double num  = this.calculateArea() - other.calculateArea();
			if(num > 0) {
				answer = 1; // any postive number
			}
			else if (num < 0) {
				answer = -1; //negative
			}
			else { // areas are the same
				answer = this.color.compareTo(other.color);
				if(answer == 0) {
					answer = this.getClass().getSimpleName().compareTo(
							other.getClass().getSimpleName());
					
				}
			}
			return answer;
		}
	}
	@Override
	public boolean equals(Object o) {
	//	System.out.println("in shape equals: " + this + " compared to: " + o);
		if (this == o) return true; //strictest defn of equals
		if(o == null) return false; // something compared to nothing is always false
		if(! this.getClass().equals(o.getClass()))
	//	if(!(o instanceof Shape))
		{// are the class types (or class SUBTYPES the same?
			return false;
		}
		Shape other = (Shape)o;
		return this.color.equals(other.color) && 
				Math.abs(this.calculateArea()- other.calculateArea()) < .0001;
	}
}
