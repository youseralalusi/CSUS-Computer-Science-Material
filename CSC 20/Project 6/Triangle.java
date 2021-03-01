// Triangle

public class Triangle extends GeometricObject {
   private double side1;
   private double side2;
   private double side3;

   public Triangle() {
       this.side1 = 1;
       this.side2 = 1;
       this.side3 = 1;
   }

   public Triangle(double side1, double side2, double side3) {
       if ((side1 + side2) > side3 && (side2 + side3) > side1
               && (side3 + side1) > side2) {
           this.side1 = side1;
           this.side2 = side2;
           this.side3 = side3;
       }
   }
  

   /**
   * @return the side1
   */
   public double getSide1() {
       return side1;
   }

   /**
   * @param side1 the side1 to set
   */
   public void setSide1(double side1) {
       this.side1 = side1;
   }

   /**
   * @return the side2
   */
   public double getSide2() {
       return side2;
   }

   /**
   * @param side2 the side2 to set
   */
   public void setSide2(double side2) {
       this.side2 = side2;
   }

   /**
   * @return the side3
   */
   public double getSide3() {
       return side3;
   }

   /**
   * @param side3 the side3 to set
   */
   public void setSide3(double side3) {
       this.side3 = side3;
   }

   
   public double getArea() {
       // calculating the semi perimeter
       double s = (side1 + side2 + side3) / 2.0;
       // calculating area
       double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
       return area;
   }

   
   public double getPerimeter() {
       return side1 + side2 + side3;
   }

   
   public String toString() {
       return "Triangle :: Side1: " + side1 + " Side2: " + side2 + " Side3: "
               + side3 ;
   }

   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (!(obj instanceof Triangle))
           return false;
       Triangle other = (Triangle) obj;
       if (Double.doubleToLongBits(side1) != Double
               .doubleToLongBits(other.side1))
           return false;
       if (Double.doubleToLongBits(side2) != Double
    		   .doubleToLongBits(other.side2))
    	   return false;
       if (Double.doubleToLongBits(side3) != Double
    		   .doubleToLongBits(other.side3))
    	   return false;
       return true;
   }

}