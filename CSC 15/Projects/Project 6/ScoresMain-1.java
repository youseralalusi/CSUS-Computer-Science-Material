/**
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * 4/15/2020
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoresMain {

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner class object which is used to get inputs entered by user
		Scanner s = new Scanner(System.in);
		boolean b=false;
		do{
			runProgram(s);
			b=ScoresHelper.getRunAgain(s);

		}

		while(b);

	}

	public static void outputResults(int[] scores, int best) {
		System.out.println("Here are the results :");
		System.out.println("Student\tScore\tGrade");
		for(int i=0;i<scores.length;i++) {


			System.out.println((i+1)+"\t"+scores[i]+"\t"+ScoresHelper.getLetterGrade(scores[i], best));

		}

	}

	// Modified runProgram
	public static void runProgram(Scanner s) throws FileNotFoundException {
		printIntroduction();
		int scores[]=null;
		// Getting user choice
		int choice = ScoresHelper.getUserChoice(s);

		// Inputting scores from console
		if(choice == 1){
			scores=ScoresHelper.createArray(s);

		}

		// Inputting scores from file
		else{

			scores=ScoresHelper.createArray(ScoresHelper.getFile(s, "Error, cannot read from file, please try again."));

		}

		int best=ScoresHelper.findMaxGrade(scores);
		outputResults(scores,best);

	}

	public static void printIntroduction() {
		System.out.println(" Welcome to the Grading Program! ");
		System.out.println("=========================================");
		System.out.println("You will be prompted to enter the number ");
		System.out.println("of students that you have to grade. Next,");
		System.out.println("you need to enter the scores. The results");
		System.out.println("will print in a table with the weighted ");
		System.out.println("grades.");

	}

}