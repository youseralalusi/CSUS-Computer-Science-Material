// Notepad notes provided

import java.util.Scanner;
public class NameHelper {
	/**
	 * Promps the user to enter their name as First Last
	 * and then returns it as Last, First
	 * 
	 * @param y Scanner for System.in
	 * @return The name formatted correctly
	 */
	public static String getFormattedName(Scanner y) {
		// Prompt the user and get their name
		System.out.print("Please eneter your first and last name seperated by a space: ");
		String name = y.nextLine();
		
		// Split into first and last name
		int spaceLocation = name.indexOf(" ");
		String first = name.substring(0, spaceLocation);
		String last = name.substring(spaceLocation +1);
		
		// Return the result formatted as Last, First
		return last + ", " + first;
	}
	
	/**
	 * Prompt the user to enter the number of units that they are taking,
	 *  their major, and their university
	 * @param y Scanner to read from System.in
	 * @return A formatted string of student information
	 */
	public static String getStudentData(Scanner y) {
		// Prompt the user 
		System.out.print("Please enter you rnumber of units, major and school. Seperate with spacesA: ");
		
		// Read in the number of units, their major and their school
		int numUnits = y.nextInt();
		String major = y.next();
		String school = y.nextLine();
		
		// Return the formatted result
		return school + "\nDept: " + major + "\nUnits: " + numUnits;
		
	}
}
