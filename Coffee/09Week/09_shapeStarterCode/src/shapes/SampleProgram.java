package shapes;

import java.util.*;

public class SampleProgram {
	private ArrayList<Shape> myShapes;

	public SampleProgram() {
		myShapes = new ArrayList<>();
		makeSampleShapes();
	}

	private void makeSampleShapes() {
	//	myShapes.add(new Circle("red", 10));
//		myShapes.add(new Circle("black", 10, 10, 10));
	//	myShapes.add(new Circle("purple", new Point(5.5,5.5), 33.2));
		myShapes.add(new Rectangle("green", 10, 10, 30, 40));
		myShapes.add(new Rectangle("yellow", 0, 0, 5, 10));
		myShapes.add(new Triangle("blue", 
								  new Point(0,0), 
								  new Point(1,1),
								  new Point(3,5)));
	}

	public void printAllShapes() {
		for(Shape s: myShapes) {
			// all shapes have calculateArea
			double area = s.calculateArea();
			System.out.println(s + "\n\t area = " + area);

		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleProgram p = new SampleProgram();
		p.printAllShapes();


	}



}
