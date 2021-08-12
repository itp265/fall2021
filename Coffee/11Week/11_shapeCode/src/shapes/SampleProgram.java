package shapes;

import java.time.LocalDate;
import java.util.*;

import people.Student;

public class SampleProgram {
	private ArrayList<Shape> myShapes;
	private ArrayList<Drawable> things;

	public SampleProgram() {
		myShapes = new ArrayList<>();
		things = new ArrayList<>();
		makeSampleShapes();
		
		things.add(new Student("Ashleigh", LocalDate.of(2000, 11, 19), 4.0, "IR"));
		for(Shape s : myShapes) {
			if ( s instanceof Drawable) {
				things.add((Drawable) s);
			}
		}
		things.add(new Student("Micaela", LocalDate.of(2000, 9, 1), 4.0, "IR & Data Science"));
	}

	private void makeSampleShapes() {
		myShapes.add(new Rectangle("red", 0, 0, 1, 1));
		myShapes.add(new Circle("red", 10));
		myShapes.add(new Circle("black", 0, 10, 10));
		myShapes.add(new Circle("purple", new Point(5.5,5.5), 33.2));
		myShapes.add(new Rectangle("red", 0, 0, 1, 1));
		myShapes.add(new Rectangle("black", 0, 0, 1, 1));
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
			if(s instanceof Circle) {
				//s = new Rectangle("yellow", 0, 0, 5, 10);
				Circle circle = (Circle)s; //typecast first
				double c = circle.calculateCircumference();
				double c2 = ((Circle)s).calculateCircumference();
			
			
				System.out.println("\n\t circumference = " + c);
			}
		

		}
		Collections.sort(myShapes);
		System.out.println("Here are the sorted shapes");
		for(Shape s: myShapes) {
			System.out.println(s + " area = " + s.calculateArea());
			
		}
		//interface == new concrete class that implements that interface
		Comparator<Shape> myComparer = new ShapeComparator<>();
	
		Collections.sort(myShapes, myComparer);
		System.out.println("Here are the sorted shapes by TYPE of shape using comparator");
		for(Shape s: myShapes) {
			System.out.println(s + " area = " + s.calculateArea());
			
		}
	}
	
	public void drawStuff() {
		System.out.println("IN ASCII");
		for(Drawable o: things) {
			o.drawInAcsii();
		}
		
		System.out.println("Regular Draw");
		for(Drawable o: things) {
			o.draw();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleProgram p = new SampleProgram();
		p.printAllShapes();
		//p.drawStuff();


	}



}
