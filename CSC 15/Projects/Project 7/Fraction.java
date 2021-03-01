/**
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * Project 7
 * 5/3/2020
 */
public class Fraction {

	private int numerator;
	private int denominator;

	// Constructor
	public Fraction(int numerator, int denominator)
	{
		// Validate the denominator != 0
		if(denominator == 0)
			throw new IllegalArgumentException("Denominator cannot be 0"); // if 0 throw IllegalArgumentException
		// Set numerator and denominator
		this.numerator = numerator;
		this.denominator = denominator;

	}

	// Method to set the denominator
	public void setNumerator(int newNumerator)
	{
		this.numerator = newNumerator;
	}

	// Method to set the denominator
	public boolean setDenominator(int newDenominator)
	{
		if(newDenominator == 0) // if input denominator = 0, don't update denominator and return false
			return false;
		// Update denominator and return true
		this.denominator = newDenominator;
		return true;

	}

	// Method to return denominator
	public int getDenominator()
	{
		return denominator;
	}

	// Method to return numerator
	public int getNumerator()
	{
		return numerator;
	}

	// Method to return fraction(numerator/denominator) value as a double
	public double getDoubleFraction()
	{
		return ((double)numerator)/denominator;
	}

	// Method to return reduced Fraction Object
	public Fraction getReducedFraction()
	{
		// Get gcd of numerator and denominator
		int gcf = gcd(); 
		// Create a new fraction by dividing numerator and denominator by gcd
		return new Fraction(numerator/gcf,denominator/gcf);
	}

	// Method to return true if fractions are equal else false
	public boolean equals(Fraction otherFraction)
	{
		// Get reduced fraction for this and otherFraction
		Fraction reduced = getReducedFraction();
		Fraction otherReduced = otherFraction.getReducedFraction();
		// Check if numerator and denominator of reduced fractions are equal
		return(reduced.numerator == otherReduced.numerator && reduced.denominator == otherReduced.denominator);
	}

	// Return String representation of Fraction
	public String toString()
	{
		return numerator+"/"+denominator;
	}

	// Helper method to calculate and return the gcd of numerator and denominator
	private int gcd()
	{
		int x,y;

		if(Math.abs(numerator) > Math.abs(denominator))
		{
			x = Math.abs(numerator);
			y = Math.abs(denominator);
		}else
		{
			x = Math.abs(denominator);
			y = Math.abs(numerator);
		}

		int r = x%y;
		while(r != 0)
		{
			x = y;
			y = r;
			r = x%y;
		}

		return y;
	}

}