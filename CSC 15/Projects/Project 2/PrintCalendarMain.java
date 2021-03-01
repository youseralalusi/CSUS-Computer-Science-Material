import java.util.Scanner;

/**
 * A program that prints a calendar month or year.
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * March 21, 2020
 */
public class PrintCalendarMain {
	static PrintCalendarHelper pch = new PrintCalendarHelper();
	/**
	 * Use the getValidInt() method to get a valid year between 1800 and 3000. Within the
	 * do loop, add code where it has the "your code" comment to prompt them to enter a "y" or an "m"
	 * and if they answer "m" you will also need to ask them for a number between 1 and 12 using
	 * the getValidInt() method. If they answered "y" then print out every month for that year. 
	 * If they answered "m" then print out just the one month. If they answered anything else then
	 * output an error message.
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// Prompt the user to enter the year
		int min = 1800, max = 3000, month;

		Scanner sc = new Scanner(System.in);
		boolean repeat;

		do

		{
			// your code

			String prompt = "Enter a year between " + min + " and " + max + ": ";

			int year = PrintCalendarHelper.getValidInt(sc, prompt, min, max);
			System.out.println("Select the following options : ");
			System.out.println("To get the month calender press m or M: ");
			System.out.println("To get the year calender press y or Y: ");
			System.out.print("Enter your choice : ");
			char choice = sc.next().charAt(0);

			if(choice == 'm' || choice == 'M')
			{
				while(true)
				{
					System.out.print("Enter the month of the year (1 through 12): ");
					month = sc.nextInt();
					if(month >= 1 && month <= 12)
						break;
				}
				printMonth(year,month);

			}
			else if(choice == 'y'|| choice == 'Y')
			{
				for(int i = 1;i <= 12; i++)
				{
					printMonth(year,i);
				}
			}
			String answer;
			do {
				System.out.print("Do you have another year to print the calender:yes/no--> ");
				answer = kb.next();
			} while (!answer.equalsIgnoreCase("no") && !
					answer.equalsIgnoreCase("yes"));
			repeat = answer.equalsIgnoreCase("yes");
		} while (repeat); 
	}

	/**
	 * Outputs a month on the calendar for a given year. Use the printTitle() and the
	 * printMonthBody() methods to do the actual printing
	 * @param year The year to print
	 * @param month The month to print
	 */
	public static void printMonth(int year, int month) {
		// call the method printTitle with the values year and month
		printMonthTitle(year,month);

		// call the method printMonthBody with the values year and month
		printMonthBody(year,month);

	}
	/**
	 * Prints the month name, a separator line and then the days of
	 * the week (Sun, Mon, ..., Sat)
	 * @param year The year of the month title to print.
	 * @param month The month to print.
	 */
	public static void printMonthTitle(int year, int month) {
		// output the title for each month of the year
		System.out.println("        " + PrintCalendarHelper.getMonthName(month) + " " + year);
		System.out.println("-----------------------------");

	}
	/**
	 * This method prints the body of the calendar for the given month by first
	 * determining the start day of the month (using the getStartDay() method)
	 * and then calling the print method to actually print the rest of the
	 * calendar.
	 * @param year The year of the month to print
	 * @param The month to print. (1 = January and 12 = December)
	 */
	public static void printMonthBody(int year, int month) {
		// call the method getStartDay to get the start day for the given month of
		// the year

		// call the method print to print the calendar for the month and pass
		// the first day of the month as the parameter
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
		print(PrintCalendarHelper.getStartDay(year, month), year, month);

	}

	/**
	 * Prints the calendar for the given month.
	 * @param startDay The day of the week that the month begins on.
	 * (0 = Sunday and 6 = Saturday)
	 * @param year The year of the month
	 * @param month The month to print. (1 = January and 12 = December)
	 */
	public static void print(int startDay, int year, int month) {
		// call the method getNumberOfdaysInMonth to find out the number of the
		// days in the month
		// use a for loop to print spaces up to the start day for each month
		// use another for loop to print the rest of the days in the calendar
		// if the month is November calculate the thanksgiving day and output
		int i;
		for (i = 0; i <startDay; ++i){
			System.out.print(" ");
		}
		for (i = 1; i <= pch.getNumberOfDaysInMonth(year, month); ++i)
		{
			System.out.printf(" %2d",i);
			if ((i + startDay) % 7 == 0)
				System.out.printf("\n");
		}

		System.out.printf("\n");


	}

}