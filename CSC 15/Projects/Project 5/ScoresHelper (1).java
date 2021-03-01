/**
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * 4/15/2020
 */
import java.util.Scanner;

public class ScoresHelper {

	// For creating an array of scores
	public static int[] createArray(Scanner s) {

		// Taking size input
		int size = getValidInt(s, "Enter the number of students: ");

		int[] scores = new int[size];

		// Taking scores input
		System.out.println("Enter " + size + " scores: ");
		for (int i = 0; i < size; i++) {
			scores[i] = getValidInt(s, "Score " + (i + 1) + ": ");
		}

		return scores;
	}

	// Finding max grade
	public static int findMaxGrade(int[] scores) {
		int max = scores[0];

		for (int i = 1; i < scores.length; i++) {
			if (max < scores[i])
				max = scores[i];//getting max grade
		}

		return max;
	}

	// For getting letter grade
	public static char getLetterGrade(int score, int best) {
		char letter;

		if (score >= best - 10)
			letter = 'A';
		else if (score >= best - 20)
			letter = 'B';
		else if (score >= best - 30)
			letter = 'C';
		else if (score >= best - 40)
			letter = 'D';
		else
			letter = 'F';

		return letter;

	}

	// Validating user input
	public static int getValidInt(Scanner s, String prompt) {
		System.out.print(prompt);
		int input;
		
		// Checking for valid int input
		while(!s.hasNextInt()) {
			System.out.print("Enter the number of students: ");
			s.next();
		}
		input = s.nextInt();

		return input;
	}

	// Checking for another run
	public static boolean getRunAgain(Scanner sc) {
		String response;
		while (true) {
			System.out.print("Do yo have another test to score? ");
			response = sc.nextLine();
			if (response.equalsIgnoreCase("yes"))
				return true;
			else if (response.equalsIgnoreCase("no"))
				return false;
			else
				System.out.println("Please enter yes or no.");
		}
	}
}