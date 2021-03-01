/**
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * 4/15/2020
 */
import java.util.Scanner;

public class ScoresMain {
	public static void main(String[] args) {

		// Scanner class
		Scanner s = new Scanner(System.in);

		do {

			runProgram(s);//running the program

		} while (ScoresHelper.getRunAgain(s));//checking for another run

		s.close();

	}

	// Running the program 
	public static void runProgram(Scanner s) {
		printIntroduction();
		int[] scores = ScoresHelper.createArray(s);
		int best = ScoresHelper.findMaxGrade(scores);
		outputResults(scores, best);

	}

	// Header of the Grading Program
	public static void printIntroduction() {
		System.out.println("\tWelcome to the Grading Program!");
		System.out.println("============================================");
		System.out.println("you will be prompted to enter the number");
		System.out.println("of students that tou have to grade. Next,");
		System.out.println("you need to enter the scores. The results");
		System.out.println("will print int a table with the weighted");
		System.out.println("grades.");
		System.out.println(" ");
		System.out.println(" ");
	}

	// Showing output in a tabular form
	public static void outputResults(int[] scores, int best) {
		System.out.println("Here are your results: ");
		System.out.printf("%10s%10s%10s\n", "Student", "Score", "Grade");
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%10d%9d%10c\n", i + 1, scores[i], ScoresHelper.getLetterGrade(scores[i], best));
		}
	}
}