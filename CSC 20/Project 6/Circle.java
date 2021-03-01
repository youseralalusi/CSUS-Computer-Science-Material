// Circle

public class Circle extends GeometricObject {
	private double radius;

	/**
	 * @param radius
	 */
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	/**
	 * @param radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius
	 * the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double getArea() {
		return Math.PI * radius * radius;
	}


	public String toString() {
		return "Circle with radius " + radius + " " + super.toString();
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public double getDiameter() {
		return 2 * radius;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Circle))
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double
				.doubleToLongBits(other.radius))
			return false;
		return true;
	}

}