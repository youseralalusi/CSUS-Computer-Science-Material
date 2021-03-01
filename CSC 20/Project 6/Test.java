// Test

import java.util.Scanner;

public class Test {
	/*
	 * Creating an Scanner class object which is used to get the inputs entered
	 * by the user
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Object array[] = new Object[12];
		fillArray(array);
		getArea(array);
		getPerimeter(array);
		output(array);

	}

	private static void output(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof Circle) {

				System.out.println(((Circle)(array[i])));
			} else if (array[i] instanceof Rectangle) {
				System.out.println(((Rectangle)(array[i])));
			} else if (array[i] instanceof Triangle) {
				System.out.println(((Triangle)(array[i])));
			}
		}

	}

	private static void getPerimeter(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof Circle) {

				System.out.println("The area of the circle with the radius "+((Circle)(array[i])).getRadius()+" is "+((Circle)(array[i])).getPerimeter());
			} else if (array[i] instanceof Rectangle) {
				System.out.println("The area of the rectangle with the width and height of "+((Rectangle)(array[i])).getWidth()+","+((Rectangle)(array[i])).getWidth()+" is "+((Rectangle)(array[i])).getPerimeter());
			} else if (array[i] instanceof Triangle) {
				System.out.println("The area of the triangle with the side1 ,side2 and side3 of "+((Triangle)(array[i])).getSide1()+","+((Triangle)(array[i])).getSide2()+", "+((Triangle)(array[i])).getSide3()+" is "+((Triangle)(array[i])).getPerimeter());
			}
		}

	}

	private static void getArea(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof Circle) {

				System.out.println("The area of the circle with the radius "+((Circle)(array[i])).getRadius()+" is "+((Circle)(array[i])).getArea());
			} else if (array[i] instanceof Rectangle) {
				System.out.println("The area of the rectangle with the width and height of "+((Rectangle)(array[i])).getWidth()+","+((Rectangle)(array[i])).getWidth()+" is "+((Rectangle)(array[i])).getArea());
			} else if (array[i] instanceof Triangle) {
				System.out.println("The area of the triangle with the side1 ,side2 and side3 of "+((Triangle)(array[i])).getSide1()+","+((Triangle)(array[i])).getSide2()+", "+((Triangle)(array[i])).getSide3()+" is "+((Triangle)(array[i])).getArea());
			}
		}

	}

	private static void fillArray(Object[] array) {
		String type;

		for (int i = 0; i < array.length; i++) {

			System.out
			.print("Enter the Type of object (circle/Rectangle/triangle):");
			type = sc.next();
			if (type.equalsIgnoreCase("circle")) {
				System.out.print("Enter radius :");
				double r = getValue();
				Circle c = new Circle(r);
				array[i] = c;
			} else if (type.equalsIgnoreCase("rectangle")) {
				System.out.print("Enter width :");
				double w = getValue();
				System.out.print("Enter height :");
				double h = getValue();
				Rectangle r = new Rectangle(w, h);
				array[i] = r;
			} else if (type.equalsIgnoreCase("triangle")) {
				System.out.print("Enter Side#1:");
				double side1 = getValue();
				System.out.print("Enter Side#2:");
				double side2 = getValue();
				System.out.print("Enter Side#3:");
				double side3 = getValue();
				Triangle t = new Triangle(side1, side2, side3);
				array[i] = t;
			}
		}

	}

	private static double getValue() {
		double val;
		while (true) {
			val = sc.nextDouble();
			if (val < 0) {
				System.out.println("Invalid. Must be greater than zero!");
			} else
				break;
		}
		return val;
	}

}