/**
 * @author Youser Alalusi
 * Ben White - CSC15
 * 3/11/2020
 */
import java.util.Scanner;
public class Lab4Main {
	
	// Main method with scanner and calls methods from Lab4Helper
	public static void main(String[] args) {
	Scanner kb = new Scanner(System.in);
	run(kb);
	//Lab4Helper.probableSeason(0);
	//Lab4Helper.sentenceAnalyser(null);
	//Lab4Helper.getOption(kb);

	}

	// Run method to run all functions in loop
	public static void run(Scanner kb) {
		int loop = 0;
		System.out.print("How many times do you want to run this program? ");
		loop = Integer.parseInt(kb.nextLine());
	for(int i = 1; i <= loop; i++){
		System.out.println("");
		System.out.println("count: " + i);
		String input = Lab4Helper.getOption(kb); // get user option

	// Call sentence analyzer function
	if(input.equals("Sentence analyzer")) {
		System.out.print("Enter a sentence:");
		String sen = kb.nextLine();
		String output = Lab4Helper.sentenceAnalyser(sen);
		System.out.println("Sentence \""+sen+"\" is a "+ output+ " sentence");
	}

	// Call probable season function
	else if(input.equals("Probable Season")) {
		System.out.print("Enter a temperature in Fahrenheit:");
		double temp = Double.parseDouble(kb.nextLine());
		String out = Lab4Helper.probableSeason(temp);
	if(out == null) {
		System.out.println("The temp is out of range");
	}
	
	else {
		System.out.println("The probable season associated with " + temp + " Fahrenheit is " + out);
	}
}

	else
		System.out.println(input);
	}
	}

}