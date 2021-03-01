public class Rectangle extends GeometricObject {
	private double width;
	private double height;

	public Rectangle() {
		this.width = 0.0;
		this.height = 0;
	}

	/**
	 * @param width
	 * @param height
	 */
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * @param width
	 * @param height
	 */
	public Rectangle(double width, double height, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width
	 * the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 * the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	public double getArea() {
		return width * height;
	}

	public String toString() {
		return "Rectangle with width " + width + " Height " + height + " "
				+ super.toString();
	}

	public double getPerimeter() {
		double perimeter = 2 * (width + height);
		return perimeter;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Rectangle))
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(height) != Double
				.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(width) != Double
				.doubleToLongBits(other.width))
			return false;
		return true;
	}

}