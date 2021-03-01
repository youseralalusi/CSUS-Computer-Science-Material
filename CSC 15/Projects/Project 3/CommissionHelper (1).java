/** 
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * March, 29, 2020
 */
import java.util.Scanner;

public class CommissionHelper {

	public static final double MAX_RATE = 25;

	/**
	 * Calculates the commission earned on a given amount of sales.
	 *
	 * @param saleAmount The amount of sales
	 * @param baseRate The base rate
	 * @param increment The increment to the base rate
	 * @param interval The sale interval that will increase commission
	 * @return The total commission
	 */

	public static double commission(double saleAmount, double baseRate, double increment, double interval) {
		double totalCommission = 0.0;
		double sales = saleAmount;
		double rate = baseRate;

		while(sales > interval )
		{
			// add to the totalCommission the rate/100 * interval
			totalCommission = totalCommission + (rate / 100 * interval);
			// subtract the interval from the sales total
			sales = sales - interval;
			// if rate + increment is less than the max rate then add increment
			// to the rate
			if((rate + increment) < MAX_RATE) {
				rate = rate + increment;
			}
			// otherwise, is the max rate
			else {
				rate = MAX_RATE;
			}
		}
		if (sales > 0)
			// calculate the leftover
			totalCommission = totalCommission + (rate / 100 * sales);  
		return totalCommission;
	}

	/**
	 * Gets a double from the user, should loop until they enter a double and not
	 * crash if they enter text
	 * @param kb System.in Scanner
	 * @param prompt The user prompt
	 * @return A double
	 */
	public static double getValidDouble(Scanner kb, String prompt) {
		double amount = 0;
		while(true) {
			System.out.print(prompt);
			try {
				amount = Double.parseDouble(kb.nextLine());
				if(amount < 0) {
					System.out.println("can not take negative number!");
				}
				else {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Non number value entered!");
			}
		}
		return amount;
	}

}