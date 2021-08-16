package shapes;

import java.util.*;
import java.time.*;

import helper.Drawable;
import people.Student;

public class SampleProgram {
	private ArrayList<Shape> myShapes;
	private ArrayList<Drawable> things;

	public SampleProgram() {
		myShapes = new ArrayList<>();
		things = new ArrayList<>();
		makeSampleShapes();
		things.add(new Student("Brianna", LocalDate.of(1998, 11, 15), 4.0, "neuroscience"));

		for (Shape s: myShapes) {
			if (s instanceof Drawable) {
				things.add((Drawable) s);
			}
		}
		//things.addAll(myShapes);
		things.add(new Student("Jenny", LocalDate.of(2001, 7, 28), 4.0, "math"));
	}

	private void makeSampleShapes() {
		myShapes.add(new Circle("red", 10));
		myShapes.add(new Circle("black", 10, 10, 10));
		myShapes.add(new Circle("purple", new Point(5.5,5.5), 33.2));
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
			// if drawable, draw the shape
			if(s instanceof Drawable) {
				
				((Drawable) s).draw();
			}

		}
		
	}
	public void drawStuff() {
		for(Drawable d: things) {
			d.draw();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleProgram p = new SampleProgram();
		p.printAllShapes();
		p.drawStuff();
		p.sortShapes();
		
		
		//Rectangle r = new Rectangle("yellow", 0, 0, 5, 4);
		//r.draw();

	}

	private void sortShapes() {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle("blue", 0,0,1, 1);
		Triangle t = new Triangle("blue",  new Point(0,0), 
				  new Point(1,1),
				  new Point(3,5));

		myShapes.add(r);
		myShapes.add(new Rectangle("red", 0,0,1, 1));
		myShapes.add(new Rectangle("blue", 0,0,1, 1));
		Collections.sort(myShapes);
		for(Shape s: myShapes) {
			if(s.equals(t)) {
				System.out.println("THAT's My shape (triangle): " + t);
				System.out.println("matching thing in list: " + s);
			}
			
		}
		

		
	}



}
