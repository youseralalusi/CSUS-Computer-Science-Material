
/**
 * Supporting methods for the Show Interest program.
 * @author Youser Alalusi
 * CSC 15 - Ben White 
 */

import java.util.Scanner;
 public class ShowInterestHelper {

		/**
		 * This method gets the user's name and reformats so the last name is first,
		 * converts it to upper case and returns the result
		 * @param kb to read from System.in
		 * @return the person's last name and then first name. All in upper case.
		 */
	
	public static String getName(Scanner kb) {
		System.out.print("Enter your first name and last name: ");
		String name = kb.nextLine();
		int space = name.indexOf(" ");
		String first = name.substring(0, space);
		String last = name.substring(space + 1);
		String full = last + " " + first;
		full = full.toUpperCase();
		return full;
		
	}
	
	/**
	 * This method gets the phone number, and reformats it to have dashes
	 * as shown in the sample output and returns the result
	 * @param kb for reading from System.in
	 * @return the phone number formatted with dashes
	 */
	public static String getTelephone(Scanner kb) {
		System.out.print("Enter your phone number in the format(123 456 7890): ");
		String number = kb.nextLine();
		int space = number.indexOf(" ");
		int space2 = number.lastIndexOf(" ");
		String Zip = number.substring(0, space);
		String Last4 = number.substring(space2 + 1);
		return number;
	}
	
	/**
	 * This method gets the address, reformats the result as shown
	 * in the sample output and returns the result
	 * @param kb for reading from System.in
	 * @return the address formatted according to the sample output
	 */
	public static String getAddress(Scanner kb) {
		System.out.println("Enter your address in the following format(6000 J street:Sacramento:CA 95819):");
		String address = kb.nextLine();
		int space = address.indexOf(":");
		String Line1 = address.substring(0, space);
		int space2 = address.lastIndexOf(":");
		String Line2 = address.substring(space + 1, space2);
		String Line3 = address.substring(space2 + 1);
		return Line1 + "\n\t" + Line2 + "\n\t" + Line3;
	}
	
	/**
	 * Calculates the amount of the interest deposited to the account after each
	 * month. the formula for this is amount * rate / 100
	 * @param amount the amount in the account
	 * @param rate the interest rate (1.25 is 1.25%)
	 * @return the interest earned on the account
	 */
	public static double getInterest(double amount, double rate) {
		
		return (amount * rate) / 100;
	}
	
	/**
	 * Rounds the given double value to two decimal points
	 * @param n the number to be rounded
	 * @return the number rounded to two decimal points
	 */
	public static double round2(double n) {
		return Math.round(n * 100.0) /  100.0;
	}
}

