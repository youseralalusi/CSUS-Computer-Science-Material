/**
 * Program to show how money increases over time given a particular interest
 * rate and regular deposit amount. The program is written with parameters
 * so that these values could be changed to compute a different interest rate,
 * @author Youser Alalusi
 * CSC 15 - Ben White 
 */

import java.util.Scanner;
public class ShowInterestMain {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		description();
		// ask how many times do you want to use this app
		System.out.print("How many times do you wish to use this app? ");
		
		// get the user's input
		int times = kb.nextInt();
		kb.nextLine();
		System.out.println();
		System.out.println();

		// for(1 to count)
		for(int i = 1; i <= times; i++) {
			
		
			// call the method getInfo
			getInfo(kb);
			// call the method getInterest
			getInterest(kb);
		}
		
	}
	
	/**
	 * This method calls getName, getTelephone, getAddress and outputs the
	 * user's info on the screen
	 * @param kb for reading System.in
	 */
	public static void getInfo(Scanner kb) {
		String name = ShowInterestHelper.getName(kb);
		String phone = ShowInterestHelper.getTelephone(kb);
		String address = ShowInterestHelper.getAddress(kb);
		System.out.println("****************************");
		System.out.println("Name: " + name);
		System.out.println("Phone: " + phone);
		System.out.println("Address: " + address);
		System.out.println("****************************");
	}
	/**
	 * This method asks the info such as initial amount, number of years,
	 * interest rate, monthly deposit then calls the method printTable and
	 * passes the info needed to that method
	 * @param kb for reading from System.in
	 */
	public static void getInterest(Scanner kb) {
		System.out.print("Enter the initial amount: ");
		int initial = kb.nextInt();
		kb.nextLine();
		System.out.println();
		System.out.print("Enter the number of the years: ");
		int numOfYears = kb.nextInt();
		kb.nextLine();
		System.out.println();
		System.out.print("Enter the interest rate: ");
		double interest = kb.nextDouble();
		kb.nextLine();
		System.out.println();
		System.out.print("Enter the monthly deposit: ");
		int monthly = kb.nextInt();
		kb.nextLine();
		System.out.println();
		
		printTable(initial, numOfYears, interest, monthly);
	}
	/**
	 * Displays a description of the application
	 */
	public static void description(){
		System.out.println("***************WELCOME TO INTEREST CALCULATOR WEBSITE***************************");
		System.out.println("");
		System.out.println("Program to show how money increases over time given a particular interest");
		System.out.println("rate and a regular deposit amount.");
		System.out.println("");
		System.out.println("");
		System.out.println("*******************************************************************************");
		
	}
	
	/**
	 * With all the parameters necessary for creating the table, calculates
	 * and outputs how money increases over time. Must match the sample
	 * output provided.
	 * @param amount the initial amount in the account
	 * @param periods the number of years to compound interest
	 * @param rate the interest rate (1.25 is 1.25%)
	 * @param deposit the amount deposited yearly
	 */
	public static void printTable(double amount, int periods, double rate, double deposit) {
		System.out.println("Year\tInterest\tDeposit\tNew Balance");
		System.out.println("start\t\t\t\t\t\t\t\"" + amount);
			for(int i = 1; i <= periods; i++) {
				double interest = ShowInterestHelper.getInterest(amount, rate);
				amount += interest + deposit;
				System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n", i, interest, deposit, amount);
				
		}
	}
	}