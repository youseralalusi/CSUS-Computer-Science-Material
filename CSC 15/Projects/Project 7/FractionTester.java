/**
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * Project 7
 * 5/3/2020
 */
public class FractionTester {
	// Main method
	public static void main(String[] args) {
		// Print first part
		System.out.println("Testing constructor for f1 = 12/8");
		Fraction f1 = new Fraction(12,8);
		System.out.println("f1 = "+f1);
		// Print part two
		System.out.println("\nTesting mutators and accessors, setting numeator to 8 and denominator to 12");
		f1.setNumerator(8);
		f1.setDenominator(12);
		System.out.println("Numerator = "+f1.getNumerator()+", Denominator = "+f1.getDenominator());
		// Print part three
		System.out.println("\nTesting fraction reduction and conversion to double");
		Fraction reducedF1 = f1.getReducedFraction();
		System.out.println("f1 reduced is "+reducedF1);
		System.out.printf("f1 as a decimal is %.2f\n",f1.getDoubleFraction());
		// Print final part
		System.out.println("\nTesting Equals Method");
		f1.setNumerator(15);
		f1.setDenominator(5);

		Fraction f2 = new Fraction(6,7);
		Fraction f3 = new Fraction(3,1);
		Fraction f4 = new Fraction(6,7);

		System.out.println("f1 = "+f1);
		System.out.println("f2 = "+f2);
		System.out.println("f3 = "+f3);
		System.out.println("f4 = "+f4);

		if(f1.equals(f2))
			System.out.println("f1 is equal to f2");
		else
			System.out.println("f1 is NOT equal to f2");

		if(f1.equals(f3))
			System.out.println("f1 is equal to f3");
		else
			System.out.println("f1 is NOT equal to f3");

		if(f2.equals(f4))
			System.out.println("f2 is equal to f4");
		else
			System.out.println("f2 is NOT equal to f4");

		if(f3.equals(f4))
			System.out.println("f3 is equal to f4");
		else
			System.out.println("f3 is NOT equal to f4");


	}

}