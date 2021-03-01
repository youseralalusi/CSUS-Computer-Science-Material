/**
 * @author Youser Alalusi
 * CSC 15 - Ben White
 * 4/15/2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ScoresHelper {

	// Scanner class object which is used to get inputs entered by user
	Scanner s =new Scanner(System.in);

	// Implementing getUserChoice
	public static int getUserChoice(Scanner s){
		printMenu();
		System.out.println("Enter your selection:");
		int choice=s.nextInt();
		while(!(choice==1||choice==2)){
			System.out.println("Error, you must enter a selection from the menu");
			System.out.println("Enter your selection: ");
			choice=s.nextInt();

		}

		return choice;

	}

	// Implementing printMenu
	public static void printMenu(){
		System.out.println("\n\n\nData Input Method Menu");
		System.out.println("-------------------------------");
		System.out.println("1. Input scores. ");
		System.out.println("2. Read scores from a file. ");

	}

	// Implementing getFile
	public static File getFile(Scanner s,String prompt){
		System.out.print("Please input the name of file: ");
		File file=new File(".//"+s.next());
		while(!file.exists()){
			System.out.println(prompt);
			System.out.print("Please input the name of file: ");
			file=new File(".//"+s.next());

		}

		return file;

	}

	// Implementing getNumsInts
	public static int getNumsInts(File f){
		Scanner s;
		int size=0;
		try {

			s = new Scanner(f);
			while(s.hasNextInt()){
				size++;
				s.nextInt();

			}

			s.close();

		} 

		catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		return size;

	}

	// Implementing createArray(File)
	public static int[] createArray(File f)throws FileNotFoundException{
		Scanner s=new Scanner(f);
		int size=getNumsInts(f);
		int scores[] = new int[size];
		for(int i = 0; i<size;i++)
			scores[i]=s.nextInt();
		return scores;

	}

	public static int[] createArray(Scanner s) {
		int size;
		int scores[] = null;
		size=getValidInt(s,"Enter the number of students: ");
		scores = new int[size];
		System.out.println("Enter " + size + " scores:");
		for (int i = 0; i < size; i++)
			scores[i]=getValidInt(s,"Score " + (i + 1) + ": ");
		return scores;

	}

	public static int findMaxGrade(int scores[]) {
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];

			}

		}

		return max;

	}

	// Creating a method which determines the letter of the grade
	public static char getLetterGrade(int score, int best) {
		char gradeLetter = 0;
		if (score >= best-10)
			gradeLetter = 'A';
		else if (score >= best-20)
			gradeLetter = 'B';
		else if (score >= best-30)
			gradeLetter = 'C';
		else if (score >= best-40)
			gradeLetter = 'D';
		else
			gradeLetter = 'F';

		// Returning the integer output
		return gradeLetter;

	}

	public static int getValidInt(Scanner s, String prompt) {
		// Print the prompt
		System.out.print(prompt);

		// loop while not an integer
		while(!s.hasNextInt()) {

			// Discard input and reprint the prompt
			s.nextLine();
			System.out.print(prompt);

		}

		int result = s.nextInt();
		s.nextLine();

		// Returning the result
		return result;

	}



	public static boolean getRunAgain(Scanner s){
		String str="";
		boolean b=false;

		// Creating a loop until a valid answer is input
		while(true){

			// Print a prompt
			System.out.print("\nDo you have another test to score? ");

			// Read the string
			str=s.next();
			if(str.equalsIgnoreCase("Yes")){
				b=true;
				break;

			}

			else if(str.equalsIgnoreCase("No")){
				b=false;
				break;

			}

			else{
				System.out.println("Please enter yes or no.");

			}

		}

		return b;

	}

}