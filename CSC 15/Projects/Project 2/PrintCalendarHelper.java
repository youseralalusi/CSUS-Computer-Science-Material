import java.util.Scanner;

/**
 * Helper methods for the Calendar program
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * March 21, 2020
 */
public class PrintCalendarHelper {
	/**
	 * Prompts the user and returns a number between min and max. Continually prompts until
	 * a valid number is entered.
	 * @param s The Scanner object to read from System.in
	 * @param prompt The prompt for the user
	 * @param min The smallest value that the number can be.
	 * @param max The largest value that the number can be.
	 * @return A number between min and max.
	 */
	public static int getValidInt(Scanner s, String prompt, int min, int max) {
		int result;
		// Loop until valid input is read in
		do {
			// Prompt user and loop until they have entered a number
			System.out.print(prompt);
			while (!s.hasNextInt()) {
				s.nextLine();
				System.out.print(prompt);
			}

			// Read in the number
			result = s.nextInt();
		} while (result < min || result > max);

		// Return the result
		return result;
	}

	/**
	 * This method calculates the day that Thanksgiving is on. Thanksgiving is always
	 * on the fourth Thursday of November. Depending on the first day of the month,
	 * a constant needs to be added to 3 * 7 since we have three full weeks. For example,
	 * if the first day of the month is on a Sunday then for that month Thanksgiving
	 * will be on 5 + 3 * 7 = 26th day of November.
	 * @param startDay The day of the week that November starts on (0 = Sunday)
	 * @return The day in November that Thanksgiving is on
	 */
	public static int thanks(int startDay) {
		int thanks = 0;
		if(startDay >= 0 && startDay < 5)
		{ 
			thanks = (5 - startDay) + 21;
		}
		else if(startDay == 5)
		{
			thanks = 7 + 21;
		}
		else if(startDay == 6)
		{
			thanks = 6 + 21;
		}
		return thanks;
	}
	/**
	 * Given the Month number (1 through 12), returns the month name (January through December).
	 * This works well with a switch statement if you would like to use one.
	 * @param month The month number (1 through 12)
	 * @return The month name (January through December) 
	 */
	public static String getMonthName(int month) {
		String monthName = "";
		switch(month){
		case 1: monthName = "January"; break;
		case 2: monthName = "February"; break;
		case 3: monthName = "March"; break;
		case 4: monthName = "April"; break;
		case 5: monthName = "May"; break;
		case 6: monthName = "June"; break;
		case 7: monthName = "July"; break;
		case 8: monthName = "Aubuest"; break;
		case 9: monthName = "September"; break;
		case 10: monthName = "October"; break;
		case 11: monthName = "November"; break;
		case 12: monthName = "December"; break;
		}
		return monthName;

	}

	/**
	 *  This method returns the day of the week that the first day of a month occurs on. First it uses the
	 *  getTotalNumberOfDays() method to get the number of days elapsed since January 1st, 1800 which was
	 *  on a Wednesday (3). With total number of days since 1/1/1800 we can add 3 and then mod by 7 to get
	 *  the day of the week that a month starts on.
	 *  @param year The year for the month to determine
	 *  @param month The month to determine
	 *  @return The day of the week that the month begins on. 0 = Sunday and 6 = Saturday.
	 */
	public static int getStartDay(int year, int month) {
		// call the method getTotalNumberOfDays and store it in a variable
		// called start
		// add 3 to the variable start
		// return start % 7  
		int startDay1800 = 3;
		int totalNumberOfDays = getTotalNumberOfDays(year, month);
		return (totalNumberOfDays + startDay1800) % 7;

	}

	/**
	 * Returns the total number of the days up to the given month in the given
	 * year since January 1st, 1800. For example, passing 2 for the month (February) and 1800
	 * for the year should return 31 since 31 days would have had to pass to get to 2/1/1800.
	 * Similarly, passing 2 for the month and 1801 for the year should return 396 (365 + 31)
	 * since 1800 was not a leap year. This method should use getNumberOfDaysInMonth() and
	 * isLeapYear() to calculate the result.
	 * @param year The year for the month to determine
	 * @param month The month to determine
	 * @return The total number of days up to the given month for a given year. For example,
	 * passing 2 for the month (February) should return 31 because there are always 31
	 * days before February.
	 */
	public static int getTotalNumberOfDays(int year, int month) {
		int sum = 0;
		for(int i = 1800; i <= year; i++)
			if(isLeapYear(i))
				sum = sum + 366;
			else
				sum = sum + 365;
		for(int i = 1; i < month; i++)
			sum = sum + getNumberOfDaysInMonth(year, i);

		return sum;

	}

	/**
	 * Returns the number of the days in the given month of the given
	 * year. Take leap year into consideration.
	 * @param year The year for the month to determine
	 * @param month The month to determine
	 * @return The total number of days in the given month.
	 */
	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;

		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;

		if (month == 2) return isLeapYear(year) ? 29 : 28;
		return 0; 
	}
	/**
	 *  Returns true if the given year is leap, false otherwise.
	 *  @param year The year to determine
	 *  @return True if a leap year, false otherwise.
	 */
	public static boolean isLeapYear(int year) {
		// A year is a leap year if it is divisible by 400 or
		// if the year is divisible by 4 but not divisible by 100
		return(year %400 == 0 || year%4 == 0 && year %100 != 0);

	}

}