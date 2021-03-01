/** 
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * March, 29, 2020
 */

import java.util.Scanner;

public class ComissionMain {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		run(kb);
	}

	/**
	 * Prompts the user how many times they want to use the program and calls
	 * the saleAmount method that many times
	 * @param kb Scanner for System.in
	 */

	public static void run(Scanner kb) {
		boolean repeat = true;
		while (repeat) {
			// call the method saleAmount
			saleAmount(kb);
			// ask the user if he/she wants to use the app again
			System.out.println();
			System.out.print("Do you want to use the app again(yes/no)? ");
			String user_input = kb.nextLine();
			// update the loop control variable based on the user's input
			if(user_input.equalsIgnoreCase("no")) {
				repeat = false;
			}
		}
	}

	/**
	 * Prompts the user for the input parameters and calculates how much you
	 * have to sell to reach the desired commission
	 * @param kb A System.in Scanner
	 */
	public static void saleAmount(Scanner kb) {
		double salesAmount = 0;
		double goalAmount = 0;
		// call the method getValidDouble to get the sale goal amount
		String prompt = "Enter a positive amount for commission goal that you want to get: ";
		goalAmount = salesAmount = CommissionHelper.getValidDouble(kb, prompt);
		if(salesAmount < 0) {
			System.out.println("Invalid commission goal!");
			return;
		}

		// call the method getValidDouble to get the base rate
		double baseRate = 0;
		prompt = "Enter a positive amount base rate for commission: ";
		baseRate = CommissionHelper.getValidDouble(kb, prompt);
		if(baseRate > CommissionHelper.MAX_RATE) {
			System.out.println("Base rate can not exceed Maximum commission rate!");
			return;
		}

		// call the method getValidDouble to get the percent that the commission
		// increases
		double increment = 0;
		prompt = "Enter a positive amount of percent increase for commission: ";
		increment = CommissionHelper.getValidDouble(kb, prompt);
		if(increment > CommissionHelper.MAX_RATE) {
			System.out.println("increment rate can not exceed Maximum commission rate!");
			return;
		}

		// call the method getValidDouble to get the sale interval that the
		// commission increases
		double interval = 0;
		prompt = "Enter a positive amount for the sale interval that commission increases: ";
		interval = CommissionHelper.getValidDouble(kb, prompt);

		double commission = 0;
		while (commission < goalAmount)
		{
			// call the method commission
			commission = CommissionHelper.commission(salesAmount, baseRate, increment, interval);
			// if the commission is less than the goal
			// increase the sale amount by 0.1
			if(commission < goalAmount) {
				salesAmount = salesAmount + (salesAmount * 0.1);
			}
		}
		// output the result
		System.out.println(String.format("To get the %.2f of commission, you need to have %.2f of sale", goalAmount, salesAmount));
	}

}